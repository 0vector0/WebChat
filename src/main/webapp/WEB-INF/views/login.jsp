<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="error.jsp" %>
<jsp:include page="template/head.jsp"/>
<body onload="sendlogin()">

<form>
    login: <input type="text" id="login"/>
    password: <input type="text" id="password"/>
    is admin <input type="checkbox" id="is-admin">
    <input type="button" onclick="send()" value="login">
</form>
</body>
</html>
