package com.baizhi.service;

import com.baizhi.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    public int selectCount1();
    public int selectCount2();
    public int selectCount3();
    public Map selectCountt();
    //查询全部
    public List<User> selectAll();
}
