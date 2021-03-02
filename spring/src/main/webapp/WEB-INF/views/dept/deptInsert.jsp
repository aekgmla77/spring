<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3 id="top">부서 등록</h3>
<c:set var="url" value="./empInsert" />
<c:if test="${not empty empVO.employee_id}">
<c:set var="url" value="./empUpdate" />
</c:if>

<form action="${url }" method="post" name="frm">
	department_id <input type="number" name="department_id" value="${deptVO.employee_id }" <c:if test="${not empty empVO.employee_id}"> readonly="readonly"</c:if> ><br>
	department_name  <input name="first_name" value="${empVO.first_name }"><br>
	manager_id   <input name="last_name" value="${empVO.last_name }"><br>
	location_id       <input type="text" name="email" value="${empVO.email }">
				<button type="button" id="btnEmail">중복 체크</button>
				<span id="emailResult"></span><br>
	phone_number<input type="text" name="phone_number" value="${empVO.phone_number }"><br>
	hire_date   <input type="date" name="hire_date" value="${empVO.hire_date }"><br>
	job_id  
	<select name="job_id">     
	<c:forEach items="${jobList }" var = "job">
		<option value="${job.job_id }" <c:if test="${job.job_id == empVO.job_id}">selected="selected" </c:if>>${job.job_title }
	</c:forEach></select><br>
	department_id 
	<c:forEach items="${deptList }" var = "dept">
		<input type="radio" name="${dept.department_id }" value="${dept.department_id }" 
		<c:if test="${dept.department_id == empVO.department_id}">checked="checked" </c:if>>${dept.department_name }
	</c:forEach><br>
	manager_id 
	<input type="text" name="manager_id" value="${empVO.manager_id }">
	<input type="text" name="mname" value="${empVO.first_name }">
	<button type="button" onclick="EmpSerch()">사원검색</button><br>	
	<button type="submit">등록</button>
	<button type="reset">초기화</button>
</form>

</body>
</html>