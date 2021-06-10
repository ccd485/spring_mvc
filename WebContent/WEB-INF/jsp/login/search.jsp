<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- search.jsp -->
<%
		/*String mode = request.getParameter("mode");
		
		String title = null;
		if (mode.equals("id")){
			title = "아이디";
		}else {
			title = "비밀번호";
		}*/
%>
<c:set var="title"/>
<c:if test="${param.mode eq 'id'}"><c:set var="title" value="아이디"/></c:if>
<c:if test="${param.mode ne 'id'}"><c:set var="title" value="비밀번호"/></c:if>

<html>
<head>	
	<title>${title}찾기</title>
	<link rel="stylesheet" type="text/css" href="style.css"> 
	<script type="text/javascript">
		function check(mode){
			if (f.name.value==""){
				alert("이름을 입력해 주세요!!")
				f.name.focus()
				return false
			}
			if (f.ssn1.value==""){
				alert("주민번호앞자리를 입력해 주세요!!")
				f.ssn1.focus()
				return false
			}
			if (f.ssn2.value==""){
				alert("주민번호뒷자리를 입력해 주세요!!")
				f.ssn2.focus()
				return false
			}
			if (mode=="pw" && f.id.value==""){
				alert("아이디를 입력해 주세요!!")
				f.id.focus()
				return false
			}
			return true
		}
	</script>
</head>
<body>
	<div align="center">
		<hr color="green" width="300">
		<h2>${title} 찾 기</h2>
		<hr color="green" width="300">
		<form name="f" action="check.log" method="post"
									onsubmit="return check('${param.mode}')">
			<table width="500" class="outline">
				<tr>
					<th width="20%">회원명</th>
					<td><input type="text" name="name" class="box"></td>
				</tr>
				<tr>
					<th width="20%">주민번호</th>
					<td><input type="text" name="ssn1" class="box" maxlength="6">
					- <input type="password" name="ssn2" class="box" maxlength="7"></td>
				</tr>
<%			//if (mode.equals("pw")){ %>
			<c:if test="${param.mode eq 'pw'}">
				<tr>
					<th width="20%">아이디</th>
					<td><input type="text" name="id" class="box"></td>
				</tr>
<%			//} %>
			</c:if>				
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="찾기">
						<input type="reset" value="취소">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>