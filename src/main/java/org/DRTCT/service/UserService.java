package org.DRTCT.service;

import org.DRTCT.entity.User;
import org.DRTCT.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public int addUser(User user){
        return userRepository.save(user).getId();
    }

    public User checkUserExist(User user) {
        String username = user.getUsername();
        String password = user.getPassword();

        return userRepository.findByUsernameAndPassword(username, password);
    }

    public User getUser(String username) {
        return userRepository.findByUsername(username);
    }
}
