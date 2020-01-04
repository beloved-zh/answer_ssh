package com.zh.service.impl;

import com.zh.dao.UserDao;
import com.zh.model.UserbaseEntity;
import com.zh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;

    @Override
    public UserbaseEntity login(UserbaseEntity user) {
        return dao.login(user);
    }
}
