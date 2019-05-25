package org.launchcode.positivevibes.models.data;

import org.launchcode.positivevibes.models.Post;
import org.launchcode.positivevibes.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
@Transactional
public interface PostDao extends CrudRepository<Post, Integer> {
}
