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
	<form name="rightFrm" method="get">
		<input type="radio" name="selector" value="1" />메뉴 권한 부여
		&nbsp;
		<input type="radio" name="selector" value="2" />멤버 권한 부여
		<input type="hidden" name="right_no" value="" />
	</form>
	<table style="border:1px solid #ccc">
    <colgroup>
        <col width="10%"/>
        <col width="*"/>
        <col width="15%"/>
    </colgroup>
    <thead>
        <tr>
            <th scope="col">글번호</th>
            <th scope="col">권한명</th>
        </tr>
    </thead>
    <tbody>
        <c:choose>
            <c:when test="${fn:length(list) > 0}">
                <c:forEach items="${list }" var="row">
                    <tr>
                        <td>${row.RIGHT_NO }</td>
                        <td><a onclick="granting('${row.RIGHT_NO}')" href="#">${row.RIGHT_NM }</a></td>
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
</body>
<script type="text/javascript" src="/resources/js/rights.js"></script>
</html>