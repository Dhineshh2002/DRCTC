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
}
