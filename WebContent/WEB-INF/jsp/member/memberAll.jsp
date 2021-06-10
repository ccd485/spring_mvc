<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
		/*request.setCharacterEncoding("EUC-KR");
		String mode = request.getParameter("mode");
		if (mode==null){
			mode = "all";
		}*/
%>
<c:if test="${empty param.mode}"><c:set var="mode" value="all"/></c:if>
<c:if test="${not empty param.mode}"><c:set var="mode" value="${param.mode}"/></c:if>

<!-- memberAll.jsp -->
<html>
<head>
	<title>회원목록</title>
	<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<div align="center">
	<hr color="green" width="300">
<c:if test="${empty param.mode}">
	<h2>회 원 목 록 보 기</h2>
</c:if>	
<c:if test="${not empty param.mode}">
	<h2>회 원 찾 아 보 기</h2>
	<form name="f" action="member_list.do" method="post">
		<input type="hidden" name="mode" value="${param.mode}"/>
		<select name="search">
			<option value="id">아이디</option>
			<option value="name">회원명</option>
		</select>
		<input type="text" name="searchString">
		<input type="submit" value="찾기">
	</form>
</c:if>	
	<hr color="green" width="300">
	<table width="800" class="outline">
		<tr>
			<th class="m3">번호</th>
			<th class="m3">이름</th>
			<th class="m3">아이디</th>
			<th class="m3">이메일</th>
			<th class="m3">전화번호</th>
			<th class="m3">가입일</th>
			<th class="m3">수정 | 삭제</th>
		</tr>
	<c:if test="${empty listMember}">
		<tr>   
			<td colspan="7">등록된 회원이 없습니다.</td>
		</tr>
	</c:if>
	<c:forEach var="dto" items="${listMember}">
		<tr>
			<td>${dto.no}</td>
			<td>${dto.name}</td>
			<td>${dto.id}</td>
			<td>${dto.email}</td>
			<td>${dto.allHp}</td>
			<td>${dto.joindate}</td>
			<td>
			<a href="member_update.do?no=${dto.no}">수정</a> | 
			<a href="member_delete.do?no=${dto.no}">삭제</a></td>
		</tr>	
	</c:forEach>
	</table>
</div>
</body>
</html>












