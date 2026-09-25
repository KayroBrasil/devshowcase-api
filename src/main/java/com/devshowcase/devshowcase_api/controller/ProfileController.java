package com.devshowcase.devshowcase_api.controller;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import com.devshowcase.devshowcase_api.dto.profile.ProfileRequestDTO;
import com.devshowcase.devshowcase_api.dto.profile.ProfileResponseDTO;
import com.devshowcase.devshowcase_api.service.ProfileService;

@RestController
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @PostMapping("/api/profiles")
    public ResponseEntity<ProfileResponseDTO> createProfile(
            @Valid @RequestBody ProfileRequestDTO request) {

        ProfileResponseDTO response = profileService.createProfile(request);

        return ResponseEntity.status(201).body(response);
    }

    @GetMapping("/api/profiles/{id}")
    public ProfileResponseDTO getProfileById(@PathVariable Long id) {

        return profileService.getProfileById(id);
    }
}