
<%--
  Created by IntelliJ IDEA.
  User: yutao
  Date: 2018/9/20
  Time: 18:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>千锋教育OA系统</title>
    <base href="<%=request.getContextPath()%>/"/>
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <![endif]-->
</head>
<body>
<%@include file="../nav.jsp"%>
<div class="container-fluid">
    <%@include file="../menu.jsp"%>
    <div class="col-md-10">

        <table class="table table-bordered table-hover">
            <thead class="bg-primary">
            <tr>
                <th>用车事由</th>
                <th>用车开始时间</th>
                <th>用车结束时间</th>
                <th>创建时间</th>
                <th>状态</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${yongCheTaskList}" var="yongche">
                <tr>
                    <td>${yongche.reason}</td>
                    <td><fmt:formatDate value="${yongche.beginDate}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>
                    <td><fmt:formatDate value="${yongche.endDate}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>
                    <td><fmt:formatDate value="${yongche.createDate}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>
                    <td>${yongche.status}</td>
                    <td>
                        <a href="yongche/detail/${yongche.id}">详情</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery-1.8.3.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
</body>
</html>