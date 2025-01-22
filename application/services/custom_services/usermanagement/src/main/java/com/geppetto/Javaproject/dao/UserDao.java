package com.geppetto.Javaproject.dao;

import java.util.Optional;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import com.geppetto.Javaproject.model.User;

public interface UserDao {

    Optional<User> getUserById(String id);

    Page<User> getAllUser(Pageable pageable);

    void deleteUser(String id);

    User createUser(User user);

    Optional<User> updateUser(String id);

}

