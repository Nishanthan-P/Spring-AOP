<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>home page</title>
</head>
<body>
	<h2>Demo Spring Security</h2>
	<hr>
	<p>
		Welcome to home page
	</p>
	<hr>
		<p>
			User:<security:authentication property="principal.username"/>
		</p>
		<p>
			Role(s): <security:authentication property="principal.authorities"/>
		</p>
	<hr>
	<form:form action="${pageContext.request.contextPath}/logout"
			method="POST" >
		<input type="submit" value="logout" />
	</form:form>	
</body>
</html>