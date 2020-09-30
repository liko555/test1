<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%-- <%
	//获取当前路径
	String path=request.getContextPath();//获取Contect root
	/* out.print(path); */
	//组合基准路径
	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	/* out.print(basePath);  */
%> --%>

<!-- 获取当前路径 -->
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!-- 组合基准路径 -->
<c:set var="basePath" value="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${path}/"/>

<c:set var="obj" value="${sessionScope.adminObj}"/>
<c:if test="${empty obj }" >
	<c:redirect url="${basePath }dologin.jsp"/>
</c:if>
<%-- 
		Object obj=session.getAttribute("adminObj");
		if(obj == null){
			// 表示这个用户还没有登陆，要求用户去登陆，转向登陆界面
			response.sendRedirect(path+"/index2.jsp");
			return;
		}
--%>
