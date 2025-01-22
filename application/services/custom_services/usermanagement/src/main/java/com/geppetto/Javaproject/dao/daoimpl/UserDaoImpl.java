package com.geppetto.Javaproject.dao.daoimpl;

import com.geppetto.Javaproject.repository.UserRepository;
import com.geppetto.Javaproject.dao.UserDao;

import java.util.Optional;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import com.geppetto.Javaproject.model.User;
import org.springframework.stereotype.Service;

/**
* Implementation of the {@link UserDao} interface.
* Provides methods to interact with the {@link UserRepository} for CRUD operations on {@link User } entities.
*/
@Service
public class UserDaoImpl implements UserDao {

    private final UserRepository userRepository;
    /**
     * Constructs a new {@code UserDaoImpl} with the specified repository.
     *
     * @param userRepository The repository used for accessing {@link User} entities. Must not be {@code null}.
     */
    public UserDaoImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Retrieves user by its ID.
     *
     * @param id The ID of the user to retrieve. Must not be {@code null}.
     * @return An {@link Optional} containing the user if found, or an empty {@code Optional} if not.
     */
    @Override
    public Optional<User> getUserById(String id) {
        return userRepository.findById(id);
    }


     /**
     * Retrieves all user from the repository.
     *
     * @return A list of all {@link User} entities.
     */
    @Override
    public Page<User> getAllUser(Pageable pageable) {
        return userRepository.findAll(pageable);
    }


    /**
     * Deletes user by its ID.
     *
     * @param id The ID of the user to delete. Must not be {@code null}.
     */
    @Override
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }


    /**
     * Creates new user.
     *
     * @param user The {@link User} entity to create. Must not be {@code null}.
     * @return The created {@link User} entity.
     */
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }


    /**
     * Retrieves user by its ID for update purposes.
     *
     * @param id The ID of the user to retrieve. Must not be {@code null}.
     * @return An {@link Optional} containing the user if found, or an empty {@code Optional} if not.
     */
    @Override
    public Optional<User> updateUser(String id) {
        return userRepository.findById(id);
    }


}


