<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<body>
	<div id="wrap">
		<h1>FrontController - 게시판</h1>
		
		<p><a href="./views/user/login.jsp">로그인</a></p>
		
		<p>
			<a href="${contextPath}/user/logout.do">로그아웃</a> <br>
			<a href="${contextPath}/board/list.do">글목록</a> <br>
			<a href="./views/board/write.jsp">글쓰기</a> <br>
		</p>
	</div>
</body>
</html>