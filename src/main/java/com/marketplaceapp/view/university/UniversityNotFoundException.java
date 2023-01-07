package com.marketplaceapp.view.university;

public class UniversityNotFoundException extends RuntimeException {
    public UniversityNotFoundException(Long id) {
        super("Could not find university with id " + id);
    }
}

