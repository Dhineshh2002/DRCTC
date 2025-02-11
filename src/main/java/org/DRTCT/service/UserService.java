package org.DRTCT.service;

import org.DRTCT.entity.User;
import org.DRTCT.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

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

    public void createUser(User user) {
        validateUser(user);
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new DuplicateKeyException("User with username '" + user.getUsername() + "' already exists");
        }
        try {
            userRepository.save(user);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create user: " + user.getUsername(), e);
        }
    }

    private void validateUser(User user) {
        if (user.getUsername() == null || user.getUsername().isEmpty() ||
                user.getPassword() == null || user.getPassword().isEmpty() ||
                user.getPhone() == null || user.getPhone().isEmpty() ||
                user.getName() == null || user.getName().isEmpty()) {
            throw new IllegalArgumentException("Username, password, phone, and name are required");
        }
    }

    public void updateUser(User user) throws NoSuchFieldException{
        String username = user.getUsername();
        User existingUser = userRepository.findByUsername(username);
        if(existingUser != null) {
            if (user.getEmail() != null) {
                existingUser.setEmail(user.getEmail());
            }
            if (user.getPassword() != null) {
                existingUser.setPassword(user.getPassword());
            }
            if (user.getName() != null) {
                existingUser.setName(user.getName());
            }
            if (user.getPhone() != null) {
                existingUser.setPhone(user.getPhone());
            }
            userRepository.save(existingUser);
        } else {
            throw new NoSuchFieldException("No such user with " + username);
        }
    }
}
