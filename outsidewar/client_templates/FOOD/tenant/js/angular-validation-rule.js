(function() {
    angular.module('validation.rule', ['validation'])
        .config(['$validationProvider',
            function($validationProvider) {
                var defaultMsg = {
                    required: {
                        error: 'This should be Required!!',
                        success: 'It\'s Required'
                    },
                    url: {
                        error: 'This should be Url',
                        success: 'It\'s Url'
                    },
                    email: {
                        error: 'This should be Email',
                        success: 'It\'s Email'
                    },
                    number: {
                        error: 'This should be Number',
                        success: 'It\'s Number'
                    },
                    minlength: {
                        error: 'This should be longer',
                        success: 'Long enough!'
                    },
                    maxlength: {
                        error: 'This should be shorter',
                        success: 'Short enough!'
                    },
                    mobile: {
                        error: 'This should be 10 digit no.',
                        success: 'good!'
                    },
                    match: {
                        error: 'Password and Confirm Password is not matching !',
                        success: 'Password and Confirm Password matched !'
                    },
                    password: {
                        error: '',
                        success: 'Password and Confirm Password matched !'
                    }
                };
                var expression = {
                    required: function(value) {
                        return !!value;
                    },
                    url: /((([A-Za-z]{3,9}:(?:\/\/)?)(?:[-;:&=\+\$,\w]+@)?[A-Za-z0-9.-]+|(?:www.|[-;:&=\+\$,\w]+@)[A-Za-z0-9.-]+)((?:\/[\+~%\/.\w-_]*)?\??(?:[-\+=&;%@.\w_]*)#?(?:[\w]*))?)/,
                    email: /^([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/,
                    number: /^\d+$/,
                    mobile: /[0-9]{10}/,
                    minlength: function(value, scope, element, attrs, param) {
                        return value.length >= param;
                    },
                    password: function(value, scope, element, attrs, param) {
                        if (value.length < 8) {
                            defaultMsg.password.error = "Your password must be at least 8 characters";
                            return false;
                        }
                        if (value.search(/[a-z]/i) < 0) {
                            defaultMsg.password.error = "Your password must contain at least one letter.";
                            return false;
                        }
                        if (value.search(/[0-9]/) < 0) {
                            defaultMsg.password.error = "Your password must contain at least one digit.";
                            return false;
                        }

                        return true;

                    },


                    maxlength: function(value, scope, element, attrs, param) {
                        return value.length <= param;
                    },
                    match: function(value, scope, element, attrs, param) {
                        var ele = document.getElementsByName(param);
                        if (ele != undefined && ele.length > 0) {
                            return ele[0].value == value;
                        } else {
                            return true;
                        }
                    }
                };


                $validationProvider.setExpression(expression).setDefaultMsg(defaultMsg);

            }
        ]);

}).call(this);