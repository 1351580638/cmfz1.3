package com.baizhi.service.impl;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("userService")
@Transactional
public class UserServiceImpl  implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserService userService;

    @Override
    public int selectCount1() {
        return userDao.selectCount1();
    }

    @Override
    public int selectCount2() {
        return userDao.selectCount2();
    }

    @Override
    public int selectCount3() {
        return userDao.selectCount3();
    }

    @Override
    public Map selectCountt() {
        int count1 = userService.selectCount1();
        int count2 = userService.selectCount2();
        int count3 = userService.selectCount3();
        int[] count={count1,count2,count3};

        Map map=new HashMap();
        map.put("count",count);
        String[] ply={"一周","两周","三周"};
        map.put("ply",ply);
        return map;
    }
    //查询全部
    public List<User> selectAll(){
        return userDao.selectAll();
    }

}
