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
                succses: function (data, textstatus, error) {

                },
            })
        }
    </script>
</head>
<body>
<form>
    login: <input type="text" userId="login"/>
    password: <input type="text" userId="password"/>
    is admin <input type="checkbox" userId="is-admin">
    <input type="button" onclick="sendlogin()" value="login">
</form>
</body>
</html>
