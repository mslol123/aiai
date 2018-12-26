<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: yutao
  Date: 2018/9/20
  Time: 18:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
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
    <link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet">

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
        <form action="" method="post" id="frm1">
            <input type="hidden" name="id" value="${yongChe.id}">
            <input type="hidden" name="processId" value="${yongChe.processId}">
            <table class="table table-bordered">
                <caption>用车详情</caption>
                <tr>
                    <td>用车事由：</td>
                    <td>${yongChe.reason}</td>
                </tr>
                <tr>
                    <td>开始时间：</td>
                    <td><fmt:formatDate value="${yongChe.beginDate}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>
                </tr>
                <tr>
                    <td>结束时间：</td>
                    <td><fmt:formatDate value="${yongChe.endDate}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>
                </tr>
                <tr>
                    <td>用车申请人：</td>
                    <td>${yongChe.user.truename}</td>
                </tr>
                <tr>
                    <td>
                        <button onclick="fnCheck(1);" type="button" class="btn btn-success">同意</button>
                        <button onclick="fnCheck(2);" type="button" class="btn btn-danger">不同意</button>
                    </td>
                    <td>
                        <button type="button" class="btn btn-default" onclick="history.back();">返回</button>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery-1.8.3.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
<script src="js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript">
    function fnCheck(n) {
        var frm = document.getElementById("frm1");
        if (n == 1){
            frm.action = "yongche/agree";
            frm.submit();
        }else if (n == 2){
            frm.action = "yongche/disAgree";
            frm.submit();
        }else{

        }
    }
</script>
</body>
</html>