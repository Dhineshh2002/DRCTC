package org.DRTCT.dto.request;


import jakarta.validation.constraints.*;

public record SaveUserRequest (
        @NotBlank(message = "Name cannot be blank")
        String name,

        @NotBlank(message = "UserName cannot be blank")
        String userName,

        @NotBlank(message = "Password cannot be blank")
        @Size(min = 8, message = "Password must be at least 8 characters long")
        @Pattern(
                regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
                message = "Password must contain at least one uppercase, one lowercase, one number, and one special character"
        )
        String passWord,

        @Email @NotBlank(message = "Email cannot be blank")
        String email,

        @Pattern(regexp = "\\d{10}", message = "Phone must be a 10-digit number")
        String phone
) {
}
