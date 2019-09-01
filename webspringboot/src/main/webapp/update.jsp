<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/1
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改页面</title>
</head>
<body>
<form action="/hello/update" method="post">
    name:<input type="text" name="name" value="${student.name}"> <br>
    ID:<input type="text" name="id" value="${student.id}"> <br>
    age:<input type="text" name="age" value="${student.age}"> <br>
    <input type="submit" value="提交" >
</form>
</body>
</html>
