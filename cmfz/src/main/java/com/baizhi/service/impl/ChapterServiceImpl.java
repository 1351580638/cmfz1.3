package com.baizhi.service.impl;

import com.baizhi.dao.ChapterDao;
import com.baizhi.entity.Album;
import com.baizhi.entity.Chapter;
import com.baizhi.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("chapterService")
@Transactional
public class ChapterServiceImpl implements ChapterService {
    @Autowired
    private ChapterDao chapterDao;
    public List<Chapter> selectAll(){
        List<Chapter>list=chapterDao.selectAll();
        return list;
    }
    public void insert(Chapter chapter){
        chapterDao.insert(chapter);
    }

}
