<!DOCTYPE html>
<html lang="en">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<head>
<base href="${basePath}" />
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="css/adminStyle.css" type="text/css" rel="stylesheet" />
    <script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
</head>
<body>
    <div class="sidebar">
        <header>图书借阅管理系统</header>
        <ul>
            <li><a href="showbook.do" target="mainContent"><img src="images/图书.svg"/>图书管理</a></li>
            <li><a href="showBookType.do" target="mainContent"><img src="images/类别.svg"/>图书类别分类</a></li>
            <li><a href="showManageUsers.do" target="mainContent"><img src="images/读者.svg"/>读者管理</a></li>
            <li><a href="BorrowBook.do" target="mainContent"><img src="images/借阅.svg"/>图书借阅</a></li>
            <li><a href="showBorrowBook.do" target="mainContent"><img src="images/借阅记录.svg"/>图书借阅记录</a></li>
        </ul>
    </div>
    <div>
        <div class="tab">
            <img src="images/用户 (1).svg" width="14px"><span>欢迎您，${sessionScope.adminObj.trueName }</span>
            <a href="AdminCenter.do?adminId=${sessionScope.adminObj.adminId }" target="mainContent">个人中心</a>
            <a href="logout.do">退出登录</a>
        </div>
        <div class="main">
            <!-- 显示具体内容 -->
            <iframe width="100%" height="600px" frameborder="0" name="mainContent" src="showbook.do"/>
        </div>
    </div>
    
</body>
</html>