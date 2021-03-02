<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>dept/deptList.jsp</title>
</head>
<body>
<h3>부서 목록</h3>
<c:forEach items="${deptList }" var="dept">
	${dept.department_id } ${dept.department_name } <br>
</c:forEach>
</body>
</html>