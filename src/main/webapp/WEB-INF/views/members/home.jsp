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
	<form id="frm" action="/menu/delUser.do">
		<input type="hidden" id="users" name="users" value=" " />
	</form>
	<table style="border:1px solid #ccc">
    <colgroup>
        <col width="10%"/>
        <col width="20%"/>
        <col width="20%"/>
    </colgroup>
    <thead>
        <tr>
            <th scope="col">&nbsp;</th>
            <th scope="col">회원ID</th>
            <th scope="col">회원이름</th>
        </tr>
    </thead>
    <tbody>
        <c:choose>
            <c:when test="${fn:length(list) > 0}">
                <c:forEach items="${list }" var="row">
                    <tr>
                        <td><input type="checkbox" value="${row.USER_NO }" name="dus"/></td>
                        <td>${row.USER_ID }</td>
                        <td>${row.USER_NM }</td>
                    </tr>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <tr>
                    <td colspan="4">조회된 결과가 없습니다.</td>
                </tr>
            </c:otherwise>
        </c:choose>
    </tbody>
	</table>
	<input type="button" onclick="delUser()" value="회원삭제" />&nbsp;
	<input type="button" onclick="javascript:location.href='/main.do'" value="메인화면" />
</body>
</html>