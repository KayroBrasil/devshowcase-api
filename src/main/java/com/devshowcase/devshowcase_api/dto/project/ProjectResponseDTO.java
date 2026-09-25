package com.devshowcase.devshowcase_api.dto.project;

import java.util.List;

public class ProjectResponseDTO {
    
    private Long id;
    private String title;
    private String description;
    private String url;
    private Long profileId;
    private List<Long> technologyIds;

    // Construtor
    public ProjectResponseDTO() {}
    
    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
    public Long getProfileId() { return profileId; }
    public void setProfileId(Long profileId) { this.profileId = profileId; }
    public List<Long> getTechnologyIds() { return technologyIds; }
    public void setTechnologyIds(List<Long> technologyIds) { this.technologyIds = technologyIds; }

}
