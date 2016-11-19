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

