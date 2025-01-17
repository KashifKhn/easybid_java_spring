package com.easybid.notification;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<NotificationEntity, UUID> {
  List<NotificationEntity> findAllByUserId(UUID userId);
}
