<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<Link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">
</head>
<body>
	<div id="container">
		<div id="header">
			<h1>${bloglist.title }</h1>
			<ul>
				<li><a href="${pageContext.request.contextPath }/${bloglist.id }">메인으로 가기</a></li>
				<li><a href="${pageContext.request.contextPath }/user/login">로그인</a></li>
				<li><a href="${pageContext.request.contextPath }/user/logout">로그아웃</a></li>
				<li><a href="${pageContext.request.contextPath }/${bloglist.id }/admin/basic">블로그 관리</a></li>
			</ul>
		</div>
		<div id="wrapper">
			<div id="content">
				<div class="blog-content">
					<h4>${getpost.title }</h4>
					<p>${getpost.contents }
					<p>
				</div>
				<c:forEach items="${postlist }" var="postlist" varStatus='status'>
					<ul class="blog-list">
						<li><a href="${pageContext.request.contextPath }/${bloglist.id }/${cartegoryNo }/${postlist.no }">${postlist.title }</a>
							<span>${postlist.regdate }</span></li>
					</ul>
				</c:forEach>
			</div>
		</div>

		<div id="extra">
			<div class="blog-logo">
				<img src="${pageContext.request.contextPath}/${bloglist.logo }">
			</div>
		</div>

		<div id="navigation">
			<h2>카테고리</h2>
			<ul>
				<c:set var='listCount' value='${fn:length(cartegorylist)}' />
				<c:forEach items="${cartegorylist }" var="cartegorylist" varStatus='status'>
					<li><a href="${pageContext.request.contextPath }/${bloglist.id }/${cartegorylist.no }">${cartegorylist.name }</a></li>
				</c:forEach>
			</ul>
		</div>
		
		<c:import url="/WEB-INF/views/blog/includes/footer.jsp" />
	</div>
</body>
</html>