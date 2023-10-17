package com.try_security.service;

import com.try_security.entity.Authority;
import com.try_security.entity.User;

public interface AddUserService {
    public void addUser(User user, String[] roles);
}
