
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="panel-group col-md-2" id="accordion" role="tablist" aria-multiselectable="true">
    <div class="panel panel-default">
        <div class="panel-heading" role="tab" id="headingOne">
            <h4 class="panel-title">
                <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                    OA系统
                </a>
            </h4>
        </div>
        <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
            <div class="panel-body">
                <ul class="list-group">
                    <li class="list-group-item">系统首页</li>
                    <li class="list-group-item">系统公告</li>
                </ul>
            </div>
        </div>
    </div>
    <div class="panel panel-default">
        <div class="panel-heading" role="tab" id="headingTwo">
            <h4 class="panel-title">
                <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                    甘震—考勤管理
                </a>
            </h4>
        </div>
        <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
            <div class="panel-body">
                <ul class="list-group">
                    <li class="list-group-item"><a href="leave/list">我的请假考勤</a></li>
                    <li class="list-group-item"><a href="jiaban/list">我的加班考勤</a></li>
                    <li class="list-group-item"><a href="leave/preAdd">请假申请</a></li>
                    <li class="list-group-item"><a href="jiaban/preAdd">加班申请</a></li>
                    <li class="list-group-item"><a href="leave/checkList">请假审批</a></li>
                    <li class="list-group-item"><a href="jiaban/checkList">加班审批</a></li>
                </ul>
            </div>
        </div>
    </div>
    <div class="panel panel-default">
        <div class="panel-heading" role="tab" id="headingFour">
            <h4 class="panel-title">
                <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseFour" aria-expanded="false" aria-controls="collapseFour">
                    李宇涛-售后管理
                </a>
            </h4>
        </div>
        <div id="collapseFour" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingFour">
            <div class="panel-body">
                <ul class="list-group">
                    <li class="list-group-item"><a href="yongche/preAdd">用车申请</a></li>
                    <li class="list-group-item"><a href="chuchai/preAdd">出差申请</a></li>
                    <li class="list-group-item"><a href="chuchai/list">我的出差考勤</a></li>
                    <li class="list-group-item"><a href="yongche/list">用车列表考勤</a></li>
                    <li class="list-group-item"><a href="yongche/checkList">用车审批</a></li>
                    <li class="list-group-item"><a href="chuchai/checkList">出差审批</a></li>
                </ul>
            </div>
        </div>
    </div>
</div>
