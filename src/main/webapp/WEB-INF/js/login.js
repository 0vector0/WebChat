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
                window.location.href = data.links[0].href;
            }
            ,
            error: function (data) {
                alert('error');
            }
        }
    )
}