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
<title>Home</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<style type="text/css">
	.navbar{
		padding: 10px 30px;
	}
	#loginUser{
		color: white;
		margin-right: 20px;
		width: 150px;
	}
</style>
<script type="text/javascript">

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
   <button class="btn btn-primary" type="button" id="logoutBtn" onclick="location.href = '<%= request.getContextPath()%>/logout'" style="margin-right:20px;">Logout</button>
   <button class="btn btn-primary" type="button" id="registBtn" onclick="location.href = 'boardRegist'" style="width:100px;">글 등록</button>
  <%		
  	}
  %>
</nav>
<div class="container mt-3">
  <h2>게시글 목록</h2>
	<%
		List<BoardVO> boardList = (List<BoardVO>)request.getAttribute("boardList");
		if(boardList == null){
	%>
		<hr>
	  	<p>게시글이 존재하지 않습니다.</p>           
	<%	
		}else{
	%>
	  <table class="table table-striped">
	    <thead>
	      <tr>
	        <th>게시글 번호</th>
	        <th>제목</th>
	        <th>작성자</th>
	        <th>조회수</th>
	        <th>작성날짜</th>
	      </tr>
	    </thead>
	    <tbody>
	      <%
	      	for(BoardVO vo : boardList){
	      %>
	      <tr onclick="location.href='detail?bno=<%= vo.getBoard_no()%>'" style="cursor:pointer;">
	      	<td><%= vo.getBoard_no()%></td>
	      	<td><%= vo.getBoard_title()%></td>
	      	<td><%= vo.getBoard_writer()%></td>
	      	<td><%= vo.getBoard_view()%></td>
	      	<td><%= vo.getBoard_regdate()%></td>
	      </tr>
	      <%		
	      	}
	      %>
	    </tbody>
	  </table>
	<%
		}
	%>
</div>
</body>
</html>
