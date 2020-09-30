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
<link href="css/from.css" type="text/css" rel="stylesheet" />
<link href="css/popdiv.css" type="text/css" rel="stylesheet" />
<script type="text/javascript">
	function delBookType(typeId,typeName){
		//弹出一个确认对话框，如果单机了确定按钮，弹出信息提示“选择了确定删除”
		if (confirm("确定要删除"+ typeName + "吗？ 如果删除的话会删除改类型下的全部图书")){
			//具体删除的时候，需要传递要删除的漫画类型的id值
			location.href="doDelBookType.do?typeId=" +typeId;
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
		<form action="doAddBookType.do">
			<div class="form">
				<div class="items">
					<img src="images/书名.svg"> <input type="text"
						placeholder="类别名" name="typeName" required="required"/>
				</div>
			</div>
			<input type="submit" class="btn addsub" value="添加" />
			<!-- <button type="submit">添加</button> -->
		</form>
	</div>
	<div class="topdiv">
		<button class="btn addpop">添加</button>
		<div class="select">输入类别名：
			<form action="doselectType.do" style="display: inline;">
				<input type="text" name="condition" placeholder="请输入名称" /> <input
					type="submit" value="查询" class="btn" />
			</form>
		</div>
		<div class="tiao">
			<form action="showBookType.do">
				定位至&nbsp;<input style="width: 30px; height: 14px" name="btPageNo" type="text">&nbsp;页&nbsp;&nbsp;
					<input type="submit" value="跳转到" class="btn">
			</form>
		</div>
	</div>
	<hr>
	<table cellspacing="0" cellpadding="0">
		<tr>
			<th>序号</th>
			<th>类别名</th>
			<th>删除</th>
			<th>修改</th>
		</tr>
		<c:set var="list" value="${sessionScope.pageBookType}" />
		<c:set var="btPageNo" value="${requestScope.btPageNo}" />
		<c:set var="btPageCount" value="${requestScope.btPageCount}" />
		<c:set var="btPageSize" value="${sessionScope.btPageSize}" />
		<c:choose>
			<c:when test="${empty list }">
				<tr bgcolor="#fff">
					<td colspan="4" align="center">没有任何图书类型</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:set var="row" value="${(btPageNo-1)*btPageSize }" />
				<c:forEach var="bt" items="${list}">
					<c:set var="row" value="${row +1}" />
					<tr bgcolor="#fff">
						<td align="center">${row}</td>
						<td align="center">${bt.typeName }</td>
						<!-- 修改 -->
						<!-- 超链接传参，url地址？参数名=值&参数名=值&.. -->
						<td align="center"><a
							href="javascript:delBookType(${bt.typeId},'${bt.typeName }')"><img
								src="images/删 除 (1).svg" /></a></td>
						<!--单击 确定 应跳转删除页面  -->
						<td><a href="modifyBookType.do?typeId=${bt.typeId}"><img
								src="images/修改（列表）.svg" class="modifypop" /></a></td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>

	<center>
		<c:if test="${btPageNo>1}">
			<a href="showBookType.do?btPageNo=${btPageNo-1}">上一页</a>
		</c:if>
		当前第${btPageNo} 页/共${btPageCount}页
		<c:if test="${btPageNo<btPageCount }">
			<a href="showBookType.do?btPageNo=${btPageNo+1}">下一页</a>
		</c:if>
	</center>
	<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
	<script type="text/javascript" src="js/pop.js"> </script>
</body>

</html>