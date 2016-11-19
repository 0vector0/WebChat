<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="error.jsp" %>
<html>
<head>
    <title>Chat</title>
    <script src="http://cdn.sockjs.org/sockjs-0.3.min.js"></script>
    <script type="text/javascript">
//        var socket = new WebSocket("ws://localhost:8080/app");
        var socket = new SockJS('${socketUrl}');
        var flag = null;
        socket.onopen = function () {
            registrationUser();
            flag = window.setInterval(sendList, 2000);
        };
        socket.onclose = function (event) {
            window.clearInterval(flag);
            if (event.wasClean) {
                alert("Closed!");
            } else {
                alert("Error!");
            }
        };
        socket.onmessage = function (event) {
            var message = event.data;
            var messageArray = message.split(':');
            if (messageArray[0] == 'list') {
                document.getElementById('active-users').value = messageArray[1];
            } else {
                var text = document.getElementById("output").value;
                text = text + "\n" + message;
                document.getElementById("output").value = text;
            }
        };


        function send() {
            var input = document.getElementById("input").value;
            socket.send(input);
        }

        function sendList() {
            socket.send('list:');
        }

        function registrationUser() {
            socket.send('name:' + '${requestScope.user}')
        }


    </script>

</head>
<body>
<h1>Chat</h1>
<form>
    <textarea id="output"></textarea>
    <textarea id="active-users"></textarea>
    <input type="text" id="input"/>
    <input type="button" onclick="send()" name="Send" value="Send"/>
    <input type="button" onclick="sendList()" name="Send" value="List"/>
</form>
</body>
</html>
