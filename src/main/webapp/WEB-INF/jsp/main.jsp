<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/12/7
  Time: 18:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>菜单</title>
</head>
<body>
<ul>
    <s:hasRole name="管理员">
        <li><a href="user/userList">用户管理</a></li>
    </s:hasRole>
    <s:hasPermission name="书本查询">
        <li><a>用户新增</a></li>
    </s:hasPermission>
    <li><a>用户修改</a></li>
    <li><a>用户删除</a></li>

</ul>
</body>
</html>
