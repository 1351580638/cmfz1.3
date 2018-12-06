package com.baizhi.dao;

import com.baizhi.entity.Album;

import java.util.List;

public interface InterfaceDao {
    //章节表
    public List<Album> selectAll();
    //根据id查询
    public Album selectOne(int id);
}
