<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<title>JBlog</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<Link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/jquery/jquery-3.4.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/ejs/ejs.js"></script>
<script>
var startNo = 0;
var isEnd = false;

var listTemplate = new EJS({
	url: "${pageContext.request.contextPath }/assets/js/ejs/list-template.ejs"
});

var listItemTemplate = new EJS({
	url: "${pageContext.request.contextPath }/assets/js/ejs/list-item-template.ejs"
});

var messageBox = function(title, message, callback){
	$("#dialog-message p").text(message);
	$("#dialog-message")
		.attr("title", title)
		.dialog({
			modal: true,
			buttons: {
				"확인": function() {
					$(this).dialog( "close" );
		        }
			},
			close: callback
		});
}

var render = function(vo, mode){
	$(".admin-cat")[mode ? "prepend" : "append"](html);
}


var fetchList = function(){
	if(isEnd){
		return;	
	}
	
	$.ajax({
		url: '${pageContext.request.contextPath }/${authUser.id}/cartegory/list',
		async: true,
		type: 'get',
		dataType: 'json',
		data: '',
		success: function(response){
			if(response.result != "success"){
				console.error(response.message);
				return;
			}
			
			// redering
// 			$.each(response.data, function(index, vo){
// 				render(vo);
// 			}); 
			response.contextPath = "${pageContext.request.contextPath }";

			var html = listTemplate.render(response);
			$(".admin-cat").append(html);
			
		},
		error: function(xhr, status, e){
			console.error(status + ":" + e);
		}
	});	
}

$(document).on('click','.admin-cat a', function(event){
	event.preventDefault();
	var deleteno = $(this).data('no');
	
	$(this).parents('tr').remove();
	$.ajax({
		url: '${pageContext.request.contextPath }/${authUser.id}/cartegory/delete/' + deleteno,
		async: true,
		type: 'delete',
		dataType: 'json',
		data: '',
		success: function(response){
			if(response.result != "success"){
				console.error(response.message);
				return;
			}
			
			for(var i = 1; i < $('.admin-cat tr').length; i++){
				$($('.admin-cat tr')[i]).children(0)[0].innerText = i;
			}
		},
		error: function(xhr, status, e){
			console.error(status + ":" + e);
		}
	});
	
});

$(function() {
	
	$('#add-form').submit(function(event) {
		event.preventDefault();
	
		var vo = {};
		vo.name = $("#name").val();
		if(vo.name == ''){
			messageBox("새로운 카테고리 추가", "카테고리명은 필수 항목 입니다.", function() {
				$("#name").focus();
			});
			return;
		}
		
		vo.description = $("#description").val();
		if(vo.description == ''){
			messageBox("새로운 카테고리 추가", "설명은 필수 항목 입니다.", function() {
				$("#description").focus();
			});
			return;
		}
		$.ajax({
			url: '${pageContext.request.contextPath }/${authUser.id }/cartegory/add',
			async: true,
			type: 'post',
			dataType: 'json',
			contentType: 'application/json',
			data: JSON.stringify(vo),
			success: function(response) {
				if(response.result != "success"){
					console.error(response.message);
					return;
				}
				response.data.contextPath = "${pageContext.request.contextPath }";
				console.log(response.data.contextPath);
				// rendering
// 				render(response.data, true);
				var lastNum = Number($('.admin-cat tr:last-child td')[0].innerText)+ 1;
				response.data.lastNum = lastNum;
				
				var html = listItemTemplate.render(response.data);
				$(".admin-cat tr").last().after(html);
				
				// form reset
				$("#add-form")[0].reset();
			},
			error: function(xhr, status, e){
				console.error(status + ":" + e);
			}
		});
	});
	// Live Event: 존재하지 않는 element의 이벤트 핸들러를 미리 세팅하는 것
	// delegation(위임, document)
	$(document).on('click', '.admin-cat td a', function(event){
		event.preventDefault();
		var no = $(this).data('no');
		
	});
	
	// 처음 리스트 가져오기
	fetchList();
});
</script>
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/blog/includes/header.jsp" />
		<div id="wrapper">
			<div id="content" class="full-screen">
				<ul class="admin-menu">
					<li><a href="${pageContext.request.contextPath }/${authUser.id }/admin/basic">기본설정</a></li>
					<li class="selected">카테고리</li>
					<li><a href="${pageContext.request.contextPath }/${authUser.id }/admin/post">글작성</a></li>
				</ul>
				<table class="admin-cat">
					<tr id="menu-title">
						<th>번호</th>
						<th>카테고리명</th>
						<th>포스트 수</th>
						<th>설명</th>
						<th>삭제</th>
					</tr>
				</table>
					
				<h4 class="n-c">새로운 카테고리 추가</h4>
				<form id="add-form" action="" method="post">
					<table id="admin-cat-add">
						<tr>
							<td class="t">카테고리명</td>
							<td><input type="text" name="name" id ="name"></td>
						</tr>
						<tr>
							<td class="c">설명</td>
							<td><input type="text" name="description" id ="description"></td>
						</tr>
						<tr>
							<td class="s">&nbsp;</td>
							<td><input type="submit" value="카테고리 추가" id="submit"></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		<c:import url="/WEB-INF/views/blog/includes/footer.jsp" />
	</div>
</body>
</html>