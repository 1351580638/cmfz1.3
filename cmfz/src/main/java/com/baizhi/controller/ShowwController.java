package com.baizhi.controller;


import com.baizhi.entity.Showw;
import com.baizhi.service.ShowwService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.Map;

@Controller
/*@RequestMapping("/showw")*/
public class ShowwController {

    @Autowired
    private ShowwService showwService;
    @RequestMapping("/show")
    public @ResponseBody Map getAll(Integer page, Integer rows){
        return showwService.getAll(page,rows);
    }
    //添加
    @RequestMapping("/insert")
    public void insert(Showw showw){
        showwService.insert(showw);
    }
    //删除
    @RequestMapping("/delete")
    public void delete(int id){
        showwService.delete(id);
    }
    //修改
    @RequestMapping("/update")
    public void update(Showw showw){

        showwService.update(showw);
    }
}
