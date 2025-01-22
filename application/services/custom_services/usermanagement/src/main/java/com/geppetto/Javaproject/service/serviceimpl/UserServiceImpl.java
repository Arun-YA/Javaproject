package com.geppetto.Javaproject.service.serviceimpl;

import com.geppetto.Javaproject.dao.UserDao;
import com.geppetto.Javaproject.dto.UserDto;
import com.geppetto.Javaproject.exception.EntityNotFoundException;
import com.geppetto.Javaproject.model.User;
import com.geppetto.Javaproject.service.UserService;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import java.util.Map;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.geppetto.Javaproject.util.ConstructQuery;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;


/**
* Implementation of the {@link UserService} interface.
* Provides services related to User, including CRUD operations and file uploads/downloads.
*/

@Service
@Slf4j
public class UserServiceImpl implements UserService {


    /**
     * Constructs a {@code UserServiceImpl} with the specified DAO and MongoTemplate.
     *
     * @param userDao The DAO for accessing the data.
     * @param mongoTemplate The MongoTemplate for interacting with MongoDB.
     */
  private final UserDao userDao;
  private final ConstructQuery constructQuery;

  public UserServiceImpl(UserDao  userDao, ConstructQuery constructQuery) {
    this. userDao =  userDao;
    this.constructQuery = constructQuery;
  }
    
    /**
     * Retrieves user by its ID.
     *
     * @param id The ID of the user to retrieve. Must not be {@code null}.
     * @return The user data transfer object associated with the specified ID.
     * @throws EntityNotFoundException If no user with the specified ID is found.
     */
  @Override
  public UserDto  getUserById(String id) {
    log.info("Enter into getUserById method");
    return userDao.getUserById(id)
    .map(user -> {
      UserDto userDto = new UserDto();
      BeanUtils.copyProperties(user, userDto);
      log.info("Exit from getUserById method");
      return userDto;
    })
        .orElseThrow(() -> new EntityNotFoundException("Data not found for ID: " + id));
  }
    
    /**
     * Retrieves all user.
     *
     * @return A list of {@link UserDto} representing all user.
     */
  @Override
  public Page<UserDto>  getAllUser(int page, int size) {
    log.info("Enter into getAllUser method");
    Pageable pageable = (Pageable) PageRequest.of(page, size);
    Page<User> userPage =userDao.getAllUser(pageable);
    Page<UserDto>userDtoPage = userPage.map(user -> {
    UserDto userDto = UserDto.builder().build();
    BeanUtils.copyProperties(user, userDto);
    return userDto;
    });
    log.info("Exit from getAllusermethod");
    return userDtoPage;
  }
    
    /**
     * Deletes user by ID.
     *
     * @param id The ID of the user to delete.
     * @return A message indicating the result of the deletion.
     * @throws EntityNotFoundException If no user with the specified ID is found.
     */
  @Override
  public String  deleteUser(String id) {
    log.info("Enter into deleteUser method");
    return userDao.getUserById(id)
     .map(user -> {
     userDao.deleteUser(id);
  log.info("Exit from deleteUser method");
  return "Data Deleted Successfully";
  })
  .orElseThrow(() -> new EntityNotFoundException("No entry found with ID: " + id + ". Unable to delete."));

  }
    
    /**
     * Creates new user.
     *
     * @param userDto The {@link UserDto} to be created.
     * @return The created {@link UserDto}.
     */
  @Override
  public UserDto  createUser(UserDto userDto) {
    log.info("Enter into createUser method");
    User user = new User();
  BeanUtils.copyProperties(userDto, user);
  User createdUser= userDao.createUser(user);
  BeanUtils.copyProperties(createdUser, userDto);
  log.info("Exit from createUser method");
  return userDto;
  }
    

    
    /**
     * Updates existing user.
     *
     * @param userDto The {@link UserDto} containing updated information.
     * @return The updated {@link UserDto}.
     * @throws EntityNotFoundException If no user with the specified ID is found.
     */
  @Override
  public UserDto  updateUser(UserDto userDto) {
    log.info("Enter into updateUser method");
    return userDao.getUserById(userDto.getId())
    .map(existingUser -> {
      BeanUtils.copyProperties(userDto, existingUser);
      userDao.createUser(existingUser);
      log.info("Exit from updateUser method");
      return userDto;
  })
  .orElseThrow(() -> new EntityNotFoundException("Data not found for update with ID: " + userDto.getId()));
  }
    

}
