package com.devshowcase.devshowcase_api.dto.technology;

import jakarta.validation.constraints.NotBlank;

public class TechnologyRequestDTO {

    @NotBlank(message = "O nome da tecnologia é obrigatório")
    private String name;

    public TechnologyRequestDTO() {
    }

    public TechnologyRequestDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}