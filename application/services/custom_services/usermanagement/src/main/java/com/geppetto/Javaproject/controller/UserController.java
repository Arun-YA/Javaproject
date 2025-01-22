package com.geppetto.Javaproject.controller;

import com.geppetto.Javaproject.dto.UserDto;
import com.geppetto.Javaproject.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


/**
* REST controller for managing User
* Provides endpoints to create, update, delete, retrieve, and search for User,
* as well as to handle file uploads and downloads associated with User.
*/
@RestController
@RequestMapping("/usermanagement")
@RequiredArgsConstructor
@Slf4j
public class UserController {

   private final UserService userService; 


@GetMapping("/{id}")
public ResponseEntity<UserDto> getUserById(@PathVariable String id) {
    log.info("Enter into getUserById method");
    ResponseEntity<UserDto> response =ResponseEntity.status(HttpStatus.OK).body(userService.getUserById(id));
    log.info("Exit from getUserById method");
    return response;
}

@GetMapping("/searchUpdate")
public ResponseEntity<UserDto> searchForUpdateUser(@RequestBody UserDto userDto) {
    log.info("Enter into searchForUpdateUser method");
    ResponseEntity<UserDto> response = ResponseEntity.status(HttpStatus.OK).body(userService.updateUser(userDto));
    log.info("Exit from searchForUpdateUser method");
    return response;
}

@GetMapping
public ResponseEntity<Page<UserDto>> getAllUser(@RequestParam(defaultValue = "0") int page,
                                                  @RequestParam(defaultValue = "3") int size) {
    log.info("Enter into getAllUser method");
    Page<UserDto>userDtoPage = userService.getAllUser(page, size);
    log.info("Exit from getAllUser method");
    return new ResponseEntity<>(userDtoPage, HttpStatus.OK);
}

@DeleteMapping("/{id}")
public ResponseEntity<String> deleteUser(@PathVariable String id) {
    log.info("Enter into deleteUser method");
     ResponseEntity<String> response = ResponseEntity.status(HttpStatus.OK).body(userService.deleteUser(id));
    log.info("Exit from deleteUser method");
    return response;
}

@PostMapping
public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
    log.info("Enter into createUser method");
    ResponseEntity<UserDto> response =  ResponseEntity.status(HttpStatus.OK).body(userService.createUser(userDto));
    log.info("Exit from createUser method");
    return response;
}

@PutMapping
public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto) {
    log.info("Enter into updateUser method");
    ResponseEntity<UserDto> response = ResponseEntity.status(HttpStatus.OK).body(userService.updateUser(userDto));
    log.info("Exit from updateUser method");
    return response;
}

   
}
