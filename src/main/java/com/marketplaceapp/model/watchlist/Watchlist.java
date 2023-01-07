package com.marketplaceapp.model.watchlist;

import com.marketplaceapp.model.listing.Listing;
import com.marketplaceapp.model.user.User;
import jakarta.persistence.*;

@Entity
@Table(name = "watchlist")
public class Watchlist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "listing_id", nullable = false)
    private Listing listing;
}
