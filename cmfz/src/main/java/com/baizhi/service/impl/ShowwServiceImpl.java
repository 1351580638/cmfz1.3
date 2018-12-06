package com.baizhi.service.impl;

import com.baizhi.dao.ShowwDao;

import com.baizhi.entity.Showw;
import com.baizhi.service.ShowwService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("showwService")
@Transactional
public class ShowwServiceImpl implements ShowwService {
    @Autowired
    private ShowwDao showwDao;

    @Override
    public Map getAll(Integer page,Integer rows){
        int start = (page - 1) * rows + 1;
        int end = page * rows;
        List<Showw>list= showwDao.getAll(start,end);
        int count=showwDao.getCount();
        Map map=new HashMap();
        map.put("rows", list);
        map.put("total", count);
        return map;
    }
    //添加
    public void insert(Showw showw){
        showwDao.insert(showw);
    }
    //删除
    public void delete(int id){
        showwDao.delete(id);
    }
    //修改
    public void update(Showw showw){
        showwDao.update(showw);
    }
}
