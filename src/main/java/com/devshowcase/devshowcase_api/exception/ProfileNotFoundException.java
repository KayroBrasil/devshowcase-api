package com.devshowcase.devshowcase_api.exception;

public class ProfileNotFoundException extends RuntimeException {

    public ProfileNotFoundException(Long id) {
        super("Profile não encontrado com o id: " + id);
    }
}