(function() {
    "use strict";
    angular.module('EE.signUp').controller('signUpController', signUpController);
    signUpController.$inject = [ '$scope', '$rootScope', '$routeParams', '$location', '$http', 'Data', '$injector' ];
    function signUpController($scope, $rootScope, $routeParams, $location, $http, Data, $injector) {
        var vm = this;
        vm.alert = true;
        vm.signup = {
            email : '',
            password : '',
            firstName : '',
            lastName : ''
        };
        vm.signUp = function(user) {
            Data.post('signUp', user).then(function(results) {
                if (results.status == "success" || results.status == "SUCCESS") {
                    Data.toast(results);
                    //alert("Thanks for registring. Your signup is completed however you will be able to login in to your porstal once our representative will verify the details.");
                    $location.path('confirmation');
                } else if (results.status == "EMAIL ALREADY IN USE") {
                    alert("Email is already in use, try Login button.");
                } else {
                    alert("Some thing went wrong!");
                }
            });
        };

        vm.checkEmail = function(user) {
            Data.post('checkEmail', user).then(function(results) {
                vm.alert = true;
                if (results.status == "SUCCESS") {
                    Data.toast(results);
                } else if (results.status == "EMAIL ALREADY IN USE") {
                    vm.alert = false;
                }
            });
        };

    }

})();
