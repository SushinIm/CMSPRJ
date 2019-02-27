<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<c:choose>
		<c:when test="${loginYN eq 'N' }">
			<form id="loginFrm" name="loginFrm" method="post" action="/login.do">
				<input type="text" placeholder="아이디" name="user_id"/><br/>
				<input type="password" placeholder="비밀번호" name="password"/><br/>
				<input type="submit" value="로그인" />
			</form>
		</c:when>
		
		<c:when test="${loginYN eq 'Y' }">
			<h2>환영합니다. ${user_id }님</h2>
			<input type="button" onclick="logout()" value="로그아웃"/>
			<c:if test="${fn:length(list) > 0}">
                <c:forEach items="${list }" var="row">
                    <ul>
                        <li><a onclick="pagingMenu('${row.MENU_NO}')" href="#">${row.MENU_NM }</a></li>
                    </ul>
                </c:forEach>
	        </c:if>
		</c:when>
	</c:choose>
</body>
<script type="text/javascript" src="/resources/js/common.js"></script>
</html>
