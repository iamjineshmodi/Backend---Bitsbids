package com.bitsbids.BITSBids.service;


import com.bitsbids.BITSBids.model.AuctionItem;
import com.bitsbids.BITSBids.repository.AuctionRepo;
import com.bitsbids.BITSBids.repository.BidRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuctionService {
    @Autowired
    AuctionRepo auctionRepo;

    public List<AuctionItem> getAllItems() {
        return auctionRepo.findAll();
    }

    public Optional<AuctionItem> getOneItem(Long id) {
        return auctionRepo.findById(id);
    }

    public boolean postNewAuction(AuctionItem auctionItem) {
        AuctionItem savedAuction = auctionRepo.save(auctionItem);
        return savedAuction.getId() > 0;
    }

    public List<AuctionItem> getByItemName(String item_name) {
        return auctionRepo.findAuctionByName(item_name);
    }

    public List<AuctionItem> getAuctionByOwner(int owner_id) {
        return auctionRepo.findAuctionByOwner(owner_id);
    }

}
