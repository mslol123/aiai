<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/8 0008
  Time: 下午 4:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Title</title>
    <base href="<%=request.getContextPath()%>/"/>
    <link rel="stylesheet" href="css/signin.css" type="text/css">
    <link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <form class="form-signin" action="login" method="post">
        <h2 class="form-signin-heading">登录页</h2>
        <input type="text" class="form-control" name="username" placeholder="用户名">
        <input type="text" class="form-control" name="password" placeholder="密码">
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    </form>
</div>
</body>
</html>
