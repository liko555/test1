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
            <a href="showManageUsers.do"><img src="images/关  闭 (7)-01 copy.svg" /></a>
        </div>
        <form action="doModifyUser.do">
            <c:set var="user" value="${requestScope.user}" />
			<div class="form">
				<input type="hidden" placeholder="用户编号" name="userId" value="${user.userId }"/>
				<div class="items">
					<img src="images/用户 (1).svg"> <input type="text" placeholder="用户账号" name="userName" value="${user.userName }" required="required"/>
				</div>
				<div class="items">
					<img src="images/密码.svg"> <input type="text" placeholder="111" value="111" name="userPwd" value="${user.userPwd }" required="required"/>
				</div>
				<div class="items">
					<img src="images/真实姓名.svg"> <input type="text" placeholder="真实姓名" name="trueName" value="${user.trueName }" required="required"/>
				</div>
				<div class="items">
					<img src="images/电 话.svg "> <input type="text" id="phoneno" placeholder="电话号码" name="phone" value="${user.phone }" required="required" pattern="1[365789][0-9]{9}"/>
				</div>
			</div>
            <input type="submit" class="btn modifysub" value="修改"  />
            <!-- <button type="submit">添加</button> -->
        </form>
    </div>
   	<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
   	<script type="text/javascript" src="js/checkfrom.js"> </script>
</body>
</html>