<!DOCTYPE html>
<html lang="en">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!-- 获取当前路径 -->
<c:set var="path" value="${pageContext.request.contextPath}" />
<%-- <c:out value="${path}"/> --%>
<!-- 组合基准路径 -->
<c:set var="basePath"
	value="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${path}/" />
<%-- <c:out value="${basePath}"/> --%>
<head>
<base href="${basePath}" />
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link href="css/index.css" type="text/css" rel="stylesheet" />
<link href="css/book.css" type="text/css" rel="stylesheet" />
</head>

<body>
	<header class="header">
		<div class="header-bg"></div>
		<div class="header-top">
			<div class="container">
				<!-- <img src="images/book_icon.svg"/> -->
				<img src="book/logo.png" />
				<div class="header-user">
					<a href="dologin.jsp" class="login">登录</a>
				</div>
			</div>
		</div>
		<div class="banner">
			<form action="#">
				<div class="search">
					<div class="select">
						<select>
							<option>书名</option>
							<option>索书号</option>
							<option>作者</option>
							<option>图书类别</option>
						</select>
					</div>
					<input type="text" class="search-text" placeholder="搜索你想要的图书">
					<input type="submit" value="查询" class="sub bookbtn" />
				</div>
			</form>
		</div>
	</header>
	<div class="main">
		<div class="main-inner">
			<div class="main-list">
				<div class="recommend-line">
					<span>大家正在关注</span>
				</div>
				<div class="main-list__wrapper clearfix">
					<a href="#" class="bookbtn"><img src="book/东野圭吾.jpg" alt="#"><span>东野圭吾</span></a>
					<a href="#" class="bookbtn"><img src="book/活着.jpg" alt="#"><span>活着</span></a>
					<a href="#" class="bookbtn"><img src="book/莫言.jpg" alt="#"><span>莫言</span></a>
					<a href="#" class="bookbtn"><img src="book/红楼梦.jpg" alt="#"><span>红楼梦</span></a>
					<a href="#" class="bookbtn"><img src="book/明朝那些事儿.jpg" alt="#"><span>明朝那些事儿</span></a>
					<a href="#" class="bookbtn"><img src="book/小王子.jpg" alt="#"><span>小王子</span></a>
					<a href="#" class="bookbtn"><img src="book/平凡的世界.jpg" alt="#"><span>平凡的世界</span></a>
				</div>
			</div>
		</div>
		<div class="main-waterfall">
			<div class="recommend-line">
				<span>为您推荐</span>
			</div>
		</div>
		<div class="main-card">
			<div class="container">
				<div class="imgBx">
					<img src="book/白夜行.png">
				</div>
				<div class="details">
					<div class="content">
						<h2>
							白夜行<br>
							<span>一个埋藏至今的绝望真相</span>
						</h2>
						<p>《恶意》的主人公因嫉妒生出无边的恶意，而《白夜行》里的唐泽雪穗，则是遇神杀神遇佛杀佛，
							凡是挡路的人全部都可以抹杀，即使赔上好友的一辈子幸福也无关紧要。她的整个人生就是在不停的夺取，
							不顾一切的向上爬，而亮司就是他最好的盟友。幼年不幸生活所催生的恶之花，已经造就出了更大的恶。</p>
						<p>
							整本书里，亮司和雪穗没有同过一次框，没有说过一句话。他总是在大家看不见的角落守护着他。那绣着rk的袋子和少男少女手拉手走在阳光下的剪纸都在昭示着爱情。
							只可惜，他们的生命里，已经再也没有阳光，只有永无止境的白夜。</p>
						<h3>东野圭吾</h3>
						<a href="#" class="bookbtn">
							<button>去看看</button>
						</a>
					</div>
				</div>
			</div>
		</div>
		<div class="getMore-line">
			<a href="#">加载更多</a>
		</div>
	</div>
	<div class="mask"></div>
	<div class="popdiv" style="left: 30%; top: 20%;">
		<div class="close">
			<img src="images/关  闭 (7)-01 copy.svg" />
		</div>
		<form action="">
			<div class="form">
				<div class="items">
					<img src="images/ISBN书号.svg" /><span>索书号</span> <input type="text"
						placeholder="001-1-001" />
				</div>
				<div class="items">
					<img src="images/书名.svg"><span>书&nbsp;&nbsp;名</span> <input
						type="text" placeholder="明朝那些事儿" />
				</div>
				<div class="items">
					<img src="images/作者.svg"><span>作&nbsp;&nbsp;者</span> <input
						type="text" placeholder="当年明月" />
				</div>
				<div class="items">
					<img src="images/出版社.svg"><span>出版社</span> <input type="text"
						placeholder="北京联合" />
				</div>
				<div class="items">
					<img src="images/分类-选中 (1).svg"><span>类&nbsp;&nbsp;别</span> <input
						type="text" placeholder="社会科学和自然科学" />
				</div>
				<div class="items">
					<img src="images/语言.svg"><span>文&nbsp;&nbsp;种</span> <input
						type="text" placeholder="中文" />
				</div>
				<div class="items">
					<img src="images/书架.svg"><span>书&nbsp;&nbsp;架</span> <input
						type="text" placeholder="1" />
				</div>
				<div class="items">
					<img src="images/库存.svg"><span>库&nbsp;&nbsp;存</span> <input
						type="text" placeholder="1" />
				</div>
			</div>
			<input type="submit" class="btn addsub" value="添加" />
			<!-- <button type="submit">添加</button> -->
		</form>
	</div>
	<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
	<script type="text/javascript" src="js/pop.js"> </script>
</body>

</html>