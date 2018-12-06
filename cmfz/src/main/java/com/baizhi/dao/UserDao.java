package com.baizhi.dao;

import com.baizhi.entity.User;


import java.util.List;

public interface UserDao {
    public int selectCount1();
    public int selectCount2();
    public int selectCount3();

    public List<User> selectAll();
}
