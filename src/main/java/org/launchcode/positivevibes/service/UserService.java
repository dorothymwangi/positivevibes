package org.launchcode.positivevibes.service;

import org.launchcode.positivevibes.models.User;

import java.util.Optional;

public interface UserService {

    Optional<User> findById(int id);

    Optional<User> findByEmail(String email);

    User save(User user);
}
