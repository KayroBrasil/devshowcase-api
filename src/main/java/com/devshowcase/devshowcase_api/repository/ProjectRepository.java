package com.devshowcase.devshowcase_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devshowcase.devshowcase_api.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

}
