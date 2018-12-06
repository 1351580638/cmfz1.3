package com.baizhi.service;

import com.baizhi.test2.Artical;


import java.util.List;

public interface LuceneService {
    //添加
    public void addIndex(Artical artical);
    //删除
    public void delete(String id);
    //修改
    public void update(Artical artical);
    //查询
    public List<Artical> list(String params);



}
