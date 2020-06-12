// UI-Modals.js
// ====================================================================
// This file should not be included in your project.
// This is just a sample how to initialize plugins or components.
//
// - ThemeOn.net -


$(document).ready(function () {
    $('#demo-bootbox-alert').on('click', function () {
        bootbox.alert("Hello world!", function () {
            $.niftyNoty({
                type: 'info',
                icon: 'pli-exclamation icon-2x',
                message: 'Hello world callback',
                container: 'floating',
                timer: 5000
            });
        });
    });


    // BOOTBOX - CONFIRM MODAL
    // =================================================================
    // Require Bootbox
    // http://bootboxjs.com/
    // =================================================================
    $('#demo-bootbox-confirm').on('click', function () {
        //modal确认框
        bootbox.confirm("Are you sure?", function (result) {
            if (result) {
                $.niftyNoty({
                    type: 'success',
                    icon: 'pli-like-2 icon-2x',
                    message: 'User confirmed dialog',
                    container: 'floating',
                    timer: 5000
                });
            } else {
                $.niftyNoty({
                    type: 'danger',
                    icon: 'pli-cross icon-2x',
                    message: 'User declined dialog.',
                    container: 'floating',
                    timer: 5000
                });
            }
            ;

        });
    });


    // BOOTBOX - PROMPT MODAL
    // =================================================================
    // Require Bootbox
    // http://bootboxjs.com/
    // =================================================================
    $('#demo-bootbox-prompt').on('click', function () {
        bootbox.prompt("What is your name?", function (result) {
            if (result) {
                $.niftyNoty({
                    type: 'success',
                    icon: 'pli-consulting icon-2x',
                    message: 'Hi ' + result,
                    container: 'floating',
                    timer: 5000
                });
            } else {
                $.niftyNoty({
                    type: 'danger',
                    icon: 'pli-cross icon-2x',
                    message: 'User declined dialog.',
                    container: 'floating',
                    timer: 5000
                });
            }
            ;
        });
    });

});