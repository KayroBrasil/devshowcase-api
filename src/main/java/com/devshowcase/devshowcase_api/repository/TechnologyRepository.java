package com.devshowcase.devshowcase_api.repository;

import com.devshowcase.devshowcase_api.model.Technology;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnologyRepository extends JpaRepository<Technology, Long> {
}