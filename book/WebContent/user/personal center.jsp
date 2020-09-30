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
    <link href="css/BorrowBook.css" type="text/css" rel="stylesheet" />
</head>
<body>
    <div class="mask"></div>
    <div class="BorrowBook">
        <form action="doModifyUserCenter.do">
        	<c:set var="user" value="${requestScope.user}" />
        	<input type="hidden" name="userId" value="${user.userId }"/>
            <div class="form">
                <div class="items">
                    <img src="images/用户 (1).svg" />&nbsp;&nbsp;我的账号&nbsp;&nbsp;
                    <input type="text" name="userName" value="${user.userName }" readonly="readonly" Style="color:#7f8c8d"/>
                </div>
                <div class="items">
                    <img src="images/密码.svg">&nbsp;&nbsp;我的密码&nbsp;&nbsp;
                    <input type="password" name="userPwd"  value="${user.userPwd }" required="required" id="userPwd" pattern="^[0-9]*$"/>
                    <div id="toggle1" onclick="showHide();"></div>
                </div>
                <div class="items">
                    <img src="images/真实姓名.svg" />&nbsp;&nbsp;真实姓名&nbsp;&nbsp;
                    <input type="text" name="trueName" value="${user.trueName }" readonly="readonly" Style="color:#7f8c8d"/>
                </div>
                <div class="items">
                    <img src="images/电 话.svg" />&nbsp;&nbsp;电话号码&nbsp;&nbsp;
                    <input type="text" name="phone" id="phoneno" value="${user.phone }" required="required" pattern="1[365789][0-9]{9}"/>
                </div>
            </div>
            <input type="submit" class="btn modifyName" value="修改" />
            <!-- <button type="submit">添加</button> -->
        </form>
    </div>
    <script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="js/pop.js"> </script>
    <script type="text/javascript" src="js/checkfrom.js"> </script>
</body>
</html>