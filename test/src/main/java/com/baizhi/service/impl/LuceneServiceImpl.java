package com.baizhi.service.impl;

import com.baizhi.service.LuceneService;
import com.baizhi.test2.Artical;
import com.baizhi.test2.LuceneDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LuceneServiceImpl implements LuceneService {
    @Autowired
    private LuceneDao luceneDao;
    //添加
    public void addIndex(Artical artical){
        luceneDao.addIndex(artical);
    }
    //删除
    public void delete(String id){
        luceneDao.delete("5");
    }
    //修改
    public void update(Artical artical){
        luceneDao.update(artical);
    }
    //查询

    public List<Artical> list(String params){
        List<Artical> query = luceneDao.query(params);
        return query;
    }


}
