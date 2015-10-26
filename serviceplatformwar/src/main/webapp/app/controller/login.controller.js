(function() {
    "use strict";
    angular
        .module('EE.login')
        .controller('loginController', loginController);
    	loginController.$inject = ['$scope', '$rootScope', '$routeParams', '$location', '$http', 'Data', '$injector'];
    	function loginController($scope, $rootScope, $routeParams, $location, $http, Data, $injector) {
    		var vm = this;	
    		vm.alert=true;
    		vm.doLogin = function (customer) {
    		        console.log(customer);
    		        vm.alert=true;
    		      /*  Data.post('login', {
    		            customer: customer
    		        }).then(function (results) {
    		            
    		            if (results.status == "success") {
    		                Data.toast(results);
    		                $location.path('dashboard');
    		            }
    		        });*/
    		        if (customer.email == "admin"&&customer.password == "admin") {
    		                $location.path('dashboard');
    		            }else{
    		            	vm.alert=false;
    		            }
    		    };
    		    vm.hideAlertMessage = function () {
    		           
    		             vm.alert=true;
    		    }
    	}
    
})();