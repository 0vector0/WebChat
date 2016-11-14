<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Login title</h4>
            </div>
            <div class="modal-body">


                <div class="login-container animated fadeInDown bootstrap snippets">
                    <div class="loginbox bg-white">
                        <div class="loginbox-title">SIGN IN</div>

                        <div class="loginbox-textbox">
                            <label><s:message code="reg.login"/>:</label>
                            <input type="text" class="form-control" id="login" placeholder="Login">
                        </div>
                        <div class="loginbox-textbox">
                            <label><s:message code="reg.password"/>:</label>
                            <input type="text" class="form-control" id="password" placeholder="Password">
                        </div>
                        <div class="loginbox-forgot">
                            <a href="">Forgot Password?</a>
                        </div>
                        <div class="loginbox-submit">
                            <button type="submit" onclick="send()">Login</button>
                        </div>
                        <div class="loginbox-signup">
                            Not register? <a href="/register">Sign Up right now</a>
                        </div>
                    </div>
                    <div class="logobox">
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
