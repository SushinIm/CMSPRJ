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
	<form name="mrFrm" method="get" id="mrFrm">
		<h3>선택한 권한명 : ${rightNO }</h3>
		<input type="button" onclick="grantMenu()" value="권한 부여"/>
		<input type="hidden" name="rightno" value="${rightNO }" />
		<input type="hidden" name="menuno" value="" />
	</form>
	<table style="border:1px solid #ccc">
    <colgroup>
        <col width="10%"/>
        <col width="30%"/>
        <col width="30%"/>
        <col width="30%"/>
    </colgroup>
    <thead>
        <tr>
            <th scope="col">&nbsp;</th>
            <th scope="col">글번호</th>
            <th scope="col">메뉴명</th>
            <th scope="col">메뉴레벨</th>
        </tr>
    </thead>
    <tbody>
        <c:choose>
            <c:when test="${fn:length(list) > 0}">
                <c:forEach items="${list }" var="row">
                    <tr>
                    	<td><input type="checkbox" value="${row.MENU_NO }" name="menues"/></td>
                        <td>${row.MENU_NO }</td>
                        <td>${row.MENU_NM }</td>
                        <td>${row.MENU_LV }</td>
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
<script type="text/javascript" src="/resources/js/rMenu.js"></script>
</html>