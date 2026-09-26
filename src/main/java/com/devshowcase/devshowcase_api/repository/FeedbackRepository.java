package com.devshowcase.devshowcase_api.repository;

import com.devshowcase.devshowcase_api.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

}