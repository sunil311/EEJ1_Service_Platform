(function() {
    "use strict";
    angular.module('EE.signUp').controller('signUpController', signUpController);
    signUpController.$inject = [ '$scope', '$rootScope', '$routeParams', '$location', '$http', 'Data', '$injector' ];
    function signUpController($scope, $rootScope, $routeParams, $location, $http, Data, $injector) {
        var vm = this;
        vm.alertSuccess = true;
        vm.alertFailed = true;
        vm.alertEmail = true;
        vm.signup = {
            email : '',
            password : '',
            firstName : '',
            lastName : ''
        };
        vm.signUp = function(user) {
            Data.post('signUp', user).then(function(results) {
                if (results.status == "success" || results.status == "SUCCESS") {     
                    vm.alertSuccess = false;
                    $location.path('/confirmation');
                    vm.signup={};
                } else if (results.status == "EMAIL ALREADY IN USE") {            
                    vm.alertEmail = false;
                } else {                   
                    vm.alertFailed = false;
                }
            },function(e){
            	vm.alertFailed = false;
            	});
        };

        vm.checkEmail = function(user) {
            Data.post('checkEmail', user).then(function(results) {
                vm.alert = true;
                if (results.status == "SUCCESS") {
                	vm.alertSuccess = false;
                } else if (results.status == "EMAIL ALREADY IN USE") {
                	vm.alertEmail = false;
                }
            });
        };
        
        vm.hideAlertMessage = function () {
        	vm.alertSuccess = true;
            vm.alertFailed = true;
            vm.alertEmail = true;
        };

    }

})();
