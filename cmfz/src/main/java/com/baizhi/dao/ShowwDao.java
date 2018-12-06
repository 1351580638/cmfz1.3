package com.baizhi.dao;


import com.baizhi.entity.Showw;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShowwDao {
    public List<Showw> getAll(@Param("start")Integer start,@Param("end")Integer end);
    //添加
    public void insert(Showw showw);
    //删除
    public void delete(int id);
    //个数
    public int getCount();
    //修改
    public void update(Showw showw);
}
