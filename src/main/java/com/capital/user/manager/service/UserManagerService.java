package com.capital.user.manager.service;

import com.capital.salt.exception.ApiException;
import com.capital.user.manager.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserManagerService {

    List<User> getAllUsers() throws ApiException;

    User getUserById(Long id) throws ApiException;

    void deleteUserById(Long id);

    User createUser(User user);

    User updateUser(User user);

    void deleteAll();

}
