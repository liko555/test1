<!DOCTYPE html>
<html lang="en">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="css/selbook.css" type="text/css" rel="stylesheet" />
    <link href="css/book.css" type="text/css" rel="stylesheet" />
</head>
<body style="background-image: url(images/banner.svg); background-size: 100%">
    <div class="banner" >
        <form action="doUserSelBook.do">
            <div class="search">
               <div class="select" >
                    <select name="selectName">
						<option value="1">书名</option>
						<option value="2">图书编号</option>
						<option value="3">作者</option>
						<option value="4">出版社</option>
						<option value="5">图书类别</option>
						<option value="6">文种</option>
						<option value="7">书架</option>
                    </select>
                </div>
                <input type="text" class="search-text" name="condition" placeholder="搜索你想要的图书"/>
                <input type="submit" value="查询" class="bookbtn sub " />
            </div>
        </form>
    </div>

</body>
</html>