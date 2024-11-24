package com.easybid.Users;

import java.util.UUID;

import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends ListPagingAndSortingRepository<UserEntity, UUID> {

}
