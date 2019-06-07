$(".selection-2").select2({
    minimumResultsForSearch: 20,
    dropdownParent: $('#dropDownSelect1')
});

var speed = {
    slideDown:250,
    slideUp:300,
    slideDownNextSpeed:500,
    updated:false
};

function updateSpeed( speed) {
    if( !speed.updated)
        speed.slideDown = speed.slideDownNextSpeed;
}

(function ($) {
    "use strict";


    /*==================================================================
    [ Focus Contact2 ]*/
    $('.input3').each(function(){
        $(this).on('blur', function(){
            if($(this).val().trim() != "") {
                $(this).addClass('has-val');
            }
            else {
                $(this).removeClass('has-val');
            }
        })    
    });
            

    /*==================================================================
    [ Chose Radio ]*/
    $("#radio1").on('change', function(){
        if ($(this).is(":checked")) {
            $('.input1-select,.input1-3-select').slideDown(speed.slideDown);
            $('.input2-select,.input3-select').slideUp(speed.slideUp);
        }
        updateSpeed(speed)
    });

    $("#radio2").on('change', function(){
        if ($(this).is(":checked")) {
            $('.input1-select,.input1-3-select,.input3-select').slideUp(speed.slideUp);
            $('.input2-select').slideDown(speed.slideDown);
        }
        updateSpeed(speed)
    });

    $("#radio3").on('change', function(){
        if ($(this).is(":checked")) {
            $('.input1-select,.input2-select').slideUp(speed.slideUp);
            $('.input3-select,.input1-3-select').slideDown(speed.slideDown);
        }
        updateSpeed(speed)
    });


    /*==================================================================
    [ Validate ]*/
    var name = $('.validate-input input[name="name"]');
    var email = $('.validate-input input[name="email"]');
    var message = $('.validate-input textarea[name="message"]');


    $('.validate-form').on('submit',function(){
        var check = true;

        if($(name).val().trim() == ''){
            showValidate(name);
            check=false;
        }


        if($(email).val().trim().match(/^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{1,5}|[0-9]{1,3})(\]?)$/) == null) {
            showValidate(email);
            check=false;
        }

        if($(message).val().trim() == ''){
            showValidate(message);
            check=false;
        }

        return check;
    });


    $('.validate-form .input3').each(function(){
        $(this).focus(function(){
           hideValidate(this);
       });
    });

    function showValidate(input) {
        var thisAlert = $(input).parent();

        $(thisAlert).addClass('alert-validate');
    }

    function hideValidate(input) {
        var thisAlert = $(input).parent();

        $(thisAlert).removeClass('alert-validate');
    }
    
})(jQuery);