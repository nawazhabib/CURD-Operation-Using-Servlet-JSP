<%-- 
    Document   : DepartmentForm
    Created on : Dec 12, 2023, 8:16:37 PM
    Author     : habib
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Department Data</title>
</head>
<body>

<!-- Including header-->
<%@ include file="/WEB-INF/includes/header.jsp" %>

<h2>Department Data</h2>

<table border="1">
    <thead>
    <tr>
        <th>Department ID</th>
        <th>Department Name</th>
        <th>Created Date</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="department" items="${departments}">
        <tr>
            <td>${department.deptId}</td>
            <td>${department.departmentName}</td>
            <td>${department.createdDate}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<!--Including footer-->
<%@ include file="/WEB-INF/includes/footer.jsp" %>

</body>
</html>

