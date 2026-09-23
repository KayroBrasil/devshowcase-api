package com.devshowcase.devshowcase_api.service;

import com.devshowcase.devshowcase_api.dto.technology.TechnologyRequestDTO;
import com.devshowcase.devshowcase_api.dto.technology.TechnologyResponseDTO;
import com.devshowcase.devshowcase_api.model.Technology;
import com.devshowcase.devshowcase_api.repository.TechnologyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyService {

    private final TechnologyRepository technologyRepository;

    public TechnologyService(TechnologyRepository technologyRepository) {
        this.technologyRepository = technologyRepository;
    }

    public TechnologyResponseDTO create(TechnologyRequestDTO request) {

        Technology technology = new Technology();
        technology.setName(request.getName());

        Technology savedTechnology = technologyRepository.save(technology);

        return new TechnologyResponseDTO(
                savedTechnology.getId(),
                savedTechnology.getName()
        );
    }

    public List<TechnologyResponseDTO> findAll() {

        return technologyRepository.findAll()
                .stream()
                .map(technology -> new TechnologyResponseDTO(
                        technology.getId(),
                        technology.getName()
                ))
                .toList();
    }
}