package com.easybid.auction;

import java.util.List;
import java.util.UUID;

import com.easybid.auction.dto.AuctionResponseDTO;
import com.easybid.auction.dto.CreateAuctionDTO;
import com.easybid.auction.dto.UpdateAuctionDTO;

public interface AuctionService {
  AuctionResponseDTO createAuction(CreateAuctionDTO createAuctionDTO);

  List<AuctionResponseDTO> getAllAuction();

  AuctionResponseDTO getAuctionById(UUID auctionId);

  AuctionEntity findAuctionById(UUID auctionId);

  AuctionResponseDTO updateAuction(UUID auctionId, UpdateAuctionDTO updateAuctionDTO);

  void deleteAuction(UUID auctionId);

}
