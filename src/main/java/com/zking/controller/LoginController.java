package com.zking.controller;

import com.zking.model.User;
import com.zking.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//盐加密  根据密文生成一个密钥在根据密钥加密
@Controller
public class LoginController {
    @Autowired
    private IUserService userService;

    @RequestMapping("/gologin")
    public  String ss(){
        return "login";
    }


    @RequestMapping("/dologin")
    public String  dologin(User user, HttpSession session){
        //得到主体
        Subject subject = SecurityUtils.getSubject();
        int code=1;
        String msg="";
        Map<String,Object> map=new HashMap<>();
         UsernamePasswordToken token=new UsernamePasswordToken(
           user.getUsername(),user.getPassword()
         );
        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            msg="账号不存在";
            code=-1;
        }catch (IncorrectCredentialsException e){
            msg="密码错误";
            code=0;
        }
        map.put("code",code);
        map.put("msg",msg);
        session.setAttribute("map",map);
        if (code<1){
            return "login";
        }else{  //登录成功
            return "main";
        }

    }



}
