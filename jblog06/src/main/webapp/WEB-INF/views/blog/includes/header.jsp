<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- JSTL만의 메소드를 쓸 수있게 해줌  -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div id="header">
	<h1>${blogVo.title }</h1>
	<ul>
		<li><a href="${pageContext.request.contextPath }/${blogVo.id }">메인으로 가기</a></li>
		<li><a href="${pageContext.request.contextPath }/user/login">로그인</a></li>
		<li><a href="${pageContext.request.contextPath }/user/logout">로그아웃</a></li>
		<li><a href="${pageContext.request.contextPath }/${blogVo.id }/admin/basic">블로그 관리</a></li>
	</ul>
</div>