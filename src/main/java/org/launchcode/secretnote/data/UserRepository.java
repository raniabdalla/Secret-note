package org.launchcode.secretnote.data;

import org.launchcode.secretnote.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUsername(String username);
}
