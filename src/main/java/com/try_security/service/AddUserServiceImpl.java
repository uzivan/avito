package com.try_security.service;

import com.try_security.dao.AuthorityDAO;
import com.try_security.dao.UserDAO;
import com.try_security.dao.UserDAOImpl;
import com.try_security.entity.Authority;
import com.try_security.entity.CompositeKey;
import com.try_security.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

@Service
public class AddUserServiceImpl implements AddUserService{
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private AuthorityDAO authorityDAO;
    @Override
    @Transactional
    public void addUser(User user, String[] roles) {
        String password = "{noop}" + user.getPassword();
        user.setPassword(password);
        userDAO.save(user);
        for(int i = 0;i < roles.length;i++){
            System.out.println(roles[i]);
        }
        if(Arrays.asList(roles).contains("SALESMAN")){
            Authority authority1 = new Authority();
            CompositeKey compositeKey = new CompositeKey();
            compositeKey.setAuthority("ROLE_SALESMAN");
            compositeKey.setUsername(user.getUsername());
            authority1.setCompositeKey(compositeKey);
            System.out.println(authority1);
            authorityDAO.add(authority1);
        }
        if(Arrays.asList(roles).contains("BUYER")){
            Authority authority2 = new Authority();
            CompositeKey compositeKey = new CompositeKey();
            compositeKey.setAuthority("ROLE_BUYER");
            compositeKey.setUsername(user.getUsername());
            authority2.setCompositeKey(compositeKey);
            System.out.println(authority2);
            authorityDAO.add(authority2);
        }
    }
}
