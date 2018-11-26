<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="login" method = "post" id="loginForm">
		<div class="form-group">
               <input type="text" class="form-control" name="username" placeholder="Username" required>
           </div>
           <div class="form-group">
               <input type="password" class="form-control" name="password" placeholder="Password">
           </div>
           <button type="submit" class="btn btn-primary block full-width m-b">Sign In</button>
	</form>
</body>
</html>