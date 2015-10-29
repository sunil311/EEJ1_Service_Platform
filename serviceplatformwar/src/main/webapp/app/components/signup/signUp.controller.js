(function() {
    "use strict";
    angular
        .module('EE.signUp')
        .controller('signUpController', signUpController);
    	signUpController.$inject = ['$scope', '$rootScope', '$routeParams', '$location', '$http', 'Data', '$injector'];
    	function signUpController($scope, $rootScope, $routeParams, $location, $http, Data, $injector) {
    		var vm = this;	
    		vm.signup = {email:'',password:'',firstName:'',lastName:''};
    		 vm.signUp = function (user) {
    			 var promise=  Data.post('signUp',user);
    			 promise.then(function (results) {
    				
			          if (results.status == "SUCCESS") {
			                  //Data.toast(results);
			                $location.path('dashboard');
			            }else if (results.status == "EMAIL ALREADY IN USE") {
							alert("Email is already in use, try Login button.");
						} else {
							alert("Some thing went wrong!");
						}
			        });
    			    };
    	}
    
})();