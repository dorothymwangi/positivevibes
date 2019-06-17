package org.launchcode.positivevibes.service;

import org.launchcode.positivevibes.models.User;


public interface UserService {

    User findUserByEmail(String email);

    User findUserByPassword(String password);

    void saveUser(User user);
}
