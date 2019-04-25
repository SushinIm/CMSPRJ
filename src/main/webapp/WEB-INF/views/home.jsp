<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
	<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>
	<form id="frm" name="frm" method="post">
		<input type="hidden" name="menu_no" value="" />
		<input type="hidden" name="user_no" value="${user_no }" />
		<input type="hidden" name="user_id" value="${user_id }" />
		<input type="hidden" name="right_no" value="${right_no}" />
	</form>
	<c:choose>
		<c:when test="${loginYN eq 'N' }">
			<form id="loginFrm" name="loginFrm" method="post" action="/login.do">
				<input type="text" placeholder="아이디" name="user_id"/><br/>
				<input type="password" placeholder="비밀번호" name="password"/><br/>
				<input type="submit" value="로그인" />&nbsp;
				<input type="button" onclick="javascript:location.href='/member/pagingReg.do'" value="회원가입"/>
			</form>
		</c:when>
		
		<c:when test="${loginYN eq 'Y' }">
			<h2>환영합니다. ${user_id }님</h2>
			<input type="button" onclick="" value="정보수정"/>&nbsp;
			<input type="button" onclick="logout()" value="로그아웃"/>&nbsp;
			<c:if test="${right_no eq 0 }">
				<input type="button" onclick="paging(0)" value="회원조회"/>&nbsp;
				<input type="button" onclick="paging(1)" value="메뉴조회"/>&nbsp;
				<input type="button" onclick="paging(2)" value="권한설정"/>
			</c:if>
			<ul>
				<c:forEach items="${list[0] }" var="row">
					<li>
						<a href="#" onclick="pagingMenu('${row.MENU_NO}', 0)">${row.MENU_NM }</a>
						<ul>
							<c:forEach items="${list[1] }" var="cel">
								<c:if test="${row.MENU_NO eq cel.PARENTS }">
									<li>
										<a href="#" onclick="pagingMenu('${cel.MENU_NO}', 1)">${cel.MENU_NM }</a>
									</li>
								</c:if>
							</c:forEach>
						</ul>
					</li>
				</c:forEach>
       		</ul>
		</c:when>
	</c:choose>
</body>
<script type="text/javascript" src="/resources/js/common.js"></script>
</html>
