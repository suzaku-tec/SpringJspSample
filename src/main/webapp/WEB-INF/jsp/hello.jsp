<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>hello-jsp</title>
</head>
<body>
	<form:form action="complete" method="post">
		hello! <c:forEach items="${memberList}" var="member"><c:out value="${member}"/>. </c:forEach>
		<input type="submit" value="完了">
	</form:form>
</body>
</html>
