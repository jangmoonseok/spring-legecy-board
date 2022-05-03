<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<style type="text/css">
		.navbar{
			padding: 10px 30px;
		}
	</style>
	<script type="text/javascript">
	window.onload = function(){		
		loginBtn = document.querySelector('#loginBtn')
		loginBtn.addEventListener('click', function(){
			location.href = "<%= request.getContextPath()%>/login"
		})
	}
	</script>
</head>
<body>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Spring Board</a>
  </div>
   <button class="btn btn-primary" type="button" id="loginBtn">Login</button>
</nav>
</body>
</html>
