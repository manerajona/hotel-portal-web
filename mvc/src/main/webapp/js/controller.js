$(document).ready(function () {

    var root = "http://localhost:8080";
    var headers = {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
    };

    /******************
    **USER SERVICE**
    ******************/
    var user = "/user";

    $("#createUser").submit(function( event ) {
            // Stop form from submitting normally
            event.preventDefault();

            var url = root + user;

            var body = {
                "id": $('input[name="id"]').val(),
                "username": $('input[name="username"]').val(),
                "firstName": $('input[name="firstName"]').val(),
                "lastName": $('input[name="lastName"]').val(),
                "email": $('input[name="email"]').val(),
                "password": $('input[name="password"]').val()
            };

            var json = JSON.stringify(body);

            // Send the data using post
            $.ajax({
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                'type': 'POST',
                'url': url,
                'data': json,
                'dataType': 'json',
                'success': function() {
                    $('#createMessage')[0].reset();
                }
            });
        });

    /******************
    **MESSAGE SERVICE**
    ******************/
    var message = "/message";

    $("#createMessage").submit(function( event ) {
        // Stop form from submitting normally
        event.preventDefault();

        var url = root + message;

        var body = {
            "id": $('input[name="id"]').val(),
            "name": $('input[name="name"]').val(),
            "subject": $('input[name="subject"]').val(),
            "content": $('textarea[name="content"]').val(),
            "email": $('input[name="email"]').val(),
            "phone": $('input[name="phone"]').val()
        };

        var json = JSON.stringify(body);

        // Send the data using post
        $.ajax({
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'type': 'POST',
            'url': url,
            'data': json,
            'dataType': 'json',
            'success': function() {
                $('#createMessage')[0].reset();
            }
        });
    });

    /******************
    **USER SERVICE**
    ******************/
    var reservation = "/reservation";

});