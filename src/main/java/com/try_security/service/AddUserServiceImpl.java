package com.try_security.service;

import com.try_security.dao.UserDAO;
import com.try_security.dao.UserDAOImpl;
import com.try_security.entity.Authority;
import com.try_security.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddUserServiceImpl implements AddUserService{
    @Autowired
    private UserDAO userDAO;

    @Override
    public void addUser(User user, Authority authority) {

    }
}
