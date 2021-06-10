<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- memberSsn.jsp -->
<html>
<head>	
	<title>회원가입유무</title>
	<link rel="stylesheet" type="text/css" href="style.css"> 
</head>
<script type="text/javascript">
			function check(){
				if (f.name.value==""){
					alert("이름을 입력해 주세요!!")
					f.name.focus()
					return
				}
				if (f.ssn1.value==""){
					alert("주민번호를 입력해 주세요!!")
					f.ssn1.focus()
					return
				}
				if (f.ssn2.value==""){
					alert("주민번호를 입력해 주세요!!")
					f.ssn2.focus()
					return
				}
				document.f.submit()
			}
		</script> 
<body>
	<div align="center">
		<hr color="green" width="300">
		<h2>회 원 가 입 유 무</h2>
		<hr color="green" width="300">
		<form name="f" action="member_check.do" method="post">
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
				<tr>
					<td colspan="2" align="center">
						<a href="javascript:check()">[전송]</a>
						<a href="#">[취소]</a>
					</td>
  				</tr>
			</table>
		</form>
	</div>
</body>
</html>