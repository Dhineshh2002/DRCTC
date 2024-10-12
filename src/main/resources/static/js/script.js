$(document).ready(function () {

    $('#password').focusout(function () {
        if (!isValidPassword($(this).val())) {
            $(this).closest('div').find('span').removeClass('d-none');
        } else {
            $(this).closest('div').find('span').addClass('d-none');
        }
    });

    //THIS IS SHIT

    $('#confirmpassword').focusout(function () {
        let password = $(this).val();
        if (password != $(this).val()) {
            $(this).closest('div').find('span').removeClass('d-none');
        } else {
            $(this).closest('div').find('span').addClass('d-none');
        }
    })

    $('form').on('submit', function (event) {
        event.preventDefault();
    });

    //LOGIN PAGE SCRIPT

    $('#login').click(function () {

        let username = $('#username').val().trim();
        let password = $('#password').val().trim();

        const User = { username, password };

        fetch('/user/check', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(User)
        }).then(response => {
            console.log(response);
            if (!response.ok) {
                throw new Error("Server crashed")
            }
            return response.json();
        }).then(data => {
            console.log(data);
            window.location.href = '/user/home?username='+data.username;
        }).catch(e => {
            console.error('There was a problem with the fetch operation:', e);
        })
    });


    // SIGN UP PAGE
    $('#signup').click(function () {
        window.location.href = "/user/signup";
    });

    $('#create').click(function () {

        let name = $('#name').val().trim();
        let username = $('#username').val().trim();
        let password = $('#password').val().trim();
        let phone = $('#phone').val().trim();
        let email = $('#email').val().trim();

        let User = {
            name,
            username,
            password,
            phone,
            email
        }

        let data = JSON.stringify(User);

        fetch('/user/add', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json', // Setting content type to JSON
            },
            body: JSON.stringify(User)
        }).then(response => {
            if (!response.ok) {
                throw new Error('Server not responded');
            }
            return response.json();
        }).then(data => {
            alert("account created :) Please login now");
            window.location.href = "/user/login";
        }).catch(error => {
            console.error('There was a problem with the fetch operation:', error);
        });
    })

    function isValidPassword(password) {
        const passwordPattern = /^(?=.*[A-Z])(?=.*[a-z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;
        return passwordPattern.test(password);
    }

})