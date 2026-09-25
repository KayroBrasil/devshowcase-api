package com.devshowcase.devshowcase_api.dto.project;

import java.util.List;

import org.hibernate.validator.constraints.URL;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProjectRequestDTO {

    @NotBlank(message = "O título não pode estar vazio")
    private String title;

    private String description;

    @NotBlank(message = "A URL não pode estar vazia")
    @URL(message = "A URL deve ser válida")
    private String url;

    @NotNull(message = "O ID do Profile é obrigatório")
    private Long profileId;

    private List<Long> technologyIds;

    // Getters e Setters
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
