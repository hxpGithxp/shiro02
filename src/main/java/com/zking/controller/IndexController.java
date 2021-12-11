package com.zking.controller;

import com.zking.model.User;
import com.zking.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

//专门负责跳转页面的
@Controller
public class IndexController {
    @Autowired
    private IUserService userService;

    @RequestMapping("/goEdit")
    public  String goEdit(){
       return "editUser";
    }

    @RequestMapping("/goUpdate")
    public  String getSinglUpdate(Integer userId, HttpSession session){
        User user = userService.selectByPrimaryKey(userId);
        session.setAttribute("u",user);
        return "editUser";
    }


}
