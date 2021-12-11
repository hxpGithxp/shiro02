package com.zking.shiro;

import com.zking.model.User;
import com.zking.service.IUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

//创建安全数据
public class MyRealm extends AuthorizingRealm {
    @Autowired
    private IUserService userService;

    //角色和权限   授权信息
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
    String username=principalCollection.getPrimaryPrincipal().toString();
        Set<String> roles = userService.getRoleByUserName(username);
        //权限
        Set<String> permsion = userService.getPermissionByUserName(username);
        //获取验证身份
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        //将角色设置
        info.setRoles(roles);
        //将权限设置
        info.setStringPermissions(permsion);
        return info;
    }

    //登录认证   认证信息
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取到前端用户输入的用户名
        String username = authenticationToken.getPrincipal().toString();
        //根据用户名得到该用户的所有信息
        User user = userService.login(username);
        SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(
                //ByteSource.Util.bytes(user.getSalt())  拿到用户的盐
                //  this.getName()   得到这个类的名字  这个类是数据源，到时候会到这个类中来认证的
                user.getUsername(),user.getPassword(), ByteSource.Util.bytes(user.getSalt()),this.getName()
        );

        return info;
    }
}
