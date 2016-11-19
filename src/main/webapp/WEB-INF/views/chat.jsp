<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="error.jsp" %>
<html>
<head>
    <title>Chat</title>
    <script src="http://cdn.sockjs.org/sockjs-0.3.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
    <script type="text/javascript">
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
                var users = messageArray[1].split(';');
                document.getElementById('active-users').value = messageArray[1];
            } else {
                var text = document.getElementById("output").value;
                text = text + "\n" + message;
                document.getElementById("output").value = text;
            }
        };

        function send() {
            socket.send(document.getElementById("input").value);
        }

        function sendList() {
            socket.send('list:');
        }

        function registrationUser() {
            socket.send('name:' + '${requestScope.user}')
        }
        function broadcast() {
            socket.send('broadcast:' + document.getElementById("input").value);
        }
    </script>

</head>
<body>
<h1>Chat</h1>
<form>
    <div ng-app="webChat" id="active-users">

    </div>
    <textarea id="output"></textarea>
    <%--<textarea id="active-users"></textarea>--%>
    <input type="text" id="input"/>
    <input type="button" onclick="send()" name="Send" value="Send"/>
    <input type="button" onclick="broadcast()" name="Broadcast" value="Broadcast"/>
</form>
</body>
</html>
