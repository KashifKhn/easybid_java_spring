package com.easybid.auction;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuctionRepository extends JpaRepository<AuctionEntity, UUID> {

  List<AuctionEntity> findByDeletedAtIsNull();

  Optional<AuctionEntity> findByIdAndDeletedAtIsNull(UUID auctionId);

}
