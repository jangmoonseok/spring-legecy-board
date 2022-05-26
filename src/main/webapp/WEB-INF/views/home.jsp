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
<c:set var="pageMaker" value="${dataMap.pageMaker }"/>
<c:set var="cri" value="${pageMaker.cri }"/>
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
	#header{
		display:flex;
		justify-content: space-between;
		width: 100%;
	}
	#input-groups{
		display: flex;
	}
	#keyword{
		width: 250px;
	}
	.pagination-container{
		display: flex;
		justify-content: center;
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
	<div id="header">	
	  	<h2>게시글 목록</h2>
	  	<div id="input-groups">
	  		<select class="form-select" id="perPageNum" name="perPageNum" onchange="list_go(1)" style="width: 150px;">
	  			<option value="10" ${cri.perPageNum eq 10 ? "selected" : "" }>정렬개수</option>
	  			<option value="2" ${cri.perPageNum eq 2 ? "selected" : "" }>2개</option>
	  			<option value="3" ${cri.perPageNum eq 3 ? "selected" : "" }>3개</option>
	  			<option value="5" ${cri.perPageNum eq 5 ? "selected" : "" }>5개</option>
	  		</select>
	  		<select class="form-select" id="searchType" name="searchType" style="width: 150px;">
	  			<option value=""  >검색구분</option>
				<option value="t" ${param.searchType eq  't' ? 'selected' : ''}>제목</option>
				<option value="w" ${param.searchType eq  'w' ? 'selected' : ''}>작성자</option>
				<option value="c" ${param.searchType eq  'c' ? 'selected' : ''}>내용</option>
	  		</select>
	  		<input  class="form-control" type="text" name="keyword" id="keyword" 
				placeholder="검색어를 입력하세요." value="${param.keyword }"/>
			<button type="button" class="btn btn-outline-primary" onclick="list_go(1)">검색</button>
	  	</div>
	</div>
	<c:set var="boardList" value="${dataMap.boardList }"/>
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
		<c:if test="${!empty boardList }">
	    <tbody>
			<c:forEach items="${boardList }" var="board">
		      <tr onclick="location.href='detail?bno=${board.board_no}'" style="cursor:pointer;">
		      	<td>${board.board_no }</td>
		      	<td>${board.board_title }</td>
		      	<td>${board.board_writer }</td>
		      	<td>${board.board_view }</td>
		      	<td>${board.board_regdate }</td>
		      </tr>
	      	</c:forEach>
	    </tbody>
		</c:if>
  </table>
		<c:if test="${empty boardList }">		
			<hr>
		  	<p>게시글이 존재하지 않습니다.</p>           
		</c:if>
	<div class="pagination-container">	
		<ul class="pagination">
		  <li class="page-item"><a class="page-link" href="#">Previous</a></li>
		  <c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="page">		  
		  	<li class="page-item ${page eq cri.page ? 'active' : '' }">
			  	<a class="page-link" href="javascript:list_go(${page })">${page }</a>
	  		</li>
		  </c:forEach>
		  <li class="page-item"><a class="page-link" href="#">Next</a></li>
		</ul>
	</div>
</div>

<script>
	function list_go(page,url){
		if(!url) url = "list";
		
		perPageNum = document.querySelector('#perPageNum').value;
		keyword = document.querySelector('#keyword').value;
		searchType = document.querySelector('#searchType').value;
		
		location.href = "<%= request.getContextPath()%>/" + url + "?page=" + page + "&perPageNum=" + perPageNum
					+ "&searchType=" + searchType + "&keyword=" + keyword;
	}
</script>
</body>
</html>
