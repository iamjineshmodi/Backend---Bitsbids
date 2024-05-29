package com.bitsbids.BITSBids.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
@Entity
@Table(name = "bids")

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bid {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = true)
    private int auction_id;
    private int bid;
    @Column(nullable = true)
    private int bidder_id;
    private long created_at;
    private String username;
//    @OneToOne
//    @JoinColumn(name = "auction_id", updatable=false, insertable = false)
//    private AuctionItem auction_item;
//    @OneToOne
//    @JoinColumn(name = "bidder_id", updatable=false, insertable = false)
//    private User bidder;


}
