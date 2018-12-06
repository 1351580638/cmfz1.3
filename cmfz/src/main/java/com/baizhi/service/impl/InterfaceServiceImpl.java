package com.baizhi.service.impl;

import com.baizhi.entity.Album;
import com.baizhi.service.InterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("albumservice")
@Transactional
public class InterfaceServiceImpl implements InterfaceService {
    @Autowired
    private InterfaceService interfaceService;


    public Album selectOne(int id){
        Album one = interfaceService.selectOne(id);
        return one;
    }
}
