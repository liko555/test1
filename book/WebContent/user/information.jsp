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
<div class="BorrowBook selBook" style="padding:0 0 20px 0">
        <div class="close">
            <a href="doUserSelBook.do"><img src="images/关  闭 (7)-01 copy.svg" /></a>
        </div>
        <form>
        	<c:set var="b" value="${requestScope.book}"/>
        	<input type="hidden" id="bookId" name="bookId" value="${b.bookId }" readonly="readonly"/>
            <div class="form">
                <div class="items">
                    <img src="images/书名.svg"><span>书&nbsp;&nbsp;名</span>
                    <input type="text" name="bookTitle" value="${b.bookTitle }"readonly="readonly" />
                </div>
                <div class="items">
                    <img src="images/作者.svg"><span>作&nbsp;&nbsp;者</span>
                    <input type="text" name="author" value="${b.author }" readonly="readonly"/>
                </div>
                <div class="items">
                    <img src="images/出版社.svg"><span>出版社</span>
                    <input type="text" placeholder="出版社" value="${b.publish.publicName }" readonly="readonly"/>
                </div>
                <div class="items">
                    <img src="images/分类-选中 (1).svg" ><span>分&nbsp;&nbsp;类</span>
                    <input type="text" placeholder="类别号"  value="${b.bt.typeName}" readonly="readonly"/> 
                </div>
                <div class="items">
                    <img src="images/语言.svg" ><span>文&nbsp;&nbsp;种</span>
                    <input type="text" placeholder="文种" value="${b.language.language }" readonly="readonly"/>
                </div>
                <div class="items">
                    <img src="images/书架.svg"><span>书&nbsp;&nbsp;架</span>
                    <input type="text" placeholder="书架" value="${b.bookrack.bookrackName}" readonly="readonly"/>
                </div>
                <div class="items">
                    <img src="images/库存.svg"><span>库&nbsp;&nbsp;存</span>
                    <input type="text" name="inventory" value="${b.inventory }" readonly="readonly"/>
                </div>
                <div class="items">
                    <img src="images/借阅 (1).svg"><span>借&nbsp;&nbsp;阅</span>
                    <input type="text" name="loan" value="${b.loan }" readonly="readonly"/>
                </div>
            </div>
            <!-- <button type="submit">添加</button> -->
        </form>
        </form>
    </div>
</body>
</html>