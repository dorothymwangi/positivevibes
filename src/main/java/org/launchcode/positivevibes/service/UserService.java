package org.launchcode.positivevibes.service;

import org.launchcode.positivevibes.models.User;

import java.util.Optional;

public interface UserService {

    /*Optional<User> findByUsername(String username);*/

    Optional<User> findByEmail(String email);

    User save(User user);
}
