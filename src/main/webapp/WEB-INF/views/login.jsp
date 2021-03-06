<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<style type="text/css">
	#container{
		width:50%;
		height: 100vh;
		padding: 100px 0;
		margin: 0 auto;
	}

</style>
<script type="text/javascript">
$(function(){
	$('#login').click(function(){
		$.ajax({
			url:"<%= request.getContextPath()%>/login",
			type:"post",
			data:{
				id:$('#id').val(),
				pwd:$('#pwd').val()
			},
			success:function(res){
				console.log(res);
				if(res == ""){
					alert("아이디 또는 비밀번호를 잘 못 입력했습니다.")
				}else{
					location.href = '<%= request.getContextPath()%>/'
				}
			},
			error:function(xhr){
				alert("상태 : " + xhr.status)
			}
		})
	})
})
</script>
</head>
<body>
<div id="container">
	<form>
	  <div class="mb-2 mt-3">
	    <label for="id" class="form-label">Id:</label>
	    <input type="text" class="form-control" id="id" placeholder="Enter id" name="id">
	  </div>
	  <div class="mb-2">
	    <label for="pwd" class="form-label">Password:</label>
	    <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd">
	  </div>
	  <div class="form-check mb-2">
	    <label class="form-check-label">
	      <input class="form-check-input" type="checkbox" name="remember"> Remember me
	    </label>
	  </div>
	  <button type="button" class="btn btn-primary" id="login">로그인</button>
	  <button type="button" class="btn btn-danger" onclick="location.href='<%= request.getContextPath()%>/regist'">회원가입</button>
	</form>
</div>
</body>
</html>