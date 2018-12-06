package com.baizhi.controller;

import com.baizhi.service.UserDTOService;
import com.baizhi.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/sss")
public class UserDTOController {
    @Autowired
    private UserDTOService userDTOService;
    @Autowired
    private UserService userService;

    @RequestMapping("/sex")
    public @ResponseBody Map selectSex(){

       return userDTOService.selectAll();
     }
    @RequestMapping("/count")
    public @ResponseBody Map SelectCountt(){
        return userService.selectCountt();
    }
}
