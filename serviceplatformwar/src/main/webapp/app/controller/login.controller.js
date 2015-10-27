(function() {
    "use strict";
    angular.module('EE.login').controller('loginController', loginController);
    loginController.$inject = [ '$scope', '$rootScope', '$routeParams', '$location', '$http', 'Data', '$injector' ];
    function loginController($scope, $rootScope, $routeParams, $location, $http, Data, $injector) {
        var vm = this;
        vm.alert = true;

        vm.doLogin = function(user) {
            console.log(user);
            $scope.alert = true;
            Data.post('doLogin', user).then(function(results) {
                if (results.status == "SUCCESS") {
                    Data.toast(results);
                    $location.path('dashboard');
                } else if (results.status == "USER DO NOT EXISTS") {
                    vm.alert=false;
                } else {
                    vm.alert=false;
                }
            });

        };
        vm.hideAlertMessage = function () {
            vm.alert=true;
        }
    }

})();