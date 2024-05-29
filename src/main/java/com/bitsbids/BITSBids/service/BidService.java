package com.bitsbids.BITSBids.service;


import com.bitsbids.BITSBids.model.Bid;
import com.bitsbids.BITSBids.repository.BidRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BidService {
    @Autowired
    BidRepo bidRepo;


    public List<Bid> getAllBids() {
        return bidRepo.findAll();
    }

    public Optional<Bid> getBidById(Long id) {
        return bidRepo.findById(id);
    }

    public List<Bid> findBidsByAuctionId(long auctionID) {
        return bidRepo.findBidsByAuctionId(auctionID);
    }

    public Bid postNewBid(Bid bid) {
        Bid savedBid = bidRepo.save(bid);
        return savedBid;
    }
    public Bid modifyBid(Bid bid,Long id) {
        List<Bid> newbid  = bidRepo.findBidsByAuctionId(id);
        newbid.getFirst().setBid(bid.getBid());
        Bid savedBid = bidRepo.save(newbid.getFirst());
        return savedBid;
    }

}

