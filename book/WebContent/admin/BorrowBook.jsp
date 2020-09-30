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
        <form action="doBorrowBook.do">
            <div class="form">
                <div class="items">
                    <img src="images/ISBN书号.svg" /><span>图书编号：</span>
                    <input type="text" placeholder="图书编号" name="bookId"/>
                </div>
                <div class="items">
                    <img src="images/用户 (1).svg"><span>用户账号：</span>
                    <input type="text" placeholder="用户账号" name="userName" />
                </div>
                <div class="items">
                    <img src="images/数量.svg"><span>数&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;量：</span>
                    <input type="text" placeholder="1"value="1" name="count"/>
                </div>
            </div>
            <input type="submit" class="btn addsub" value="添加" />
            <!-- <button type="submit">添加</button> -->
        </form>
    </div>
</body>
</html>