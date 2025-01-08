package com.jexpression.spotlightzim.model;

import jakarta.persistence.*;
import java.util.Map;


@Entity
@Table(name = "celebrities")
public class Celebrity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long celebrityId;

    @Column(nullable = false)
    private String name;

    @Column(name ="age")
    private String age;

    // === ENUMERATED TYPES
    @Column(name = "gender", nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private Nationality nationality;

   @Enumerated(EnumType.STRING)
    private Profession profession;

    @Column(name = "isTrending")
    @Enumerated(EnumType.STRING)
    private IsTrendingEnum isTrending;

    @ElementCollection
    @CollectionTable(name = "social_media_handles", joinColumns = @JoinColumn(name = "celebrity_id"))
    @MapKeyColumn(name = "platform") // Stores platform as the key (e.g., Instagram, Twitter)
    @Column(name = "handle")
    @Enumerated(EnumType.STRING)
    private Map<SocialMediaHandles, String> socialMediaHandles;

    // ==============================================================================================================================


    @Column(name = "shortBio", length = 3000)
    private String shortBio;

    @Enumerated(EnumType.STRING)
    private Rating rating;

    private String profilePictureUrl;

    @ElementCollection
    @CollectionTable(name = "follower_counts", joinColumns = @JoinColumn(name = "celebrity_id"))
    @MapKeyColumn(name = "platform")
    @Column(name = "followers")
    private Map<String, Long> followerCount;

    @Column(name = "trendingNews", length = 3000)
    private String trendingNews;

    public Celebrity() {}

    public Celebrity(String name,
                     String age,
                     Gender gender,
                     Nationality nationality,
                     Profession profession,
                     IsTrendingEnum isTrending,
                     Map<SocialMediaHandles, String> socialMediaHandles,
                     String shortBio,
                     Rating rating,
                     String profilePictureUrl,
                     Map<String, Long> followerCount,
                     String trendingNews) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.nationality = nationality;
        this.profession = profession;
        this.isTrending = isTrending;
        this.socialMediaHandles = socialMediaHandles;
        this.shortBio = shortBio;
        this.rating = rating;
        this.profilePictureUrl = profilePictureUrl;
        this.followerCount = followerCount;
        this.trendingNews = trendingNews;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Nationality getNationality() {
        return nationality;
    }

    public void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    public boolean isTrending(){
        return isTrending == IsTrendingEnum.YES;
    }

    public IsTrendingEnum getIsTrending() {
        return isTrending;
    }

    public void setIsTrending(IsTrendingEnum isTrending) {
        this.isTrending = isTrending;
    }

    public Map<SocialMediaHandles, String> getSocialMediaHandles() {
        return socialMediaHandles;
    }

    public void setSocialMediaHandles(Map<SocialMediaHandles, String> socialMediaHandles) {
        this.socialMediaHandles = socialMediaHandles;
    }

    public String getShortBio() {
        return shortBio;
    }

    public void setShortBio(String shortBio) {
        this.shortBio = shortBio;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public String getProfilePictureUrl() {
        return profilePictureUrl;
    }

    public void setProfilePictureUrl(String profilePictureUrl) {
        this.profilePictureUrl = profilePictureUrl;
    }

    public Map<String, Long> getFollowerCount() {
        return followerCount;
    }

    public void setFollowerCount(Map<String, Long> followerCount) {
        this.followerCount = followerCount;
    }

    public String getTrendingNews() {
        return trendingNews;
    }

    public void setTrendingNews(String trendingNews) {
        this.trendingNews = trendingNews;
    }

    @Override
    public String toString() {
        return "Celebrity{" +
                "celebrityId=" + celebrityId +
                ", gender=" + gender +
                ", nationality=" + nationality +
                ", profession=" + profession +
                ", isTrending=" + isTrending +
                ", socialMediaHandles=" + socialMediaHandles +
                ", rating=" + rating +
                '}';
    }
}


