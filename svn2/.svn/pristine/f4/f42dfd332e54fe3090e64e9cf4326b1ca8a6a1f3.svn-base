<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: yutao
  Date: 2018/9/20
  Time: 18:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        <form action="yongche/add" method="post" id="expenseForm">
            <table class="table table-bordered">
                <tr>
                    <td>姓名：</td>
                    <td><shiro:principal property="truename"></shiro:principal></td>
                </tr>
                <tr>
                    <td>部门：</td>
                    <td><shiro:principal property="department" ></shiro:principal></td>
                </tr>
                <tr>
                    <td>时间：</td>
                    <td>
                        <div class="form-inline">
                            <div class="form-group"><input type="text" name="beginDate"  id="start_time"></div>
                            到
                            <div class="form-group"><input type="text" name="endDate"  id="end_time"></div>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        用车事由：
                    </td>
                    <td>
                        <textarea name="reason" rows="4" cols="80"></textarea>
                    </td>
                </tr>
                <tr>
                    <td>
                        <button onclick="expenseSubmit();" type="button" class="btn btn-primary">提交</button>
                    </td>
                    <td>
                        <button type="button" class="btn btn-default">返回</button>
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
    $('#start_time').datetimepicker({
        format: 'yyyy-mm-dd hh:ii'
    });
    $('#end_time').datetimepicker({
        format: 'yyyy-mm-dd hh:ii'
    });

    function expenseSubmit() {
        $("#expenseForm").submit();
    }

    function setExpenseType(obj) {
        $("#dropdownMenu2").html(obj+"<span class=\"caret\"></span>");
        $("#expenseType").val(obj);
    }
</script>
</body>
</html>