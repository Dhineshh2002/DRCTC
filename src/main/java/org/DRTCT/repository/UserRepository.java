package org.DRTCT.repository;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.DRTCT.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByUserName(String userName);
    boolean existsByPhone(String phone);
    boolean existsByEmail(String email);
    boolean existsByUserNameAndIdNot(String userName, Long id);
    boolean existsByEmailAndIdNot(String userName, Long id);
    boolean existsByPhoneAndIdNot(String userName, Long id);

    Optional<User> findByUserNameAndPassword(String userName, String password);
}
