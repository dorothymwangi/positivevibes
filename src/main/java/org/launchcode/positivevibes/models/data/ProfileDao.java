package org.launchcode.positivevibes.models.data;

import org.launchcode.positivevibes.models.User;
import org.springframework.data.repository.CrudRepository;

public interface ProfileDao extends CrudRepository<User, Integer> {

}
