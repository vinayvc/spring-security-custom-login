<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    <%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>ADMIN.. at last</h1>

<div>
		<div>
		<c:url value="/logout" var="logoutUrl"/>
			<form action="${logoutUrl}" method="post">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				<button type="submit">Logout</button>
			</form>
			<p>
				Hello
				<sec:authentication property="name" />
				!
			</p>
		</div>
	</div>
</body>
</html>