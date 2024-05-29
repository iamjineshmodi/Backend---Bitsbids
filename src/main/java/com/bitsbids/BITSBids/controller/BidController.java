package com.bitsbids.BITSBids.controller;


import com.bitsbids.BITSBids.model.Bid;
import com.bitsbids.BITSBids.service.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping
public class BidController {

    @Autowired
    BidService bidService;

    @GetMapping("/api/bids")
    public List<Bid> getAllBids() {
        return bidService.getAllBids();
    }

   /* @GetMapping("/api/bids/{id}")
    public Optional<Bid> getOneBid(@PathVariable Long id) {
        return bidService.getBidById(id);
    }*/

    @PostMapping("/api/bids")
    public Bid postNewBid(@RequestBody Bid bid) {
        var isSaved = bidService.postNewBid(bid);
        return bidService.postNewBid(bid);
    }
    @PutMapping("/api/bids/{id}")
    public Bid modifyBid(@RequestBody Bid bid,@PathVariable Long id) {
        return bidService.modifyBid(bid,id);
    }

    @GetMapping("/api/bids/{auctionId}")
    public ResponseEntity<List<Bid>> getAllBidsByAuctionId(@PathVariable long auctionId) {
        var bids = bidService.findBidsByAuctionId(auctionId);
        return ResponseEntity.ok(bids);
    }
}
