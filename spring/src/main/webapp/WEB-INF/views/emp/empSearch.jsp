<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>list.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(function(){
	$(".btnSelect").on("click", function(){
		var empid = $(this).closest(".row").find("span").eq(0).html();
		var firstName = $(this).closest(".row").find("span").eq(1).html();
		opener.document.frm.manager_id.value = empid;
		opener.document.frm.mname.value = firstName;
// 		$(opener.document.find('name=manager_id').val(empid));
		window.close();
	});
});
</script>
</head>
<body>
<h3>사원 검색</h3>
<c:forEach items="${list }" var="emp"> 
	<div class="row">
		<span>${emp.employee_id }</span>
		<span>${emp.first_name }</span>
		<span>${emp.job_id }</span>
		<span><button type="button" class="btnSelect">선택</button></span>
	</div>
</c:forEach>
<button type="submit">확인</button>
<button type="reset">취소</button>
</body>
</html>