package org.launchcode.positivevibes.models.data;

import org.launchcode.positivevibes.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
@Transactional
public interface UserDao extends CrudRepository<User, Integer> {

    User findByEmail(String email);

    User findByPassword(String password);

}
