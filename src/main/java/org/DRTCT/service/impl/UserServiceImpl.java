package org.DRTCT.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.DRTCT.dto.request.GetUserRequest;
import org.DRTCT.dto.request.SaveUserRequest;
import org.DRTCT.dto.response.UserResponse;
import org.DRTCT.entity.User;
import org.DRTCT.repository.UserRepository;
import org.DRTCT.service.UserService;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserResponse createUser(SaveUserRequest saveUserRequest) {
        log.info("createUser: method called");
        checkUserExist(saveUserRequest);
        User user = buildUser(saveUserRequest);
        userRepository.save(user);
        return UserResponse.create(user);
    }

    @Override
    public UserResponse updateUser(Long id, SaveUserRequest saveUserRequest) {
        log.info("updateUser: method called");
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id = " + id));
        checkUserExist(id, saveUserRequest);
        setUser(existingUser, saveUserRequest);
        userRepository.save(existingUser);
        return UserResponse.create(existingUser);
    }

    @Override
    public void deleteUser(Long id) {

    }

    @Override
    public UserResponse getUser(GetUserRequest getUserRequest) {
        log.info("getUser: method called");
        User user = userRepository.findByUserNameAndPassword(getUserRequest.userName(), getUserRequest.passWord())
                .orElseThrow(() -> {
                    log.error("User not found");
                    return new EntityNotFoundException("User not found");
                });
        return UserResponse.create(user);
    }

    private User buildUser(SaveUserRequest saveUserRequest) {
        return User.builder()
                .userName(saveUserRequest.userName())
                .name(saveUserRequest.name())
                .password(saveUserRequest.passWord())
                .email(saveUserRequest.email())
                .phone(saveUserRequest.phone())
                .build();
    }

    private void setUser(User existingUser, SaveUserRequest saveUserRequest) {
        existingUser.setUserName(saveUserRequest.userName());
        existingUser.setName(saveUserRequest.name());
        existingUser.setPassword(saveUserRequest.passWord());
        existingUser.setEmail(saveUserRequest.email());
        existingUser.setPhone(saveUserRequest.phone());
    }

    private void checkUserExist(SaveUserRequest saveUserRequest) {

        if (userRepository.existsByUserName(saveUserRequest.userName())) {
            log.info("This user name was already taken");
            throw new DuplicateKeyException("This user name was already taken");
        } else if (userRepository.existsByPhone(saveUserRequest.phone())) {
            log.info("This phone was already taken");
            throw new DuplicateKeyException("This phone was already taken");
        } else if (userRepository.existsByEmail(saveUserRequest.email())) {
            log.info("This email already registered");
            throw new DuplicateKeyException("This email already registered");
        }

    }

    private void checkUserExist(Long id, SaveUserRequest saveUserRequest) {
        if (userRepository.existsByUserNameAndIdNot(saveUserRequest.userName(), id)) {
            log.info("Username already taken");
            throw new DuplicateKeyException("Username already taken");
        } else if (userRepository.existsByEmailAndIdNot(saveUserRequest.email(), id)) {
            log.info("Email already registered");
            throw new DuplicateKeyException("Email already registered");
        } else if (userRepository.existsByPhoneAndIdNot(saveUserRequest.phone(), id)) {
            log.info("Phone number already registered");
            throw new DuplicateKeyException("Phone number already registered");
        }
    }
}
