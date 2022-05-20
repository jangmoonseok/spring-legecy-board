<%@page import="com.basic.board.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%
	Cookie[] cookies = request.getCookies();
	String user = "";
	if(cookies != null){
		for(Cookie cookie : cookies){
			if(cookie.getName().equals("user")){
				user = cookie.getValue();
			}
		}
	}
%>
<html>
<head>
<title>글 등록</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<style type="text/css">
	.navbar{
		padding: 10px 30px;
	}
	#loginUser{
		color: white;
		margin-right: 20px;
		width: 150px;
	}
	.header{
		display: flex;
	}
	button{
		margin: 0 5px;
	}
</style>
<script type="text/javascript">
function boardRegist(){
	$.ajax({
		url : "<%= request.getContextPath()%>/boardRegist",
		type:"post",
		data:{
			"board_title":$('#title').val(),
			"board_content":$('#content').val(),
			"board_writer":"<%= user%>"
		},
		success:function(res){
			if(res > 0){
				alert("등록 성공")
				location.href = "<%= request.getContextPath()%>/"
			}else{
				alert("등록 실패")
				history.back()
			}
			
			
		},
		error:function(xhr){
			alert("상태 : " + xhr.status)
		}
	})

}
</script>
</head>
<body>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Spring Board</a>
  </div>
  <%
  	if(user.equals("")){
  %>
   <button class="btn btn-primary" type="button" id="loginBtn" onclick="location.href = '<%= request.getContextPath()%>/login'">Login</button>
  <%		
  	}else{
  %>
   <button class="btn btn-primary" type="button" id="logoutBtn" onclick="location.href = '<%= request.getContextPath()%>/logout'">Logout</button>
  <%		
  	}
  %>
</nav>
<div class="container mt-3">
	<div class="header">
	  <h2>글 등록</h2>
	  <button class="btn btn-primary" type="button" onclick="location.href = '<%= request.getContextPath()%>'">목록으로</button>
	  <button class="btn btn-primary" type="button" onclick="boardRegist()">등록</button>

	</div>
	<hr>
	  <table class="table table-striped">
	      <tr>
	        <th>제목</th>
	        <td>
	        	<input type="text" class="form-control" id="title" name="title">
	        </td>
	      </tr>
	      <tr>
	        <th>내용</th>
	        <td>
	        	<textarea class="form-control" rows="5" id="content" name="content" ></textarea>
	        </td>
	      </tr>
	      <tr>
	        <th>작성자</th>
	        <td><%= user %></td>
	      </tr>

	  </table>
</div>
</body>
</html>
