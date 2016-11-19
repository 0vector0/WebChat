<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="error.jsp" %>
<html>
<head>
    <title>Chat</title>

    <script type="text/javascript">
        var socket = new WebSocket("ws://localhost:8080/app");
        socket.onopen = function () {
        };
        socket.onclose = function (event) {
            if (event.wasClean) {
                alert("Closed!");
            } else {
                alert("Error!");
            }
        };
        socket.onmessage = function (event) {
            var message = event.data;

            var text = document.getElementById("output").value;
            text = text + "\n" + message;
            document.getElementById("output").value = text;


        };


        function send() {
            var input = document.getElementById("input").value;
            socket.send(input);
        }
        ;

    </script>

</head>
<body>
<h1>Chat</h1>
<form>
    <textarea id="output"></textarea>
    <input type="text" id="input"/>
    <input type="button" onclick="send()" name="Send" value="Send"/>
</form>
</body>
</html>
