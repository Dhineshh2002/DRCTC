$(document).ready(function(){

    $('#signup').click(function(){
        window.location.href = "http://localhost:63342/DRTCT/templates/usersignup.html";
    });

    $('#password').on('input', function(){
        if(!isValidPassword($(this).val())) {
            $(this).closest('div').find('span').removeClass('d-none');
        } else {
            $(this).closest('div').find('span').addClass('d-none');
        }
    });

    $('#confirmpassword').focusout(function(){
        let password = $(this).val();
        if(password != $(this).val()){
             $(this).closest('div').find('span').removeClass('d-none');
        } else {
            $(this).closest('div').find('span').addClass('d-none');
        }
    })

    $('#create').click(function(){

    })

    function isValidPassword(password) {
        const passwordPattern = /^(?=.*[A-Z])(?=.*[a-z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;
        return passwordPattern.test(password);
    }
})