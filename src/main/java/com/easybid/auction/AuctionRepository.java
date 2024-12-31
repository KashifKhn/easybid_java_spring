package com.easybid.auction;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AuctionRepository extends JpaRepository<AuctionEntity, UUID> {

  List<AuctionEntity> findByItemId(UUID itemId);

  List<AuctionEntity> findByDeletedAtIsNull();

  @Query("SELECT a FROM AuctionEntity a WHERE a.item.user.id = :userId AND a.deletedAt IS NULL")
  List<AuctionEntity> findByItemUserId(@Param("userId") UUID userId);

  @Query("SELECT a FROM AuctionEntity a WHERE a.item.id = :itemId AND a.item.user.id = :userId AND a.deletedAt IS NULL")
  List<AuctionEntity> findByItemIdAndUserId(@Param("itemId") UUID itemId, @Param("userId") UUID userId);

  Optional<AuctionEntity> findByIdAndDeletedAtIsNull(UUID auctionId);

}
