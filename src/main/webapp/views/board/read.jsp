<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<body>
	<div id="wrap">
		<h1>상세 게시글</h1>
		<form action="${contextPath}/editCtrl" method="post">
			<input type="hidden" name="seq" value="${dto.seq}">
			<fieldset>
				<legend>글내용</legend>
				
				<table>
	                <tbody>
	                     <tr>
	                         <th scope="row"><label for="title">제목</label></th>
	                         <td>
	                             <input type="text" id="title" name="title" value="${dto.title}" />
	                         </td>
	                     </tr>
	                     <tr>
	                         <th scope="row"><label for="nickname">닉네임</label></th>
	                         <td><input type="text" id="nickname" name="nickname" value="${dto.nickname}" readonly /></td>
	                     </tr>
	                     <tr>
	                         <th scope="row"><label for="content">내용</label></th>
	                         <td>
	                             <textarea name="content" cols="40" rows="10">${dto.content}</textarea>
	                         </td>
	                     </tr>	       
	                     <tr>
	                         <th scope="row">등록일</th>
	                         <td>${dto.regdate}</td>
	                     </tr>	  	                                   
	                     <tr>
	                         <th scope="row">조회수</th>
	                         <td>${dto.cnt}</td>
	                     </tr>	  	                                   
	                </tbody>  
				</table>
			</fieldset>
			<p><button>수정하기</button></p>
		</form>
		<p>
			<a href="./write.jsp">글등록</a> <br>
			<a href="${contextPath}/deleteCtrl?seq=${dto.seq}">글삭제</a> <br>
			<a href="${contextPath}/listCtrl">글목록</a> <br>
		</p>
	</div>
</body>
</html>













