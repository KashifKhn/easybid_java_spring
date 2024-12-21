package com.easybid.item;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, UUID> {

  List<ItemEntity> findByDeletedAtIsNull();

  Optional<ItemEntity> findByIdAndDeletedAtIsNull(UUID itemId);

}
