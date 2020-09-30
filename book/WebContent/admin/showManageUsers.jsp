<!DOCTYPE html>
<html lang="en">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="checkSession.jsp"%>
<head>
<base href="${basePath}" />
<base href="${basePath}" />
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link href="css/from.css" type="text/css" rel="stylesheet" />
<link href="css/popdiv.css" type="text/css" rel="stylesheet" />
<script type="text/javascript">
	function delUser(userId,userName){
		//弹出一个确认对话框，如果单机了确定按钮，弹出信息提示“选择了确定删除”
		if (confirm("确定要删除"+ userName + "吗？")){
			//具体删除的时候，需要传递要删除的漫画类型的id值
			location.href="doDelUser.do?userId=" +userId;
		}
	}

</script>
</head>

<body>
	<div class="mask"></div>
	<div class="popdiv">
		<div class="close">
			<img src="images/关  闭 (7)-01 copy.svg" />
		</div>
		<form action="doAddUser.do">
			<div class="form">
				<div class="items">
					<img src="images/用户 (1).svg"> 
					<input type="text" placeholder="用户账号" name="userName" required="required" />
				</div>
				<div class="items">
					<img src="images/密码.svg"> 
					<!-- <img src="images/隐藏.svg"/> -->
					<input type="password" placeholder="111" value="111" name="userPwd" required="required" id="userPwd" pattern="^[0-9]*$"/>
					<div id="toggle1" onclick="showHide();"></div>
				</div>
				<div class="items">
					<img src="images/真实姓名.svg"> 
					<input type="text" placeholder="真实姓名" name="trueName" required="required"/>
				</div>
				<div class="items">
					<img src="images/电 话.svg "> 
					<input type="text" id="phoneno" placeholder="电话号码" name="phone" required="required" pattern="1[365789][0-9]{9}"/>
				</div>
			</div>
			<input type="submit" class="btn addsub" value="添加" />
			<!-- <button type="submit">添加</button> -->
		</form>
	</div>
	<div class="topdiv">
		<button class="btn addpop">添加</button>
		<div class="select">
			<form action="doselectUser.do">
				输入用户名：<input type="text" name="condition" placeholder="请输入用户名"/> <input type="submit" value="查询" class="btn" />
			</form>
		</div>
		<div class="tiao">
			<form action="showManageUsers.do">
				定位至&nbsp;<input style="width: 30px; height: 14px" name="btPageNo"
					type="text">&nbsp;页&nbsp;&nbsp;<input type="submit"
					value="跳转到" class="btn">
			</form>
		</div>
	</div>
	<hr>
	<table cellspacing="0" cellpadding="0">
		<tr>
			<th>序号</th>
			<th>用户账号</th>
			<th>删除</th>
			<th>修改</th>
			<th>详细信息</th>
		</tr>
		<c:set var="list" value="${sessionScope.pageBookType}" />
		<c:set var="btPageNo" value="${requestScope.btPageNo}" />
		<c:set var="btPageCount" value="${requestScope.btPageCount}" />
		<c:set var="btPageSize" value="${sessionScope.btPageSize}" />
		<c:choose>
			<c:when test="${empty list }">
				<tr bgcolor="#fff">
					<td colspan="5" align="center">没有任何漫画类型</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:set var="row" value="${(btPageNo-1)*btPageSize }" />
				<c:forEach var="bt" items="${list}">
					<c:set var="row" value="${row +1}" />
					<tr bgcolor="#fff">
						<td align="center">${row}</td>
						<td align="center">${bt.userName }</td>
						<!-- 修改 -->
						<!-- 超链接传参，url地址？参数名=值&参数名=值&.. -->
						<td align="center">
						<!--单击 确定 应跳转删除页面  -->
						<a href="javascript:delUser(${bt.userId},'${bt.userName }')"><img src="images/删 除 (1).svg" /></a></td>
						
						<!--单击 确定 应跳转修改页面  -->
						<td><a href="modifyUser.do?userId=${bt.userId}"><img src="images/修改（列表）.svg" class="modifypop" /></a></td>
						
						<!--单击 确定 查看详细信息页面  -->
						<td><a href="selUser.do?userId=${bt.userId }"><img src="images/详细信息.svg"  /></a></td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
	<center>
		<c:if test="${btPageNo>1}">
			<a href="showManageUsers.do?btPageNo=${btPageNo-1}">上一页</a>
		</c:if>
		当前第${btPageNo} 页/共${btPageCount }页
		<c:if test="${btPageNo<btPageCount }">
			<a href="showManageUsers.do?btPageNo=${btPageNo+1}">下一页</a>
		</c:if>
	</center>
	<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
	<script type="text/javascript" src="js/pop.js"> </script>
    <script type="text/javascript" src="js/checkfrom.js"> </script>
</body>

</html>