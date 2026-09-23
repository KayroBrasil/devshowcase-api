package com.devshowcase.devshowcase_api.repository;

import com.devshowcase.devshowcase_api.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}