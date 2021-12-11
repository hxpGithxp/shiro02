package com.zking.mapper;

import com.zking.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);


    //根据用户名字查询用户所有信息
   public User  login(String username);


    /**
     * 根据用户名获取到用户的角色信息
     * @param username
     * @return
     */
   public Set<String>  getRoleByUserName(String username);

    /**
     * 根据用户名获取到用户的权限
     * @param username
     * @return
     */
   public  Set<String> getPermissionByUserName(String username);






    /**
     * 查询所有用户
     * @return
     */
   List<User> list();

}