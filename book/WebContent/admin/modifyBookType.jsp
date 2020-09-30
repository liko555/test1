<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="checkSession.jsp"%>
<!DOCTYPE html>
<html>
<head>
<base href="${basePath}" />
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/BorrowBook.css" type="text/css" rel="stylesheet" />
</head>
<body>
    <div class="BorrowBook">
        <div class="close">
            <a href="showBookType.do"><img src="images/关  闭 (7)-01 copy.svg" /></a>
        </div>
        <form action="doModifyBookType.do">
        	<c:set var="bookType" value="${requestScope.bookType}" />
        	<input type="hidden" id="typeId" name="typeId" value="${bookType.typeId }" />
            <div class="form">
                <div class="items">
                    <img src="images/书名.svg"><span>类型名</span>
                    <input type="text" placeholder="类型名" name="typeName" value="${bookType.typeName }" required="required"/>
                </div>
            </div>
            <input type="submit" class="btn modifysub" value="修改"  />
            <!-- <button type="submit">添加</button> -->
        </form>
    </div>
</body>
</html>