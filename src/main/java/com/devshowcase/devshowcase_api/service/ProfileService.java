package com.devshowcase.devshowcase_api.service;

import org.springframework.stereotype.Service;

import com.devshowcase.devshowcase_api.dto.profile.ProfileRequestDTO;
import com.devshowcase.devshowcase_api.dto.profile.ProfileResponseDTO;
import com.devshowcase.devshowcase_api.exception.ProfileNotFoundException;
import com.devshowcase.devshowcase_api.model.Profile;
import com.devshowcase.devshowcase_api.repository.ProfileRepository;

@Service
public class ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public ProfileResponseDTO createProfile(ProfileRequestDTO request) {

        Profile profile = new Profile();

        profile.setName(request.getName());
        profile.setEmail(request.getEmail());
        profile.setBio(request.getBio());

        Profile savedProfile = profileRepository.save(profile);

        ProfileResponseDTO response = new ProfileResponseDTO();

        response.setId(savedProfile.getId());
        response.setName(savedProfile.getName());
        response.setEmail(savedProfile.getEmail());
        response.setBio(savedProfile.getBio());

        return response;
    }

    public ProfileResponseDTO getProfileById(Long id) {

        Profile profile = profileRepository.findById(id)
                .orElseThrow(() -> new ProfileNotFoundException(id));

        ProfileResponseDTO response = new ProfileResponseDTO();

        response.setId(profile.getId());
        response.setName(profile.getName());
        response.setEmail(profile.getEmail());
        response.setBio(profile.getBio());

        return response;

    }
}
