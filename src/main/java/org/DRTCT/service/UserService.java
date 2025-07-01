package org.DRTCT.service;
import org.DRTCT.dto.request.GetUserRequest;
import org.DRTCT.dto.request.SaveUserRequest;
import org.DRTCT.dto.response.UserResponse;

public interface UserService {

    UserResponse createUser(SaveUserRequest saveUserRequest);

    UserResponse updateUser(Long id, SaveUserRequest saveUserRequest);

    void deleteUser(Long id);

    UserResponse getUser(GetUserRequest getUserRequest);

}
