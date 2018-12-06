package com.baizhi.service.impl;

import com.baizhi.dao.AlbumDao;
import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("albumService")
@Transactional
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    private AlbumDao albumDao;
    public Map selectAll(){
       List<Album>list= albumDao.selectAll();
       Map map=new HashMap();
       map.put("rows",list);
        return map;
    }

}
