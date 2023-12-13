<%-- 
    Document   : Employee
    Created on : Dec 12, 2023, 7:52:52 PM
    Author     : habib
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Form</title>
</head>
<body>

<!-- Including header-->
<%@ include file="/WEB-INF/includes/header.jsp" %>

<h2>Employee Form</h2>

<form method="post" action="${pageContext.request.contextPath}/employee">
    <input type="hidden" name="action" value="${empty employee ? 'create' : 'update'}"/>
    <input type="hidden" name="employeeId" value="${not empty employee ? employee.id : ''}"/>

    <label for="name">Name:</label>
    <input type="text" id="name" name="name" required
           value="${not empty employee ? employee.name : ''}"/>

    <br/>

    <label for="deptId">Department ID:</label>
    <input type="number" id="deptId" name="deptId" required
           value="${not empty employee ? employee.deptId : ''}"/>

    <br/>

    <label for="designation">Designation:</label>
    <input type="text" id="designation" name="designation" required
           value="${not empty employee ? employee.designation : ''}"/>

    <br/>

    <label for="salary">Salary:</label>
    <input type="number" id="salary" name="salary" step="0.01" required
           value="${not empty employee ? employee.salary : ''}"/>

    <br/>

    <label for="birthDate">Birth Date:</label>
    <input type="date" id="birthDate" name="birthDate" required
           value="${not empty employee ? employee.birthDate : ''}"/>

    <br/>

    <label for="status">Status:</label>
    <input type="text" id="status" name="status" required
           value="${not empty employee ? employee.status : ''}"/>

    <br/>

    <button type="submit">Submit</button>
</form>

<!--Including footer-->
<%@ include file="/WEB-INF/includes/footer.jsp" %>

</body>
</html>
