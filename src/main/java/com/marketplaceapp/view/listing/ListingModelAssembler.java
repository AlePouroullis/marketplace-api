package com.marketplaceapp.view.listing;

import com.marketplaceapp.controller.ListingController;
import com.marketplaceapp.model.listing.Listing;
import com.marketplaceapp.model.listing.ListingStatus;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ListingModelAssembler implements RepresentationModelAssembler<Listing, EntityModel<Listing>> {
    @Override
    public EntityModel<Listing> toModel(Listing listing) {
        EntityModel<Listing> listingModel = EntityModel.of(listing,
                linkTo(methodOn(ListingController.class).one(listing.getId())).withSelfRel(),
                linkTo(methodOn(ListingController.class).all()).withRel("listings"));

        if (listing.getStatus() == ListingStatus.ACTIVE) {
            listingModel.add(linkTo(methodOn(ListingController.class).
                    cancel(listing.getId())).withRel("cancel"));
            listingModel.add(linkTo(methodOn(ListingController.class).
                    complete(listing.getId())).withRel("complete"));
        }

        return listingModel;
    }
}
