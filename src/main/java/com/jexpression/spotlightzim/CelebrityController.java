package com.jexpression.spotlightzim;

import com.jexpression.spotlightzim.model.Celebrity;
import com.jexpression.spotlightzim.service.CelebrityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path= "api/v1/celebrity")
public class CelebrityController {
    private final CelebrityService celebrityService;

    @Autowired
    public CelebrityController(CelebrityService celebrityService) {
        this.celebrityService = celebrityService;
    }

}