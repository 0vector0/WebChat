<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="error.jsp" %>
<html>
<head>
    <title>Chat</title>
    <script src="http://cdn.sockjs.org/sockjs-0.3.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
    <script type="text/javascript">

        var socket = new SockJS('${socketUrl}');
        var flag = null;
        var activeUsers = null;

        //        angular
        var app = angular.module('webChat', []);
        app.controller('activeUsers', function ($scope) {
            $scope.myFun = function (activeUsers) {
                $scope.users = activeUsers;
            };
            $scope.changeCount = function (user) {
                document.getElementById('input').value = user + ':';
            }
        });

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
                activeUsers = JSON.parse(messageArray[1]);
                var scope = angular.element(document.getElementById('mywebchat')).scope();
                scope.$apply(function () {
                    scope.myFun(activeUsers);
                });
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
    <div ng-app="webChat" ng-controller="activeUsers" id="mywebchat">
        <ul>
            <li ng-repeat="user in users" ng-click="changeCount(user)">{{user}}</li>
        </ul>
    </div>
    <br/>
    <label for="output">Chat room:</label>
    <br/>
    <textarea id="output" rows="10" cols="60"></textarea>

    <br/>
    <label for="input">Input your message:</label>
    <br/>
    <input type="text" id="input"/>
    <input type="button" onclick="send()" name="Send" value="Send"/>
    <input type="button" onclick="broadcast()" name="Send" value="Send to All"/>
</form>

</body>
</html>
