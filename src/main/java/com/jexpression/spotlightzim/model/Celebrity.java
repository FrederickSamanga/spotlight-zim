package com.jexpression.spotlightzim.model;

import jakarta.persistence.*;
import java.util.Map;
import java.util.UUID;


@Entity
@Table(name = "celebrities")
public class Celebrity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID) // Generates UUID as the primary key
    private UUID celebrityId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = true)
    private String age;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private String nationality;

    @Column(nullable = false)
    private String profession;

    @ElementCollection
    @CollectionTable(name = "social_media_handles", joinColumns = @JoinColumn(name = "celebrity_id"))
    @MapKeyColumn(name = "platform") // Stores platform as the key (e.g., Instagram, Twitter)
    @Column(name = "handle")
    private Map<String, String> socialMediaHandles;

    @Lob
    private String shortBio;

    @Column(nullable = true)
    private String rating;

    @Column(nullable = false)
    private String profilePictureUrl;

    @ElementCollection
    @CollectionTable(name = "follower_counts", joinColumns = @JoinColumn(name = "celebrity_id"))
    @MapKeyColumn(name = "platform")
    @Column(name = "followers")
    private Map<String, Long> followerCount;

    @Lob
    private String trendingNews;

    public Celebrity() {}
    public Celebrity(String name,
                     String age,
                     String gender,
                     String nationality,
                     String profession,
                     Map<String, String> socialMediaHandles,
                     String shortBio,
                     String rating,
                     String profilePictureUrl,
                     Map<String, Long> followerCount,
                     String trendingNews) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.nationality = nationality;
        this.profession = profession;
        this.socialMediaHandles = socialMediaHandles;
        this.shortBio = shortBio;
        this.rating = rating;
        this.profilePictureUrl = profilePictureUrl;
        this.followerCount = followerCount;
        this.trendingNews = trendingNews;
    }

    @Override
    public String toString() {
        return "Celebrity{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", gender='" + gender + '\'' +
                ", nationality='" + nationality + '\'' +
                ", profession='" + profession + '\'' +
                ", socialMediaHandles=" + socialMediaHandles +
                ", shortBio='" + shortBio + '\'' +
                ", rating='" + rating + '\'' +
                ", profilePictureUrl='" + profilePictureUrl + '\'' +
                ", followerCount=" + followerCount +
                ", trendingNews='" + trendingNews + '\'' +
                '}';
    }
}


