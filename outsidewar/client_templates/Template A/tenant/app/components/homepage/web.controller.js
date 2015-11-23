(function() {
    "use strict";
    app.controller('webController', webController);
    webController.$inject = [ '$scope', '$rootScope', '$routeParams', '$location', '$http', 'Data', '$injector' ];
    function webController($scope, $rootScope, $routeParams, $location, $http, Data, $injector) {
        var vm = this;
        vm.webData={};
        vm.city="";
        vm.restorent="";
        vm.cuisine="";
        Data.get('').then(function(results) {              
                vm.webData=results;
                console.log(vm.webData);
            });
    }

})();