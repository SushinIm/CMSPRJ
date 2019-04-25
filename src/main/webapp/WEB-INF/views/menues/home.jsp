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
<script type="text/javascript" src="/resources/js/menues.js"></script>
</head>
<body>
	<h2>메뉴 리스트</h2>
	<form id="frm" action="/menu/addMenu.do">
		<input type="hidden" id="parents" name="parents" value=" " />
		<input type="hidden" id="menues" name="menues" value=" " />
		<input type="text" id="upper" name="upper" placeholder="상위메뉴명" readonly/>
		<input type="text" id="menu_nm" name="menu_nm" placeholder="메뉴명"/>&nbsp;
		<input type="button" onclick="addMenu()" value="메뉴등록" />&nbsp;
		<input type="button" onclick="delMenu()" value="메뉴삭제" />&nbsp;
		<input type="button" onclick="javascript:location.href='/main.do'" value="메인으로" />
	</form>
	<table style="border:1px solid #ccc">
    <colgroup>
        <col width="10%"/>
        <col width="10%"/>
        <col width="20%"/>
        <col width="20%"/>
    </colgroup>
    <thead>
        <tr>
            <th scope="col">등록</th>
            <th scope="col">삭제</th>
            <th scope="col">상위메뉴</th>
            <th scope="col">하위메뉴</th>
        </tr>
    </thead>
    <tbody>
        <c:choose>
            <c:when test="${fn:length(list) > 0}">
            	<c:forEach items="${list[0] }" var="row">
            		<tr>
                    	<td><input type="radio" value="${row.MENU_NO }" onclick="addChoice('${row.MENU_NM}')" name="ams"/></td>
                    	<td><input type="checkbox" value="${row.MENU_NO }" name="dms"/></td>
                        <td>${row.MENU_NM }</td>
                        <td></td>
					</tr>
					<c:forEach items="${list[1] }" var="cel">
						<c:if test="${row.MENU_NO eq cel.PARENTS }">
							<tr>
		                    	<td><input type="radio" value="${cel.MENU_NO }" onclick="addChoice('${cel.MENU_NM}')" name="ams"/></td>
		                    	<td><input type="checkbox" value="${cel.MENU_NO }" name="dms"/></td>
		                        <td></td>
                        		<td>${cel.MENU_NM }</td>
							</tr>
						</c:if>
					</c:forEach>
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
</html>