package com.bitsbids.BITSBids.repository;


import com.bitsbids.BITSBids.model.Bid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BidRepo extends JpaRepository<Bid, Long> {
    @Query(value = "SELECT * FROM bids WHERE auction_id = :auctionID", nativeQuery = true)
    List<Bid> findBidsByAuctionId(@Param("auctionID") long auctionID);
}
