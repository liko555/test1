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
			<a href="showbook.do"><img src="images/关  闭 (7)-01 copy.svg" /></a>
		</div>
		<form action="doModifyBook.do">
			<c:set var="b" value="${requestScope.book}" />
			<input type="hidden" id="bookId" name="bookId" value="${b.bookId }" />
			<div class="form">
				<div class="items">
					<img src="images/书名.svg"><span>书&nbsp;&nbsp;名</span> <input
						type="text" name="bookTitle" value="${b.bookTitle }" required="required"/>
				</div>
				<div class="items">
					<img src="images/作者.svg"><span>作&nbsp;&nbsp;者</span> <input
						type="text" name="author" value="${b.author }" required="required"/>
				</div>
				<div class="items">
					<img src="images/出版社.svg"><span>出版社</span>
					<!-- <input type="text" placeholder="出版社" /> -->
					<select name="publishId" id="publishId">
						<c:set var="publishList" value="${sessionScope.allPublists}" />
						<c:forEach var="publish" items="${publishList}">
							<option id="publishId" value="${publish.publishId}"
								required="required">${publish.publicName}</option>
						</c:forEach>
					</select>
				</div>
				<div class="items">
					<img src="images/分类-选中 (1).svg"><span>分&nbsp;&nbsp;类</span>
					<!-- <input type="text" placeholder="类别号"  /> -->
					<select name="typeId" id="typeId">
						<c:set var="bookTypeList" value="${sessionScope.allTypes}" />
						<c:forEach var="type" items="${bookTypeList}">
							<option id="typeId" value="${type.typeId}" required="required">${type.typeName}</option>
						</c:forEach>
					</select>
				</div>
				<div class="items">
					<img src="images/语言.svg"><span>文&nbsp;&nbsp;种</span>
					<!-- <input type="text" placeholder="文种" /> -->
					<select name="languageId" id="languageId">
						<c:set var="languageList" value="${sessionScope.allLanguages}" />
						<c:forEach var="language" items="${languageList}">
							<option id="languageId" value="${language.languageId}"
								required="required">${language.language}</option>
						</c:forEach>
					</select>
				</div>
				<div class="items">
					<img src="images/书架.svg"><span>书&nbsp;&nbsp;架</span> <select
						name="bookrackId" id="bookrackId">
						<c:set var="bookrackList" value="${sessionScope.allBookracks}" />
						<c:forEach var="bookrack" items="${bookrackList}">
							<option id="bookrackId" value="${bookrack.bookrackId}"
								required="required">${bookrack.bookrackName}</option>
						</c:forEach>
					</select>
				</div>
				<div class="items">
					<img src="images/库存.svg"><span>库&nbsp;&nbsp;存</span> <input
						type="text" name="inventory" value="${b.inventory }" required="required"/>
				</div>
<%-- 				<div class="items">
					<img src="images/借阅 (1).svg"><span>借&nbsp;&nbsp;阅</span> <input
						type="text" name="loan" value="${b.loan }" required="required" />
				</div> --%>
			</div>
			<input type="submit" class="btn modifysub" value="修改" />
			<!-- <button type="submit">添加</button> -->
		</form>
		</form>
	</div>
	<script type="text/javascript">       
        window.onload=function(){
			//完成修改下拉列表中的具体选中内容
			//1.找到下拉列表框
			var selectObj=document.getElementById("typeId");
			var publishIdObj=document.getElementById("publishId");
			var languageIdObj=document.getElementById("languageId");
			var bookrackIdObj=document.getElementById("bookrackId");
			
			//2.获取下拉列表框中的所有option选项
			//length返回下拉列表框中的选项个数
			var count=selectObj.length;
			var count1=publishIdObj.length;
			var count2=languageIdObj.length;
			var count3=bookrackIdObj.length;
			
			console.log(count3); 
			var typeId=${b.typeId};
			var publishId=${b.publishId};
			var languageId=${b.languageId};
			var bookrackId=${b.bookrackId};
			
			 console.log(typeId); 
			//3.判断哪一个option选项它的显示内容和我们选中的每一页显示的行数值相等
			for(var i=0;i<count;i++){
				if(selectObj.options[i].value==typeId){
					selectObj.options[i].selected=true;
					break;
				}
			}
			for(var i=0;i<count1;i++){
				if(publishIdObj.options[i].value==publishId){
					publishIdObj.options[i].selected=true;
					break;
				}
			}
			for(var i=0;i<count2;i++){
				if(languageIdObj.options[i].value==languageId){
					languageIdObj.options[i].selected=true;
					break;
				}
			}
			for(var i=0;i<count3;i++){
				if(bookrackIdObj.options[i].value==bookrackId){
					bookrackIdObj.options[i].selected=true;
					break;
				}
			}
		}
    </script>
</body>
</html>