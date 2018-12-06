package com.baizhi.controller;
import com.baizhi.entity.Users;
import com.baizhi.service.UsersService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UsersController {
    @Autowired
    private UsersService usersService;
    @RequestMapping("/login")
    public String  login(Users users, String kaptcha, HttpSession session){
        String sessionkaptcha=(String)session.getAttribute("kaptcha");
        if(kaptcha.equalsIgnoreCase(sessionkaptcha)){
            Users us=usersService.getOne(users);
            if(us!=null){
                session.setAttribute("user",us);
                return "forward:/main/main.jsp";
            }else{
                return "redirect:login.jsp";
            }
        }
        return "redirect:/login.jsp";
    }
}


/*    例子
@Controller
@RequestMapping("user")
public class UserController {
    @RequestMapping("loginUser")
    public String login(String userName, String password) {
        //通过 用户名 查询当前用户数据 比对密码
        Subject subject = SecurityUtils.getSubject();
        AuthenticationToken token = new UsernamePasswordToken(userName, password);
        try {
            subject.login(token);
            return "index";
        } catch (UnknownAccountException e) {
            System.out.println("用户名错误");
            return "login";
        } catch (IncorrectCredentialsException e) {
            System.out.println("密码错误");
            return "login";
        }

    }

    @RequestMapping("logoutUser")
    public String loginOut() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "login";
    }

    @RequestMapping("test")
    @ResponseBody
    public void login() {
        System.out.println("===================================");
    }*/
