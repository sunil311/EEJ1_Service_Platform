(function() {
    "use strict";
    app.controller('registerProviderController', registerProviderController);
    registerProviderController.$inject = [ '$scope', '$rootScope', '$routeParams', '$location', '$http', 'Data', 'RegisterProvider','$injector' ];
    function registerProviderController($scope, $rootScope, $routeParams, $location, $http, Data,RegisterProvider, $injector) {
        var vm = this;
        vm.webData={};
        vm.city="";
        vm.restorent="";
        vm.cuisine="";
         vm.alert = true;
         vm.error = true;
        vm.registerData={};
        Data.get('').then(function(results) {              
                vm.webData=results;
               
            });
        vm.setRegister = function(user) {
            
            RegisterProvider.post('addProvider',user).then(function(results) {
             if (results.status == "success" || results.status == "SUCCESS") {
                  vm.alert=true;
                  vm.error = false;
                } else{
                    vm.alert=false;
                    vm.error = true;
                }
            });
        };

    }

})();