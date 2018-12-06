package com.baizhi.service;

import com.baizhi.entity.Chapter;

import java.util.List;
import java.util.Map;

public interface ChapterService {
    public List<Chapter> selectAll();
    public void insert(Chapter chapter);
}
