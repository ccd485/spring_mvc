<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- search.jsp -->
<%
		/*String mode = request.getParameter("mode");
		
		String title = null;
		if (mode.equals("id")){
			title = "���̵�";
		}else {
			title = "��й�ȣ";
		}*/
%>
<c:set var="title"/>
<c:if test="${param.mode eq 'id'}"><c:set var="title" value="���̵�"/></c:if>
<c:if test="${param.mode ne 'id'}"><c:set var="title" value="��й�ȣ"/></c:if>

<html>
<head>	
	<title>${title}ã��</title>
	<link rel="stylesheet" type="text/css" href="style.css"> 
	<script type="text/javascript">
		function check(mode){
			if (f.name.value==""){
				alert("�̸��� �Է��� �ּ���!!")
				f.name.focus()
				return false
			}
			if (f.ssn1.value==""){
				alert("�ֹι�ȣ���ڸ��� �Է��� �ּ���!!")
				f.ssn1.focus()
				return false
			}
			if (f.ssn2.value==""){
				alert("�ֹι�ȣ���ڸ��� �Է��� �ּ���!!")
				f.ssn2.focus()
				return false
			}
			if (mode=="pw" && f.id.value==""){
				alert("���̵� �Է��� �ּ���!!")
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
		<h2>${title} ã ��</h2>
		<hr color="green" width="300">
		<form name="f" action="check.log" method="post"
									onsubmit="return check('${param.mode}')">
			<table width="500" class="outline">
				<tr>
					<th width="20%">ȸ����</th>
					<td><input type="text" name="name" class="box"></td>
				</tr>
				<tr>
					<th width="20%">�ֹι�ȣ</th>
					<td><input type="text" name="ssn1" class="box" maxlength="6">
					- <input type="password" name="ssn2" class="box" maxlength="7"></td>
				</tr>
<%			//if (mode.equals("pw")){ %>
			<c:if test="${param.mode eq 'pw'}">
				<tr>
					<th width="20%">���̵�</th>
					<td><input type="text" name="id" class="box"></td>
				</tr>
<%			//} %>
			</c:if>				
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="ã��">
						<input type="reset" value="���">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>