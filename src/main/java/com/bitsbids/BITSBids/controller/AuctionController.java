package com.bitsbids.BITSBids.controller;

import com.bitsbids.BITSBids.model.AuctionItem;
import com.bitsbids.BITSBids.service.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/auctions")
public class AuctionController {

    @Autowired
    AuctionService auctionService;

    @GetMapping
    public List<AuctionItem> getAllItems() {
        return auctionService.getAllItems();
    }

    @GetMapping("/{id}")
    public Optional<AuctionItem> getOneItem(@PathVariable Long id) {
        return auctionService.getOneItem(id);
    }

    @PostMapping
    public ResponseEntity<Boolean> postNewAuction(@RequestBody AuctionItem auctionItem) {
        boolean isSaved = auctionService.postNewAuction(auctionItem);
        return ResponseEntity.ok(isSaved);
    }

    @GetMapping("/search/{name}")
    public List<AuctionItem> getByItemName(@PathVariable String name) {
        return auctionService.getByItemName(name);
    }

    @GetMapping("/myauctions/{ownerId}")
    public List<AuctionItem> getByItemOwner(@PathVariable int ownerId) {
        return auctionService.getAuctionByOwner(ownerId);
    }
}
