package org.launchcode.positivevibes.repository;

import org.launchcode.positivevibes.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(@Param("email") String email);

    /*Optional<User> findByUsername(@Param("username") String username);*/
}
