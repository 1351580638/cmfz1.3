package com.baizhi.service.impl;

import com.baizhi.dao.UserDao;
import com.baizhi.dao.UsersDao;
import com.baizhi.entity.User;
import com.baizhi.entity.Users;
import com.baizhi.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("usersService")
@Transactional
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersDao usersDao;

    @Override
    public Users getOne(Users users) {
        Users u1 = usersDao.getOne(users);
        return u1;
    }
}
