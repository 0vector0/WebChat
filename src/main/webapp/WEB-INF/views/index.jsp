<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="error.jsp" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="../../css/bootstrap.css">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://code.jquery.com/jquery-3.1.1.js"></script>
    <script src="../../js/bootstrap.js"></script>

    <title>Start page</title>
</head>
<body>


<br>
<%--<a href="${s:mvcUrl('RC#getRegister')}">Registration</a>--%>
<a href="${pageContext.request.contextPath}/registration">Registration</a>
<a href="${pageContext.request.contextPath}/login">Login</a>
<br>
<button type="button" class="btn btn-default navbar-btn">Sign in</button>

</body>
</html>