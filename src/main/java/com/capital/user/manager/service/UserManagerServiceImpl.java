package com.capital.user.manager.service;

import com.capital.salt.exception.ApiException;
import com.capital.user.manager.dao.UserDAO;
import com.capital.user.manager.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManagerServiceImpl implements UserManagerService {

    @Autowired
    UserDAO userDao;

    @Override
    public List<User> getAllUsers() throws ApiException {
        return userDao.getAllUsers();
    }

    @Override
    public User getUserById(Long id) throws ApiException {
        return userDao.getUserById(id);
    }

    @Override
    public void deleteUserById(Long id) {
        userDao.deleteUserById(id);
    }

    @Override
    public User createUser(User user) {
        return userDao.createUser(user);
    }

    @Override
    public User updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public void deleteAll() {
        userDao.deleteAll();

    }

}
