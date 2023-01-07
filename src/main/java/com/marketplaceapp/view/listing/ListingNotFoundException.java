package com.marketplaceapp.view.listing;

public class ListingNotFoundException extends RuntimeException {
    public ListingNotFoundException(Long id) {
        super("Could not find listing with id " + id);
    }
}
