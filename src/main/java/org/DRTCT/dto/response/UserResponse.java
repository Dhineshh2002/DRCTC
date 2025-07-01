package org.DRTCT.dto.response;

import lombok.Builder;
import lombok.Getter;
import org.DRTCT.entity.User;

@Builder
@Getter
public class UserResponse {
    private Long id;
    private String name;
    private String userName;
    private String email;
    private String phone;

    public static UserResponse create(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .userName(user.getUserName())
                .email(user.getEmail())
                .phone(user.getPhone())
                .build();
    }
}
