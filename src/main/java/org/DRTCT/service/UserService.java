package org.DRTCT.service;

import org.DRTCT.entity.User;
import org.DRTCT.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void addUser(User user) throws Exception{
        try {
            user = userRepository.save(user);
        } catch (Exception e) {
            throw new Exception("Duplicate User Found!!");
        }
    }

    public User checkUserExist(User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        return userRepository.findByUsernameAndPassword(username, password);
    }

    public User getUser(String username) {
        return userRepository.findByUsername(username);   
    }

    public ArrayList<User> getUsers() {
        ArrayList<User> usersList = new ArrayList<>();
        userRepository.findAll().forEach(usersList::add);
        return usersList;
    }
}
