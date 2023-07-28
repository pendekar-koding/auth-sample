package com.example.authsample.user.repository;

import com.example.authsample.user.UserRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRoleRepository extends CrudRepository<UserRole, Long> {

    Optional<UserRole> findByDeletedIsFalseAndValue(String value);
}
