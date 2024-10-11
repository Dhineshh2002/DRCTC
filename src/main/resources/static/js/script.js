$(document).ready(function () {


    $('#signup').click(function () {
        window.location.href = "/user/signup";
    });

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
                throw new Error('Sorry for error');
            }
            return response.json();
        })
            .then(data => {
                alert("Server responded with: " + data.val + " Status code: " + response.status);
            })
            .catch(error => {
                console.error('There was a problem with the fetch operation:', error);
            });
    })

    function isValidPassword(password) {
        const passwordPattern = /^(?=.*[A-Z])(?=.*[a-z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;
        return passwordPattern.test(password);
    }

})