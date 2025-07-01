package org.DRTCT.service.impl;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.DRTCT.common.ValidateObject;
import org.DRTCT.dto.request.GetUserRequest;
import org.DRTCT.dto.request.SaveUserRequest;
import org.DRTCT.dto.response.UserResponse;
import org.DRTCT.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Slf4j
class UserServiceImplTest extends ValidateObject {

    @Autowired
    UserService userService;

    @Test
    void createUser() {
        SaveUserRequest saveUserRequest = new SaveUserRequest(
                "Dhinesh R",
                "dhineshh",
                "Dhinesh1@",
                "dhinesh.r@gmail.com",
                "3948094833"
        );
        validate(saveUserRequest);
        // assertThrows(DuplicateKeyException.class, () -> userService.createUser(saveUserRequest));
        UserResponse userResponse = userService.createUser(saveUserRequest);
        log.info(String.valueOf(userResponse.getId()));
    }

    @Test
    void updateUser() {

        SaveUserRequest saveUserRequest = new SaveUserRequest(
                "Dhinesh Ramadoss",
                "dhineshhh",
                "Dhinesh1@",
                "dhinesh.r@gmail.com",
                "9292929299"
        );

        validate(saveUserRequest);
        UserResponse userResponse = userService.updateUser(1L, saveUserRequest);

    }

    @Test
    void getUser() {
        GetUserRequest getUserRequest = new GetUserRequest(
                "dhineshhh",
                "Dhinesh1@"
        );
        validate(getUserRequest);

        UserResponse userResponse = userService.getUser(getUserRequest);
    }
}