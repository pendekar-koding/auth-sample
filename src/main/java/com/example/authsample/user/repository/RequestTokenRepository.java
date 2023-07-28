package com.example.authsample.user.repository;

import com.example.authsample.user.RequestToken;
import com.example.authsample.user.UserProfile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestTokenRepository extends CrudRepository<RequestToken, Long> {

    List<RequestToken> findAllByDeletedIsFalseAndUserProfile(UserProfile userProfile);
}
