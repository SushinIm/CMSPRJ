<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 설정 페이지</title>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>
	<form id="frm" action="/member/regist.do" method="post">
		<h2>회원가입 페이지<input type="button" onclick="javascript:location.href='/main.do'" value="메인화면" /></h2>
		<input type="text" id="userId" name="userId" value="" /><br/>
		<input type="password" id="userPw" name="userPw" value="" /><br/>
		<input type="password" id="userPwChk" name="userPwChk" value="" /><br/>
		<input type="text" id="userNM" name="userNM" value="" /><br/>
		<input type="submit" value="회원가입" />
	</form>
</body>
</html>