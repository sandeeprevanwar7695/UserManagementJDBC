package com.capital.user.manager.dao;

import com.capital.salt.exception.ApiException;
import com.capital.user.manager.model.User;

import java.util.List;

public interface UserDAO {
    List<User> getAllUsers() throws ApiException;

    User getUserById(Long id) throws ApiException;

    void deleteUserById(Long id);

    User createUser(User user);

    User updateUser(User user);

    void deleteAll();

}
