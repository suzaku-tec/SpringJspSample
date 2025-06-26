<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>hello-jsp</title>
</head>
<body>
	hello! <c:forEach items="${memberList}" var="member"><c:out value="${member}"/>. </c:forEach>
</body>
</html>
