package com.hyxiao.o2ostore.service.impl;

import com.hyxiao.o2ostore.mapper.UserModelMapper;
import com.hyxiao.o2ostore.model.UserModel;
import com.hyxiao.o2ostore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserModelMapper userModelMapper;


    @Override
    public UserModel getUser(Integer id) {
        return userModelMapper.selectByPrimaryKey(id);
    }

}
