<%-- 
    Document   : EmployeeForm
    Created on : Dec 12, 2023, 8:17:24 PM
    Author     : habib
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Data</title>
</head>
<body>

<!-- Including header-->
<%@ include file="/WEB-INF/includes/header.jsp" %>

<h2>Employee Data</h2>

<table border="1">
    <thead>
    <tr>
        <th>Employee ID</th>
        <th>Name</th>
        <th>Department ID</th>
        <th>Designation</th>
        <th>Salary</th>
        <th>Birth Date</th>
        <th>Status</th>
        <th>Created Date</th>
        <th>Updated Date</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="employee" items="${employees}">
        <tr>
            <td>${employee.id}</td>
            <td>${employee.name}</td>
            <td>${employee.deptId}</td>
            <td>${employee.designation}</td>
            <td>${employee.salary}</td>
            <td>${employee.birthDate}</td>
            <td>${employee.status}</td>
            <td>${employee.createdDate}</td>
            <td>${employee.updatedDate}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<!--Including footer-->
<%@ include file="/WEB-INF/includes/footer.jsp" %>

</body>
</html>

