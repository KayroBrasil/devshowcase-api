package com.devshowcase.devshowcase_api.controller;

import com.devshowcase.devshowcase_api.dto.technology.TechnologyRequestDTO;
import com.devshowcase.devshowcase_api.dto.technology.TechnologyResponseDTO;
import com.devshowcase.devshowcase_api.service.TechnologyService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/technologies")
public class TechnologyController {

    private final TechnologyService technologyService;

    public TechnologyController(TechnologyService technologyService) {
        this.technologyService = technologyService;
    }

    @PostMapping
    public ResponseEntity<TechnologyResponseDTO> create(
            @Valid @RequestBody TechnologyRequestDTO request) {

        TechnologyResponseDTO response = technologyService.create(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<TechnologyResponseDTO>> findAll() {

        List<TechnologyResponseDTO> response = technologyService.findAll();

        return ResponseEntity.ok(response);
    }
}
