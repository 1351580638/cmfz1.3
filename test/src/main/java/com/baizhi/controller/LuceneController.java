package com.baizhi.controller;

import com.baizhi.service.LuceneService;
import com.baizhi.test2.Artical;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class LuceneController {
    @Autowired
    private LuceneService luceneService;
    @RequestMapping("/all")
    public List<Artical> select(String params){
        List<Artical> list = luceneService.list(params);
        return list;
    }

}
