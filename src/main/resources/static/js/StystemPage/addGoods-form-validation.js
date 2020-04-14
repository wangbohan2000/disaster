// Form-Validation.js
// ====================================================================
// This file should not be included in your project.
// This is just a sample how to initialize plugins or components.
//
// - ThemeOn.net -


$(document).ready(function () {


    // FORM VALIDATION
    // =================================================================
    // Require Bootstrap Validator
    // http://bootstrapvalidator.com/
    // =================================================================


    // FORM VALIDATION FEEDBACK ICONS
    // =================================================================
    var faIcon = {
        valid: 'fa fa-check-circle fa-lg text-success',
        invalid: 'fa fa-times-circle fa-lg',
        validating: 'fa fa-refresh'
    }


    // FORM VALIDATION ON TABS
    // =================================================================
    $('#add_goods_form').bootstrapValidator({
        excluded: [':disabled'],
        feedbackIcons: faIcon,
        fields: {
            current_user: {
                validators: {
                    notEmpty: {
                        message: '用户来源不能为空'
                    }
                }
            },
            goods_name: {
                validators: {
                    notEmpty: {
                        message: '物资名不能为空'
                    }
                }
            },
            goods_mount: {
                validators: {
                    notEmpty: {
                        message: '物资数量不能为空'
                    },
                    digits: {
                        message: '该值只能包含数字。'
                    }
                },

            },
            goods_unit: {
                validators: {
                    notEmpty: {
                        message: '物资计量单位不能为空'
                    },
                }
            },
            create_time: {
                validators: {
                    notEmpty: {
                        message: '创建时间不能为空'
                    }
                }
            }
        }
    }).on('status.field.bv', function (e, data) {
        var $form = $(e.target),
            validator = data.bv,
            $tabPane = data.element.parents('.tab-pane'),
            tabId = $tabPane.attr('id');

        if (tabId) {
            var $icon = $('a[href="#' + tabId + '"][data-toggle="tab"]').parent().find('i');

            // Add custom class to tab containing the field
            if (data.status == validator.STATUS_INVALID) {
                $icon.removeClass(faIcon.valid).addClass(faIcon.invalid);
            } else if (data.status == validator.STATUS_VALID) {
                var isValidTab = validator.isValidContainer($tabPane);
                $icon.removeClass(faIcon.valid).addClass(isValidTab ? faIcon.valid : faIcon.invalid);
            }
        }
    });


});



