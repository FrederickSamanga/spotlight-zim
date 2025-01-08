package com.jexpression.spotlightzim.service;

import com.jexpression.spotlightzim.model.Celebrity;
import com.jexpression.spotlightzim.repository.CelebrityRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CelebrityService {
    private final CelebrityRepository celebrityRepository;

    @Autowired
    public CelebrityService(CelebrityRepository celebrityRepository) {
        this.celebrityRepository = celebrityRepository;
    }

    public List<Celebrity> getCelebrities() {
        return celebrityRepository.findAll();
    }

    public List<Celebrity> getCelebrityFromProfession(String profession) {
        return celebrityRepository.findAll().stream()
                .filter(celebrity -> profession.equals(celebrity.getProfession().toString()))
                .collect(Collectors.toList());
    }

    public List<Celebrity> getPlayersByName(String searchText) {
        return celebrityRepository.findAll().stream()
                .filter(celebrity -> celebrity.getName().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Celebrity> getTrendingCelebrities() {
        return celebrityRepository.findAll().stream()
                .filter(Celebrity::isTrending)
                .collect(Collectors.toList());
    }

    public List<Celebrity> getTopRatedCelebrities() {
        return celebrityRepository.findAll().stream()
                .sorted(Comparator.comparing(Celebrity::getRating).reversed())
                .collect(Collectors.toList());
    }

    //CRUD operations

    public Celebrity addCelebrity(Celebrity celebrity) {
        celebrityRepository.save(celebrity);
        return celebrity;
    }
    public Celebrity updateCelebrity(Celebrity updatedCelebrity) {
        Optional<Celebrity> existingCelebrity = celebrityRepository.findByName(updatedCelebrity.getName());

        if (existingCelebrity.isPresent()) {
            Celebrity celebrityToUpdate = existingCelebrity.get();
            celebrityToUpdate.setName(updatedCelebrity.getName());
            celebrityToUpdate.setProfession(updatedCelebrity.getProfession());
            celebrityToUpdate.setAge(updatedCelebrity.getAge());
            celebrityToUpdate.setNationality(updatedCelebrity.getNationality());
            celebrityToUpdate.setGender(updatedCelebrity.getGender());
            celebrityToUpdate.setShortBio(updatedCelebrity.getShortBio());
            celebrityToUpdate.setRating(updatedCelebrity.getRating());
            celebrityToUpdate.setIsTrending(updatedCelebrity.getIsTrending());
            celebrityToUpdate.setTrendingNews(updatedCelebrity.getTrendingNews());
            celebrityToUpdate.setProfilePictureUrl(updatedCelebrity.getProfilePictureUrl());
            celebrityToUpdate.setFollowerCount(updatedCelebrity.getFollowerCount());
            celebrityToUpdate.setSocialMediaHandles(updatedCelebrity.getSocialMediaHandles());

            celebrityRepository.save(celebrityToUpdate);
            return celebrityToUpdate;
        }
        return null;
    }
    @Transactional
    public void deleteCelebrity(String celebrityName) {
        celebrityRepository.deleteByName(celebrityName);
    }



}