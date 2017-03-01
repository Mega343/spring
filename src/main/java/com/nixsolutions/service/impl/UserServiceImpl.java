package com.nixsolutions.service.impl;

import com.nixsolutions.bean.User;
import com.nixsolutions.dao.UserDAO;
import com.nixsolutions.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserService userService;

    @Override
    public boolean add(User user) {
        return userDAO.add(user);
    }

    @Override
    public boolean edit(User user) {
        return userDAO.edit(user);
    }

    @Override
    public boolean delete(Long id) {
        return userDAO.delete(id);
    }

    @Override
    public User getUser(Long id) {
        return userDAO.getUser(id);
    }

    @Override
    public List<User> searchByLastName(String lastName) {
        return userDAO.searchByLastName(lastName);
    }

    @Override
    public User searchByEmail(String email) {
        return userDAO.searchByEmail(email);
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public List<User> getAllUnconfirmedUsers() {
        return userDAO.getAllUnconfirmedUsers();
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

}
