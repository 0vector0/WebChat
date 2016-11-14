<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="error.jsp" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<jsp:include page="template/head.jsp"/>
<body>
<br>
<%--<a href="${s:mvcUrl('RC#getRegister')}">Registration</a>--%>
<a href="${pageContext.request.contextPath}/registration">Registration</a>
<a href="${pageContext.request.contextPath}/login">Login</a>
<br>

<button type="button" class="btn btn-default navbar-btn" data-toggle="modal" data-target="#myModal">Sign in</button>
<jsp:include page="template/login-modal.jsp"/>
</body>
</html>