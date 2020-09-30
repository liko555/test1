<!DOCTYPE html>
<html lang="en">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="css/dologin1.css" type="text/css" rel="stylesheet" />
    
</head>

<body>
    <img src="images/bg3.png" class="wave"/>
    <div class="container">
        <div class="img">
            <img src="images/book2.svg" alt="" />
        </div>
        <div class="login-box">
            <form action="dologin.do" method="post">
                <img src="images/avathor.svg" alt="" class="avatar">
                <h2>Welcome</h2>
                <div class="select">
                    <select name="type">
                        <option  value="1">管理员</option>
                        <option  value="0">用户</option>
                    </select>
                </div>     
                <div class="input-group">
                    <div class="icon">
                        <i class="fa fa-user"></i>
                        <img src="images/用户.svg" width="14px">
                    </div>
                    <div>
                        <h5>用户名</h5>
                        <input type="text" name="uname" id="" class="input">
                    </div>
                </div>
                <div class="input-group">
                    <div class="icon">
                        <i class="fa fa-lock"></i>
                        <img src="images/password.svg" width="14px"/>
                    </div>
                    <div>
                        <h5>密码</h5>
                        <input type="password" name="upwd" id="" class="input">
                    </div>
                </div>
                <button type="submit" class="btn" value="login">登录</button>
            </form>
        </div>
    </div>    
    <script src="js/dologin.js" type="text/javascript"></script>
</body>
</html>