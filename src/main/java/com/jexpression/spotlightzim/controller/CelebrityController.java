package com.jexpression.spotlightzim.controller;

import com.jexpression.spotlightzim.model.Celebrity;
import com.jexpression.spotlightzim.service.CelebrityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/api/celebrities")
public class CelebrityController {
    private final CelebrityService celebrityService;

    @Autowired
    public CelebrityController(CelebrityService celebrityService) {
        this.celebrityService = celebrityService;
    }

    @GetMapping
    public List<Celebrity> getCelebrities(
            @RequestParam(required = false) String profession,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String isTrending,
            @RequestParam(required = false) String rating
    )
    {

        if (profession != null) {
            return celebrityService.getCelebrityFromProfession(profession);
        } else if (name != null) {
            return celebrityService.getPlayersByName(name);
        } else if (isTrending != null) {
            return celebrityService.getTrendingCelebrities();
        } else if (rating != null) {
            return celebrityService.getTopRatedCelebrities();
        } else {
            return celebrityService.getCelebrities();
        }
    }

    @PostMapping
    public ResponseEntity<Celebrity> addCelebrity(@RequestBody Celebrity celebrity){
        Celebrity createdCelebrity = celebrityService.addCelebrity(celebrity);
        return new ResponseEntity<>(createdCelebrity, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Celebrity> updateCelebrity(@RequestBody Celebrity updatedCelebrity) {
        Celebrity resultCelebrity = celebrityService.updateCelebrity(updatedCelebrity);
        if (resultCelebrity != null) {
            return new ResponseEntity<>(resultCelebrity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{celebrityName}")
    public ResponseEntity<String> deleteCelebrity(@PathVariable String celebrityName) {
        celebrityService.deleteCelebrity(celebrityName);
        return new ResponseEntity<>("Player deleted successfully", HttpStatus.OK);
    }


}
