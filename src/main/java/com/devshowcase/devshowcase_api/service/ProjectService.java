package com.devshowcase.devshowcase_api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devshowcase.devshowcase_api.dto.project.ProjectRequestDTO;
import com.devshowcase.devshowcase_api.dto.project.ProjectResponseDTO;
import com.devshowcase.devshowcase_api.model.Profile;
import com.devshowcase.devshowcase_api.model.Project;
import com.devshowcase.devshowcase_api.model.Technology;
import com.devshowcase.devshowcase_api.repository.ProfileRepository;
import com.devshowcase.devshowcase_api.repository.ProjectRepository;
import com.devshowcase.devshowcase_api.repository.TechnologyRepository;

import jakarta.transaction.Transactional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private TechnologyRepository technologyRepository;

    @Transactional
    public ProjectResponseDTO createProject(ProjectRequestDTO requestDTO) {
        Project project = new Project();
        project.setTitle(requestDTO.getTitle());
        project.setDescription(requestDTO.getDescription());
        project.setUrl(requestDTO.getUrl());

        // Associar o Profile existente
        Profile profile = profileRepository.findById(requestDTO.getProfileId())
                .orElseThrow(() -> new RuntimeException("Profile não encontrado"));
        project.setProfile(profile);

        // Associar as Tecnologias existentes
        if (requestDTO.getTechnologyIds() != null && !requestDTO.getTechnologyIds().isEmpty()) {
            List<Technology> technologies = technologyRepository.findAllById(requestDTO.getTechnologyIds());
            project.setTechnologies(technologies);
        }

        project = projectRepository.save(project);
        return mapToResponseDTO(project);
    }

    public List<ProjectResponseDTO> getAllProjects() {
        return projectRepository.findAll().stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    private ProjectResponseDTO mapToResponseDTO(Project project) {
        ProjectResponseDTO dto = new ProjectResponseDTO();
        dto.setId(project.getId());
        dto.setTitle(project.getTitle());
        dto.setDescription(project.getDescription());
        dto.setUrl(project.getUrl());
        dto.setProfileId(project.getProfile().getId());
        
        if (project.getTechnologies() != null) {
            dto.setTechnologyIds(project.getTechnologies().stream()
                    .map(Technology::getId)
                    .collect(Collectors.toList()));
        }
        return dto;
    }

}
