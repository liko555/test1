<!DOCTYPE html>
<html lang="en">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="checkSession.jsp"%>
<head>
<base href="${basePath}" />
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="css/adminStyle.css" type="text/css" rel="stylesheet" />

</head>
<body>
    <div class="sidebar">
        <header>图书借阅管理系统</header>
        <ul>
            <li><a href="UserSelBook.do" target="mainContent"><img src="images/图书.svg"/>查询图书</a></li>
            <li><a href="doUserSelBook.do" target="mainContent"><img src="images/借阅记录.svg"/>所有图书列表</a></li>
            <li><a href="UserDoSelRecord.do?userId=${sessionScope.userObj.userId }" target="mainContent"><img src="images/借阅记录.svg"/>图书借阅记录</a></li>
        </ul>
    </div>
    <div>
        <div class="tab">
            <img src="images/用户 (1).svg" width="14px"><span>欢迎您，${sessionScope.userObj.trueName }</span>
            <a href="UserCenter.do?userId=${sessionScope.userObj.userId }" target="mainContent">个人中心</a>
            <a href="logout.do">退出登录</a>
        </div>
        <div class="main">
            <!-- 显示具体内容 -->
            <iframe width="100%" height="600px" frameborder="0" name="mainContent" src="UserDoSelRecord.do?userId=${sessionScope.userObj.userId }"/>
        </div>
    </div>
    
</body>
</html>