package com.zking.service.impl;

import com.zking.mapper.UserMapper;
import com.zking.model.User;
import com.zking.service.IUserService;
import com.zking.util.PasswordHelper;
import lombok.AllArgsConstructor;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int deleteByPrimaryKey(Integer userid) {
        return userMapper.deleteByPrimaryKey(userid);
    }

    @Override
    public int insert(User record) {
        //得到前端用户传递过来的密码进行盐创建已经盐加密
        String salt = PasswordHelper.createSalt();//得到一个盐
        //加密后的密码
        String pwd = PasswordHelper.createCredentials(record.getPassword(), salt);
        record.setSalt(salt);//把盐设置进去
        record.setPassword(pwd); //把密码设置进去
        return userMapper.insert(record);
    }

    @Override
    public int insertSelective(User record) {
        return 0;
    }

    @Override
    public User selectByPrimaryKey(Integer userid) {
        return userMapper.selectByPrimaryKey(userid);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }

    @Override
    public User login(String username) {
        return userMapper.login(username);
    }

    @Override
    public Set<String> getRoleByUserName(String username) {
        return userMapper.getRoleByUserName(username);
    }

    @Override
    public Set<String> getPermissionByUserName(String username) {
        return userMapper.getPermissionByUserName(username);
    }


    @Override
    public List<User> list() {
        return userMapper.list();
    }

}
