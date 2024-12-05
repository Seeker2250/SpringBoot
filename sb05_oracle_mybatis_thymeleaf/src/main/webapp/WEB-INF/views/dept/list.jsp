<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<head>
	<title>Home</title>
	<script   src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
	<link href="/resources/dipin/example.css" type="text/css" rel="stylesheet" />
	<script   src="/resources/dipin/example.js"></script>
</head>
<body>
	
<div>
	<h1 class= 'main'>jsp dept list</h1>
	<table border="1" style = "width:100%">
		<tr>
			<th>deptno</th>
			<th>dname</th>
			<th>loc</th>
		</tr>
		<c:forEach items="${list}" var="vo">
			<tr>
				<td>${vo.deptno}</td>
				<td>${vo.dname}</td>
				<td>${vo.loc}</td>
			</tr>
		</c:forEach>
	</table>
</div>



</body>
</html>
