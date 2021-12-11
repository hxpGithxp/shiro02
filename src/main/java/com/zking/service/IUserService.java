package com.zking.service;

import com.zking.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Transactional
public interface IUserService {
    int deleteByPrimaryKey(Integer userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);


    //根据用户名字查询用户所有信息
   public User  login(String username);

    public Set<String> getRoleByUserName(String username);

    public  Set<String> getPermissionByUserName(String username);

    /**
     * 查询所有用户
     * @return
     */
    List<User> list();

}