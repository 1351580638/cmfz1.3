package com.baizhi.service.impl;

import com.baizhi.dao.UserDTODao;
import com.baizhi.entity.UserDTO;
import com.baizhi.service.UserDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("userDTOService")
@Transactional
public class UserDTOServiceImpl implements UserDTOService {
    @Autowired

    private UserDTODao userDTODao;
    public Map selectAll(){
        Map map=new HashMap();
        List<UserDTO> list = userDTODao.Man();
        map.put("man",list);
        List<UserDTO> list2=userDTODao.Woman();
        map.put("woman",list2);
        return map;
    }
}
