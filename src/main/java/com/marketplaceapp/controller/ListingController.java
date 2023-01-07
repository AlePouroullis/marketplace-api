package com.marketplaceapp.controller;

import com.marketplaceapp.model.listing.Listing;
import com.marketplaceapp.model.listing.ListingRepository;
import com.marketplaceapp.model.listing.ListingStatus;
import com.marketplaceapp.view.listing.ListingModelAssembler;
import com.marketplaceapp.view.listing.ListingNotFoundException;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.mediatype.problem.Problem;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/listings")
public class ListingController {
//
//    private final ListingRepository repository;
//    private final ListingModelAssembler assembler;
//
//    public ListingController(ListingRepository repository, ListingModelAssembler assembler) {
//        this.repository = repository;
//        this.assembler = assembler;
//    }
//
//    @GetMapping("/{id")
//    public EntityModel<Listing> one(@PathVariable Long id) {
//        Listing listing = repository.findById(id).orElseThrow(() -> new ListingNotFoundException(id));
//        return assembler.toModel(listing);
//    }
//
//    @GetMapping("/")
//    public CollectionModel<EntityModel<Listing>> all() {
//        List<EntityModel<Listing>> listings = repository.findAll().stream().
//                map(assembler::toModel).collect(Collectors.toList());
//
//        return CollectionModel.of(listings, linkTo(methodOn(ListingController.class).all()).withSelfRel());
//    }
//
//    @PostMapping("/")
//    ResponseEntity<EntityModel<Listing>> newListing(@RequestBody Listing listing) {
//        listing.setStatus(ListingStatus.ACTIVE);
//        Listing newListing = repository.save(listing);
//        return ResponseEntity.created(linkTo(methodOn(ListingController.class).one(newListing.getId())).toUri())
//                .body(assembler.toModel(newListing));
//    }
//
//    @PatchMapping("/{id}/cancel")
//    public ResponseEntity<?> cancel(@PathVariable long id) {
//        Listing listing = repository.findById(id).orElseThrow(() -> new ListingNotFoundException(id));
//        if (listing.getStatus() == ListingStatus.ACTIVE) {
//            listing.setStatus(ListingStatus.CANCELLED);
//            return ResponseEntity.ok(assembler.toModel(repository.save(listing)));
//        }
//        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).header(HttpHeaders.CONTENT_TYPE,
//                MediaTypes.HTTP_PROBLEM_DETAILS_JSON_VALUE).body(Problem.create()
//                .withTitle("Method not allowed")
//                .withDetail("You can't cancel a listing that is in the " + listing.getStatus() + " status"));
//    }
//
//    @PatchMapping("/{id}/complete")
//    public ResponseEntity<?> complete(long id) {
//        Listing listing = repository.findById(id).orElseThrow(() -> new ListingNotFoundException(id));
//        if (listing.getStatus() == ListingStatus.ACTIVE) {
//            listing.setStatus(ListingStatus.COMPLETED);
//            return ResponseEntity.ok(assembler.toModel(repository.save(listing)));
//        }
//        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).header(HttpHeaders.CONTENT_TYPE,
//                MediaTypes.HTTP_PROBLEM_DETAILS_JSON_VALUE).body(Problem.create()
//                .withTitle("Method not allowed")
//                .withDetail("You can't complete a listing that is in the " + listing.getStatus() + " status"));
//    }
}
