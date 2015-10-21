(function() {
    angular.module('validation.rule', ['validation'])
        .config(['$validationProvider',
            function($validationProvider) {

                var expression = {
                    required: function(value) {
                        return !!value;
                    },
                    url: /((([A-Za-z]{3,9}:(?:\/\/)?)(?:[-;:&=\+\$,\w]+@)?[A-Za-z0-9.-]+|(?:www.|[-;:&=\+\$,\w]+@)[A-Za-z0-9.-]+)((?:\/[\+~%\/.\w-_]*)?\??(?:[-\+=&;%@.\w_]*)#?(?:[\w]*))?)/,
                    email: /^([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/,
                    number: /^\d+$/,
                    minlength: function(value, scope, element, attrs, param) {
                        return value.length >= param;
                    },
                    maxlength: function(value, scope, element, attrs, param) {
                        return value.length <= param;
                    },
                    match : function(value,scope,element,attrs,param){
                    	var ele = document.getElementsByName(param);
                    	if(ele!= undefined && ele.length>0)
                    	{
                    	return ele[0].value == value;
                    	}
                    	else
                    		{
                    		return true;
                    		}
                    }
                };

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
                    match: {
                    	   error: 'Password and Confirm Password is not matching !',
                           success: 'Password and Confirm Password matched !'
                    }
                };

                $validationProvider.setExpression(expression).setDefaultMsg(defaultMsg);

            }
        ]);

}).call(this);
