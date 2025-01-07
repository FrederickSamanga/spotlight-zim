package com.jexpression.spotlightzim.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.Map;


@Entity
public class Celebrity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID) // Generates UUID as the primary key
    private String celebrityId;

    @Column(nullable = false)
    private String fullName;

    private String nickname;

    @Column(nullable = false)
    private String gender;

    private Date dateOfBirth;

    private String placeOfBirth;

    @Column(nullable = false)
    private String nationality;

    @ElementCollection
    private List<String> languagesSpoken; // Stores multiple values in a separate table

    @Column(nullable = false)
    private String profession;

    @ElementCollection
    @CollectionTable(name = "social_media_handles", joinColumns = @JoinColumn(name = "celebrity_id"))
    @MapKeyColumn(name = "platform") // Stores platform as the key (e.g., Instagram, Twitter)
    @Column(name = "handle")
    private Map<String, String> socialMediaHandles;

    @Lob
    private String shortBio;

    @Lob
    private String careerHighlights;

    @ElementCollection
    @CollectionTable(name = "achievements", joinColumns = @JoinColumn(name = "celebrity_id"))
    @Column(name = "achievement")
    private List<String> achievements;

    @Lob
    private String personalLife;

    private String profilePictureUrl;

    private String mostPopularImageOrVideoUrl;

    @ElementCollection
    @CollectionTable(name = "follower_counts", joinColumns = @JoinColumn(name = "celebrity_id"))
    @MapKeyColumn(name = "platform")
    @Column(name = "followers")
    private Map<String, Long> followerCount;

    @ElementCollection
    @CollectionTable(name = "trending_topics", joinColumns = @JoinColumn(name = "celebrity_id"))
    @Column(name = "trending_topic")
    private List<String> trendingTopics;

    private Integer mediaMentions;

    @ElementCollection
    @CollectionTable(name = "brand_partnerships", joinColumns = @JoinColumn(name = "celebrity_id"))
    @Column(name = "brand")
    private List<String> brandPartnerships;

    @Lob
    private String weeklyNews;

    @ElementCollection
    @CollectionTable(name = "upcoming_projects", joinColumns = @JoinColumn(name = "celebrity_id"))
    @Column(name = "project")
    private List<String> upcomingProjects;

    @ElementCollection
    @CollectionTable(name = "notable_public_appearances", joinColumns = @JoinColumn(name = "celebrity_id"))
    @Column(name = "appearance")
    private List<String> notablePublicAppearances;

    @Column(nullable = false)
    private String knownFor;

    @ElementCollection
    @CollectionTable(name = "filmography", joinColumns = @JoinColumn(name = "celebrity_id"))
    @Column(name = "film")
    private List<String> filmography;

    @ElementCollection
    @CollectionTable(name = "discography", joinColumns = @JoinColumn(name = "celebrity_id"))
    @Column(name = "album_or_song")
    private List<String> discography;

    @ElementCollection
    @CollectionTable(name = "business_ventures", joinColumns = @JoinColumn(name = "celebrity_id"))
    @Column(name = "venture")
    private List<String> businessVentures;

    public Celebrity() {
    }

    public Celebrity(String celebrityId,
                     String fullName,
                     String nickname,
                     String gender,
                     Date dateOfBirth,
                     String placeOfBirth,
                     String nationality,
                     List<String> languagesSpoken,
                     String profession, Map<String,
                    String> socialMediaHandles,
                     String shortBio,
                     String careerHighlights,
                     List<String> achievements,
                     String personalLife,
                     String profilePictureUrl,
                     String mostPopularImageOrVideoUrl,
                     Map<String, Long> followerCount,
                     List<String> trendingTopics,
                     Integer mediaMentions,
                     List<String> brandPartnerships,
                     String weeklyNews,
                     List<String> upcomingProjects,
                     List<String> notablePublicAppearances,
                     String knownFor,
                     List<String> filmography,
                     List<String> discography,
                     List<String> businessVentures) {
        this.celebrityId = celebrityId;
        this.fullName = fullName;
        this.nickname = nickname;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.placeOfBirth = placeOfBirth;
        this.nationality = nationality;
        this.languagesSpoken = languagesSpoken;
        this.profession = profession;
        this.socialMediaHandles = socialMediaHandles;
        this.shortBio = shortBio;
        this.careerHighlights = careerHighlights;
        this.achievements = achievements;
        this.personalLife = personalLife;
        this.profilePictureUrl = profilePictureUrl;
        this.mostPopularImageOrVideoUrl = mostPopularImageOrVideoUrl;
        this.followerCount = followerCount;
        this.trendingTopics = trendingTopics;
        this.mediaMentions = mediaMentions;
        this.brandPartnerships = brandPartnerships;
        this.weeklyNews = weeklyNews;
        this.upcomingProjects = upcomingProjects;
        this.notablePublicAppearances = notablePublicAppearances;
        this.knownFor = knownFor;
        this.filmography = filmography;
        this.discography = discography;
        this.businessVentures = businessVentures;
    }

    public String getCelebrityId() {
        return celebrityId;
    }

    public void setCelebrityId(String celebrityId) {
        this.celebrityId = celebrityId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public List<String> getLanguagesSpoken() {
        return languagesSpoken;
    }

    public void setLanguagesSpoken(List<String> languagesSpoken) {
        this.languagesSpoken = languagesSpoken;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public Map<String, String> getSocialMediaHandles() {
        return socialMediaHandles;
    }

    public void setSocialMediaHandles(Map<String, String> socialMediaHandles) {
        this.socialMediaHandles = socialMediaHandles;
    }

    public String getShortBio() {
        return shortBio;
    }

    public void setShortBio(String shortBio) {
        this.shortBio = shortBio;
    }

    public String getCareerHighlights() {
        return careerHighlights;
    }

    public void setCareerHighlights(String careerHighlights) {
        this.careerHighlights = careerHighlights;
    }

    public List<String> getAchievements() {
        return achievements;
    }

    public void setAchievements(List<String> achievements) {
        this.achievements = achievements;
    }

    public String getPersonalLife() {
        return personalLife;
    }

    public void setPersonalLife(String personalLife) {
        this.personalLife = personalLife;
    }

    public String getProfilePictureUrl() {
        return profilePictureUrl;
    }

    public void setProfilePictureUrl(String profilePictureUrl) {
        this.profilePictureUrl = profilePictureUrl;
    }

    public String getMostPopularImageOrVideoUrl() {
        return mostPopularImageOrVideoUrl;
    }

    public void setMostPopularImageOrVideoUrl(String mostPopularImageOrVideoUrl) {
        this.mostPopularImageOrVideoUrl = mostPopularImageOrVideoUrl;
    }

    public Map<String, Long> getFollowerCount() {
        return followerCount;
    }

    public void setFollowerCount(Map<String, Long> followerCount) {
        this.followerCount = followerCount;
    }

    public List<String> getTrendingTopics() {
        return trendingTopics;
    }

    public void setTrendingTopics(List<String> trendingTopics) {
        this.trendingTopics = trendingTopics;
    }

    public Integer getMediaMentions() {
        return mediaMentions;
    }

    public void setMediaMentions(Integer mediaMentions) {
        this.mediaMentions = mediaMentions;
    }

    public List<String> getBrandPartnerships() {
        return brandPartnerships;
    }

    public void setBrandPartnerships(List<String> brandPartnerships) {
        this.brandPartnerships = brandPartnerships;
    }

    public String getWeeklyNews() {
        return weeklyNews;
    }

    public void setWeeklyNews(String weeklyNews) {
        this.weeklyNews = weeklyNews;
    }

    public List<String> getUpcomingProjects() {
        return upcomingProjects;
    }

    public void setUpcomingProjects(List<String> upcomingProjects) {
        this.upcomingProjects = upcomingProjects;
    }

    public List<String> getNotablePublicAppearances() {
        return notablePublicAppearances;
    }

    public void setNotablePublicAppearances(List<String> notablePublicAppearances) {
        this.notablePublicAppearances = notablePublicAppearances;
    }

    public String getKnownFor() {
        return knownFor;
    }

    public void setKnownFor(String knownFor) {
        this.knownFor = knownFor;
    }

    public List<String> getFilmography() {
        return filmography;
    }

    public void setFilmography(List<String> filmography) {
        this.filmography = filmography;
    }

    public List<String> getDiscography() {
        return discography;
    }

    public void setDiscography(List<String> discography) {
        this.discography = discography;
    }

    public List<String> getBusinessVentures() {
        return businessVentures;
    }

    public void setBusinessVentures(List<String> businessVentures) {
        this.businessVentures = businessVentures;
    }
}



