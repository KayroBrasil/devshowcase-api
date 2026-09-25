package com.devshowcase.devshowcase_api.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String description;

    @Column(nullable = false)
    private String url;

    // Relacionamento Profile 1:N Project
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id", nullable = false)
    private Profile profile; 

    // Relacionamento Project N:N Technology
    @ManyToMany
    @JoinTable(
        name = "tb_project_technology",
        joinColumns = @JoinColumn(name = "project_id"),
        inverseJoinColumns = @JoinColumn(name = "technology_id")
    )
    private List<Technology> technologies = new ArrayList<>();

    // Relacionamento Project 1:N Feedback
    //@OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    //private List<Feedback> feedbacks = new ArrayList<>();

    public Project() {}

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public Profile getProfile() { return profile; }
    public void setProfile(Profile profile) { this.profile = profile; }

    public List<Technology> getTechnologies() { return technologies; }
    public void setTechnologies(List<Technology> technologies) { this.technologies = technologies; }

    //public List<Feedback> getFeedbacks() { return feedbacks; }
    //public void setFeedbacks(List<Feedback> feedbacks) { this.feedbacks = feedbacks; }

}
