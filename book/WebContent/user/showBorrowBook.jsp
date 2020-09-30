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
</head>

<body>
    <div class="topdiv">
        <div class="select">
            <form action="UserDoSelRecord.do" style="display:inline;">
            <input type="hidden" name="userId" value="${sessionScope.userObj.userId }">
               	 查询条件：
                <select name="sel">               
                    <option value="0">全部</option>
                    <option value="1">未归还</option>
                    <option value="2">已归还</option>
                    <option value="5">已超时</option>
                    <option value="3">图书编号</option>
                    <option value="4">书名</option>
                </select>
                <input type="text" name="condition"/>
                <input type="submit" value="查询" class="btn" />
            </form>
        </div>
		<div class="tiao">
			<form action="UserDoSelRecord.do">
				定位至&nbsp;<input style="width: 30px; height: 14px" name="btPageNo"
					type="text">&nbsp;页&nbsp;&nbsp;<input type="submit"
					value="跳转到" class="btn">
			</form>
		</div>
    </div>
    <hr>
    <table cellspacing="0" cellpadding="0">
        <tr>
            <th>序号号</th>
            <th>书名</th>
            <th>借阅时间</th>
            <th>归还时间</th>
            <th>应当归还时间</th>
            <th>当前状态</th>            
        </tr>
        <c:set var="list" value="${sessionScope.pageRecord}" />
		<c:set var="btPageNo" value="${requestScope.bPageNo}" />
		<c:set var="btPageCount" value="${requestScope.bPageCount}" />
		<c:set var="btPageSize" value="${sessionScope.bPageSize}" />
		<c:choose>
			<c:when test="${empty list }">
				<tr bgcolor="#fff">
					<td colspan="6" align="center">没有任何记录</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:set var="row" value="${(btPageNo-1)*btPageSize }" />
				<c:forEach var="record" items="${list}">
					<c:set var="row" value="${row +1}" />
					<tr bgcolor="#fff">
						<td align="center">${row}</td>
						<td align="center">${record.book.bookTitle }</td> 
						<td align="center">${record.brrowTime }</td>
						<td align="center">${record.retuenTime }</td>
						<td align="center">${record.expectedTime }</td>
						<!-- 修改 -->
						<!-- 超链接传参，url地址？参数名=值&参数名=值&.. -->
						<td align="center">	
								<c:if test="${empty record.retuenTime}">
										<img src="images/未归还.svg" />
								</c:if>	
								<c:if test="${not empty record.retuenTime}">
									<img src="images/归还.svg" />
								</c:if>	
						</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
    </table>
	<center>
		<c:set var="sel" value="${requestScope.sel}" />
		<c:if test="${empty sel}">
			<c:set var="sel" value="0" />
		</c:if>
		<c:if test="${bPageNo>1}">
			<a href="UserDoSelRecord.do?bPageNo=${bPageNo-1}&sel=${sel}">上一页</a>
		</c:if>
		当前第${bPageNo} 页/共${bPageCount }页
		<c:if test="${bPageNo<bPageCount }">
			<a href="UserDoSelRecord.do?bPageNo=${bPageNo+1}&sel=${sel}">下一页</a>
		</c:if>
	</center>
</body>

</html>