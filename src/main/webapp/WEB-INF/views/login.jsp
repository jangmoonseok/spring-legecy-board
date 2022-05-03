<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>login</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<style type="text/css">
	#container{
		height: 100vh;
		display: flex;
		justify-content: center;
		padding: 100px 0;
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
	  <button type="button" class="btn btn-primary" id="login">Login</button>
	</form>
</div>
</body>
</html>