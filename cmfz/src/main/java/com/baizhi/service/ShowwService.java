package com.baizhi.service;

import com.baizhi.entity.Showw;

import java.util.List;
import java.util.Map;

public interface ShowwService {
    public Map getAll(Integer start, Integer end);
    //添加
    public void insert(Showw showw);
    //删除
    public void delete(int id);
    //修改
    public void update(Showw showw);
}
