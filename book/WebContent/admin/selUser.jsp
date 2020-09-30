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
    <div class="BorrowBook" style="padding:0 0 20px 0">
        <div class="close">
            <a href="showManageUsers.do"><img src="images/关  闭 (7)-01 copy.svg" /></a>
        </div>
        <form action="doModifyUser.do">
            <c:set var="user" value="${requestScope.user}" />
			<div class="form" >
				<input type="hidden" placeholder="用户编号" name="userId" value="${user.userId }" readonly="readonly"/>
				<div class="items">
					<img src="images/用户 (1).svg"> <input type="text" placeholder="用户账号" name="userName" value="${user.userName }" readonly="readonly"/>
				</div>
				<div class="items">
					<img src="images/密码.svg"> <input type="text" placeholder="111" value="111" name="userPwd" value="${user.userPwd }" readonly="readonly"/>
				</div>
				<div class="items">
					<img src="images/真实姓名.svg"> <input type="text" placeholder="真实姓名" name="trueName" value="${user.trueName }" readonly="readonly"/>
				</div>
				<div class="items">
					<img src="images/电 话.svg "> <input type="text" placeholder="电话号码" name="phone" value="${user.phone }" readonly="readonly"/>
				</div>
			</div>
            <!-- <button type="submit">添加</button> -->
        </form>
    </div>
</body>
</html>