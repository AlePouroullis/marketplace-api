package com.marketplaceapp.controller;


import com.marketplaceapp.model.university.University;
import com.marketplaceapp.view.university.UniversityModelAssembler;
import com.marketplaceapp.view.university.UniversityNotFoundException;
import com.marketplaceapp.model.university.UniversityRepository;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@RestController
@RequestMapping("/universities")
public class UniversityController {
    private final UniversityRepository repository;

    private final UniversityModelAssembler assembler;

    public UniversityController(UniversityRepository universityRepository, UniversityModelAssembler assembler) {
        this.repository = universityRepository;
        this.assembler = assembler;
    }

    @PostMapping("/")
    public ResponseEntity<?> newUniversity(@RequestBody University newUniversity) {
        EntityModel<University> entityModel = assembler.toModel(repository.save(newUniversity));

        return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(entityModel);
    }

    @GetMapping("/")
    public CollectionModel<EntityModel<University>> all() {
        List<EntityModel<University>> universities = repository.findAll().stream().map(assembler::toModel).collect(Collectors.toList());

        return CollectionModel.of(universities, linkTo(methodOn(UniversityController.class).all()).withSelfRel());
    }

    @GetMapping("/{id}")
    public EntityModel<University> one(@PathVariable Long id) {
        University university = repository.findById(id).orElseThrow(() -> new UniversityNotFoundException(id));

        return assembler.toModel(university);
    }
}
