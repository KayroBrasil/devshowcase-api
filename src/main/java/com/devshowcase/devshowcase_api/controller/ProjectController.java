package com.devshowcase.devshowcase_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devshowcase.devshowcase_api.dto.project.ProjectRequestDTO;
import com.devshowcase.devshowcase_api.dto.project.ProjectResponseDTO;
import com.devshowcase.devshowcase_api.service.ProjectService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping // Cadastro de projeto com validações[cite: 2]
    public ResponseEntity<ProjectResponseDTO> createProject(@Valid @RequestBody ProjectRequestDTO requestDTO) {
        ProjectResponseDTO createdProject = projectService.createProject(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProject); // Retorno 201 Created[cite: 2]
    }

    @GetMapping // Listagem de projetos[cite: 2]
    public ResponseEntity<List<ProjectResponseDTO>> getAllProjects() {
        List<ProjectResponseDTO> projects = projectService.getAllProjects();
        return ResponseEntity.ok(projects); // Retorno 200 OK[cite: 2]
    }

}
