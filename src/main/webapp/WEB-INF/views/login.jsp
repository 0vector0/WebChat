<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="error.jsp" %>
<html>
<head>
    <title>Title</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <script>
        function sendlogin() {
            $.ajax({
                type: 'GET',
                contentType: 'application/JSON',
                url: '${urlpath}',
                dataType: 'json',
                success: function (data, textstatus, error) {
                    verifyLoginUrl = data.links[0].href;
                },
                error: function (data) {
                    alert('error');
                }
            })
        }
        ;
        function send() {
            $.ajax({
                        type: 'POST',
                        contentType: 'application/JSON',
                        url: verifyLoginUrl,
                        dataType: 'json',
                        data: JSON.stringify({
                            'login': document.getElementById('login').value,
                            'password': document.getElementById('password').value,
                            //'isadmin': document.getElementById('is-admin'),
                        }),
                        success: function (data, textstatus, error) {
                            console.log(JSON.stringify(data));

                            window.location.href = data.links[0].href;
                        }
                        ,
                        error: function (data) {
                            alert('error');
                        }
                    }
            )
        }
    </script>
</head>
<body onload="sendlogin()">

<form>
    login: <input type="text" id="login"/>
    password: <input type="text" id="password"/>
    is admin <input type="checkbox" id="is-admin">
    <input type="button" onclick="send()" value="login">
</form>
</body>
</html>
