<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="error.jsp" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="template/head.jsp"/>
<body>

<div class="site-wrapper">

    <div class="site-wrapper-inner">

        <div class="cover-container">

            <div class="masthead clearfix">
                <div class="inner">
                    <h3 class="masthead-brand">Cover</h3>
                    <nav class="nav nav-masthead">
                        <a class="nav-link active" href="/">Home</a>
                        <a class="nav-link" href="/registration">Register</a>
                        <a class="nav-link" href="#">Contact</a>
                    </nav>
                </div>
            </div>

            <div class="inner cover">
                <h1 class="cover-heading">Hi, ${login} <c:if test="${login}==null"> dear friend!</c:if></h1>
                <p class="lead">Cover is a one-page template for building simple and beautiful home pages. Download,
                    edit the text, and add your own fullscreen background photo to make it your own.</p>
                <p class="lead">
                    <a href="/login" class="btn btn-lg btn-secondary">Sign-in</a>
                </p>
            </div>

            <div class="mastfoot">
                <div class="inner">
                    <p>Cover template for <a href="#" data-toggle="modal" data-target="#myModal">Modal</a>, by <a
                            href="https://twitter.com/mdo">@mdo</a>.</p>
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