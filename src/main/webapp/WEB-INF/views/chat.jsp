<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="error.jsp" %>
<jsp:include page="template/head.jsp"/>
<body>
<h1>Chat</h1>
<form>
    <textarea id="output"></textarea>
    <input type="text" id="input"/>
    <input type="button" onclick="send()" name="Send" value="Send"/>
</form>
</body>
</html>
