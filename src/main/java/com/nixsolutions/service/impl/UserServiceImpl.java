package com.nixsolutions.service.impl;

import com.nixsolutions.bean.User;
import com.nixsolutions.dao.UserDAO;
import com.nixsolutions.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserDAO userDAO;

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

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userDAO.searchByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User with email '" + email + "' not found!");
        }

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole().getUserRole()));
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                user.getEmail(), user.getPassword(), authorities);
        return userDetails;
    }
}
