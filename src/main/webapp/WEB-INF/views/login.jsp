<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                data: JSON.stringify({
                    'login': document.getElementById('login').value,
                    'password': document.getElementById('password').value,
                    'is-admin': document.getElementById('is-admin').value
                }),
                succses: function (data, textstatus, error) {

                }
            })
        }
    </script>
</head>
<body>
<form>
    login: <input type="text" id="login"/>
    password: <input type="text" id="password"/>
    is admin <input type="checkbox" id="is-admin">
    <input type="button" onclick="sendlogin()" value="login">
</form>
</body>
</html>
