<%-- 
    Document   : PrintPreview
    Created on : Dec 12, 2023, 8:17:50 PM
    Author     : habib
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Print Preview</title>
    <style>
        /* Add your print styles here */
        @media print {
            /* Define styles for print preview */
            body {
                font-family: Arial, sans-serif;
            }

            table {
                border-collapse: collapse;
                width: 100%;
            }

            th, td {
                border: 1px solid #dddddd;
                text-align: left;
                padding: 8px;
            }

            th {
                background-color: #f2f2f2;
            }
        }
    </style>
</head>
<body>

<!-- Including header-->
<%@ include file="/WEB-INF/includes/header.jsp" %>

<h2>Print Preview</h2>

<!--Add content to be previewed--> 
<p>This is a sample content for print preview.</p>

<!--Including footer-->
<%@ include file="/WEB-INF/includes/footer.jsp" %>

</body>
</html>

