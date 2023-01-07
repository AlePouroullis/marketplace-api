package com.marketplaceapp.view.university;

import com.marketplaceapp.controller.UniversityController;
import com.marketplaceapp.model.university.University;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class UniversityModelAssembler implements RepresentationModelAssembler<University, EntityModel<University>> {
    @Override
    public EntityModel<University> toModel(University university) {
        return EntityModel.of(university, linkTo(methodOn(UniversityController.class).one(university.getId())).withSelfRel(),
                linkTo(methodOn(UniversityController.class).all()).withRel("universities"));
    }
}
