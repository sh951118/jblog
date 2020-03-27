<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- JSTL만의 메소드를 쓸 수있게 해줌  -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- 함수 처리를 쓸 수있게 해줌  -->
<Link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">
<h1 class="logo">JBlog</h1>
<ul class="menu">
	<c:choose>
		<c:when test="${empty authUser }">
			<li><a href="${pageContext.request.contextPath }/user/login">로그인</a></li>
			<li><a href="${pageContext.request.contextPath }/user/join">회원가입</a></li>
		</c:when>
		<c:otherwise>
			<li><a href="${pageContext.request.contextPath }/user/logout">로그아웃</a></li>
			<li><a href="${pageContext.request.contextPath }/${authUser.id }">내 블로그</a></li>
		</c:otherwise>
	</c:choose>
</ul>