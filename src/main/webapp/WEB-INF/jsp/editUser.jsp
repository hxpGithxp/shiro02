<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/12/8
  Time: 19:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑用户</title>
</head>
<body>
<form action="/shiro02/user/doEdit" method="post">
    <input type="hidden" name="userid" value="${u.userid}">
    新增用户名：<input type="text" name="username" value="${u.username}"><br/>
    密码:<input type="text" name="password" value="${u.password}"><br/>
    <input type="submit"/>
</form>

</body>
</html>
