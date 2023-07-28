package com.example.authsample.user.repository;

import com.example.authsample.user.UserProfile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserProfileRepository extends CrudRepository<UserProfile, Long> {
    Optional<UserProfile> findByDeletedIsFalseAndUsername(String value);

    Boolean existsByDeletedIsFalseAndUsername(String username);
}
