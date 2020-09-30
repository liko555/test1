<!DOCTYPE html>
<html lang="en">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="checkSession.jsp"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<head>
<base href="${basePath}" />
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link href="css/from.css" type="text/css" rel="stylesheet" />
<link href="css/popdiv.css" type="text/css" rel="stylesheet" />
<script type="text/javascript">
	function delBook(bookId,bookTitle){
		//弹出一个确认对话框，如果单机了确定按钮，弹出信息提示“选择了确定删除”
		if (confirm("确定要删除"+ bookTitle + "吗？")){
			//具体删除的时候，需要传递要删除的漫画类型的id值
			location.href="doDeleteBook.do?bookId=" + bookId;
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
		<form action="doAddBook.do">
			<div class="form">
				<div class="items">
					<img src="images/书名.svg"> <input type="text" placeholder="书名" name="bookTitle" required="required"/>
				</div>
				<div class="items">
					<img src="images/作者.svg"> <input type="text" placeholder="作者" name="author" required="required"/>
				</div>
				<div class="items">
					<img src="images/出版社.svg">
					<!-- <input type="text" placeholder="出版社" /> -->
					<select name="publishId" >
						<option value="0">出版社</option>
						<c:set var="publishList" value="${sessionScope.allPublists}" />
						<c:forEach var="publish" items="${publishList}">
							<option id="publishId" value="${publish.publishId}"
								required="required">${publish.publicName}</option>
						</c:forEach>
					</select>
				</div>
				<div class="items">
					<img src="images/分类-选中 (1).svg">
					<!-- <input type="text" placeholder="类别号"  /> -->
					<select name="typeId">
						<option value="0">分类</option>
						<c:set var="bookTypeList" value="${sessionScope.allTypes}" />
						<c:forEach var="type" items="${bookTypeList}">
							<option id="typeId" value="${type.typeId}" required="required">${type.typeName}</option>
						</c:forEach>
					</select>
				</div>
				<div class="items">
					<img src="images/语言.svg">
					<!-- <input type="text" placeholder="文种" /> -->
					<select name="languageId">
						<option value="0">文种</option>
						<c:set var="languageList" value="${sessionScope.allLanguages}" />
						<c:forEach var="language" items="${languageList}">
							<option id="languageId" value="${language.languageId}"
								required="required">${language.language}</option>
						</c:forEach>
					</select>
				</div>
				<div class="items">
					<img src="images/书架.svg"> 
					<select name="bookrackId">
						<option value="0">书架号</option>
						<c:set var="bookrackList" value="${sessionScope.allBookracks}" />
						<c:forEach var="bookrack" items="${bookrackList}">
							<option id="bookrackId" value="${bookrack.bookrackId}"
								required="required">${bookrack.bookrackName}</option>
						</c:forEach>
					</select>
					<!-- <input type="text" placeholder="书架号" name="bookrack"/> -->
				</div>
				<div class="items">
					<img src="images/库存.svg"> <input type="text" placeholder="现有库存" name="inventory" required="required" id="number" pattern="^[0-9]*$"/>
				</div>
<!-- 				<div class="items">
					<img src="images/借阅 (1).svg"> <input type="text" placeholder="借出数量" name="loan" required="required"/>
				</div> -->
			</div>
			<input type="submit" class="btn addsub" value="添加" />
			<!-- <button type="submit">添加</button> -->
		</form>
	</div>
	<div class="topdiv">
		<button class="btn addpop">添加</button>
		<!-- <a href="admin/#" class="btn addpop">添加</a> -->
		<div class="select">
			<form action="doselect.do">
				查询条件： <select name="selectName">
					<option value="0">全部</option>
					<option value="1">书名</option>
					<option value="2">图书编号</option>
					<option value="3">作者</option>
					<option value="4">出版社</option>
					<option value="5">图书类别</option>
					<option value="6">文种</option>
					<option value="7">书架</option>
				</select> <input type="text" name="condition" placeholder="请输入名称"/> <input type="submit" value="查询" class="btn" />
			</form>
		</div>
		<div class="tiao">
			<form action="showbook.do">
				定位至&nbsp;<input style="width: 30px; height: 14px" name="bPageNo"
					type="text">&nbsp;页&nbsp;&nbsp;<input type="submit"
					value="跳转到" class="btn">
			</form>
		</div>
	</div>
	<hr>
	<table cellspacing="0" cellpadding="0">
		<tr>
			<th>序号</th>
			<th>书名</th>
			<th>现有库存</th>
			<th>借出数量</th>
			<th>删除</th>
			<th>修改</th>
			<th>详细信息</th>
		</tr>
		<c:set var="list" value="${sessionScope.pageBook}" />
		<c:set var="bPageNo" value="${requestScope.bPageNo}" />
		<c:set var="bPageCount" value="${requestScope.bPageCount}" />
		<c:set var="bPageSize" value="${sessionScope.bPageSize}" />
		<c:choose>
			<c:when test="${empty list or list.size() eq 0}">
				<tr bgcolor="#fff">
					<td colspan="7" align="center">没有任何漫画</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:set var="row" value="${(bPageNo-1)*bPageSize }" />
				<c:forEach var="b" items="${list}">
					<c:set var="row" value="${row +1}" />
					<tr bgcolor="#fff">
						<td align="center">${row}</td>
						<td align="center">${b.bookTitle }</td>
						<td align="center">${b.inventory}</td>
						<td align="center">${b.loan}</td>
						<!-- 修改 -->
						<!-- 超链接传参，url地址？参数名=值&参数名=值&.. -->
						<td align="center"><a
							href="javascript:delBook(${b.bookId},'${b.bookTitle}')"><img
								src="images/删 除 (1).svg" /></a></td>
						<!--单击 确定 应跳转删除页面  -->
						<td><a href="modifyBook.do?bookId=${b.bookId}"><img
								src="images/修改（列表）.svg"  /></a></td>
						<td><a href="selBook.do?bookId=${b.bookId }"><img
								src="images/详细信息.svg"  /></a></td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
	<center>
		<c:if test="${bPageNo>1}">
			<a href="showbook.do?bPageNo=${bPageNo-1}">上一页</a>
		</c:if>
		当前第${bPageNo} 页/共${bPageCount }页
		<c:if test="${bPageNo<bPageCount }">
			<a href="showbook.do?bPageNo=${bPageNo+1}">下一页</a>
		</c:if>
	</center>
	<script type="text/javascript">
	    function frmSubmit(){
	    	//根据元素id值获取表单，调用表单的submit方法提交指定的表单
	    	document.getElementById("frm1").submit();
	    }
		window.onload=function(){
			//完成修改下拉列表中的具体选中内容
			//1.找到下拉列表框
			var selectObj=document.getElementById("bPageSize");
			//2.获取下拉列表框中的所有option选项
			//length返回下拉列表框中的选项个数
			var count=selectObj.length;
			//3.判断哪一个option选项它的显示内容和我们选中的每一页显示的行数值相等
			for(var i=0;i<count;i++){
				if(selectObj.options[i].text ==${bPageSize}){
					selectObj.options[i].selected=true;
					break;
				}
			}
		}
	</script>
	<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
	<script type="text/javascript" src="js/pop.js"> </script>
	<script type="text/javascript" src="js/checkfrom.js"> </script>
</body>

</html>