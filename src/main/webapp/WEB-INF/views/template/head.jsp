<html>
<head>
    <title>Title</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <script>function sendlogin() {
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
                        window.location.href = data.links[0].href;
                    }
                    ,
                    error: function (data) {
                        alert('error');
                    }
                }
        )
    }</script>
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
    <script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <link media="all" type="text/css" rel="stylesheet" href="../../../css/login-modal.css">
    <link media="all" type="text/css" rel="stylesheet" href="../../css/bootstrap-theme.css">
    <link media="all" type="text/css" rel="stylesheet" href="../../css/bootstrap.css">
</head>