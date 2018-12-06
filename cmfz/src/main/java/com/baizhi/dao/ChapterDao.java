package com.baizhi.dao;

import com.baizhi.entity.Chapter;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ChapterDao {
    public List<Chapter> selectAll();
    public int getCount();

    public void insert(Chapter chapter);
}
