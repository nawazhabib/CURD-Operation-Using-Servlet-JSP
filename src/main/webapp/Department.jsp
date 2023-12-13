<%-- 
    Document   : Department
    Created on : Dec 12, 2023, 7:06:21 PM
    Author     : habib
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Department Form</title>
</head>
<body>

<!-- Including header-->
<%@ include file="/WEB-INF/includes/header.jsp" %>

<h2>Department Form</h2>

<form method="post" action="${pageContext.request.contextPath}/department">
    <input type="hidden" name="action" value="${empty department ? 'create' : 'update'}"/>
    <input type="hidden" name="deptId" value="${not empty department ? department.deptId : ''}"/>

    <label for="departmentName">Department Name:</label>
    <input type="text" id="departmentName" name="departmentName" required
           value="${not empty department ? department.departmentName : ''}"/>

    <br/>

    <button type="submit">Submit</button>
</form>

<!--Including footer-->
<%@ include file="/WEB-INF/includes/footer.jsp" %>

</body>
</html>
