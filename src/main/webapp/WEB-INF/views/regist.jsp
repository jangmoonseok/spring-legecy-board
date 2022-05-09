<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>regist</title>
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
	$('#regist').click(function(){
		$.ajax({
			url:"<%= request.getContextPath()%>/regist",
			type:"post",
			data:{
				id:$('#id').val(),
				pwd:$('#pwd').val(),
				name:$('#name').val(),
				email:$('#email').val()
			},
			success:function(res){
				if(res == "false"){
					alert("회원가입 실패")
					location.reload()
				}else{
					alert("회원가입 성공")
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
	  <div class="mb-2">
	    <label for="name" class="form-label">Name:</label>
	    <input type="text" class="form-control" id="name" placeholder="Enter name" name="name">
	  </div>
	  <div class="mb-2">
	    <label for="eamil" class="form-label">Email:</label>
	    <input type="text" class="form-control" id="email" placeholder="Enter email" name="email">
	  </div>

	  <button type="button" class="btn btn-danger" id="regist">회원가입</button>
	</form>
</div>
</body>
</html>