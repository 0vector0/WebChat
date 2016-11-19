<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="error.jsp" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="template/head.jsp"/>
<body onload="sendlogin()">
<div class="site-wrapper">
    <div class="site-wrapper-inner">
        <div class="cover-container">
            <div class="masthead clearfix">
                <div class="inner">
                    <h3 class="masthead-brand">WeChat</h3>
                    <nav class="nav nav-masthead">
                        <a class="nav-link active" href="/">Home</a>
                        <a class="nav-link" href="${s:mvcUrl('getRegister').build()}">Register</a>
                        <a class="nav-link" href="#">Contact</a>
                    </nav>
                </div>
            </div>
            <div class="inner cover">
                <h1 class="cover-heading">Hi, ${login} <c:if test="${login==null}"> dear friend!</c:if></h1>
                <p class="lead">Welcome to our chat page.
                    To sit in a relaxed atmosphere and chat with your friends, what could be better?
                    Communication, new acquaintances, unexpected turns ... All this awaits you in our chat.</p>
                <p class="lead">
                    <a href="#" data-toggle="modal" data-target="#myModal" class="btn btn-lg btn-secondary">Sign-in</a>
                </p>
            </div>

            <div class="mastfoot">
                <div class="inner">
                    <p>Created by hard bloody work...</p>
                </div>
            </div>

        </div>

    </div>

</div>
<br>
<%--<a href="${s:mvcUrl('RC#getRegister')}">Registration</a>--%>
<jsp:include page="template/login-modal.jsp"/>
</body>
</html>