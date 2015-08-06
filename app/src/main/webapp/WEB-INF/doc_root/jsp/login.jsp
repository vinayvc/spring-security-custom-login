<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>custom login page</h1>
	<c:if test="${param.error != null}">
		<div >
			Failed to login.
			<c:if test="${SPRING_SECURITY_LAST_EXCEPTION != null}">
Reason: <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.
message}" />
			</c:if>
		</div>
	</c:if>
	<c:if test="${param.logout != null}">
		<div >You have been logged out.</div>
	</c:if>
	<c:url var="loginUrl" value="/login"></c:url>
	<form name="loginForm" action="${loginUrl}" method="post">
		<table>
			<tr>
				<td>login Id</td>
				<td><input type="text" name="username" id="username" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" id="password" /></td>
			</tr>
			<tr>
				<td colspan=2><button type="submit">Login</button></td>

			</tr>
		</table>
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
</body>
</html>