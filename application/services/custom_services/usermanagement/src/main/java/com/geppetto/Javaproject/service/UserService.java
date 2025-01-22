package com.geppetto.Javaproject.service;

import com.geppetto.Javaproject.dto.UserDto;
import java.util.List;
import java.util.Map;
import org.springframework.data.domain.Page;

public interface UserService {

    UserDto  getUserById(String id);

    Page<UserDto>  getAllUser(int page, int size);

    String  deleteUser(String id);

    UserDto  createUser(UserDto userDto);

    UserDto  updateUser(UserDto userDto);

}
