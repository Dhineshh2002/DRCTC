package org.DRTCT.repository;

import org.DRTCT.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    public User findByUsernameAndPassword(String username, String password);
    public User findByUsername(String username);
}