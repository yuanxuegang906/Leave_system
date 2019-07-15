package com.qf.controller;

import com.qf.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/*
 * author:袁学港
 * Date:2019/7/13 14:39
 * info:
 * */
@Controller
public class UserController {
    @Autowired
    private SecurityManager securityManager;
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String login(User user, HttpSession session){
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getUsername(),user.getPassword());
        try{
            subject.login(usernamePasswordToken);
            if(subject.isAuthenticated()){
                session.setAttribute("user",user);
                return "homepage";
            }

        }catch (AuthenticationException e){
            System.out.println("登录失败");
        }
        return "login";
    }
    @RequestMapping("homepage")
    public String homepage(){
        return "homepage";
    }
    @RequestMapping("unauthorize")
    public String unauthorize(){
        return "unauthorize";
    }
}
