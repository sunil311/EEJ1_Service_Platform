(function() {
    "use strict";
    angular
        .module('EE.dashboard.module')
        .controller('dashboardController', dashboardController);
    dashboardController.$inject = ['$scope','$state','$rootScope', '$routeParams', '$location', '$http', 'Data', '$injector'];
    	function dashboardController($scope,$state, $rootScope, $routeParams, $location, $http, Data, $injector) {
    		var vm = this;	
    		vm.headerEnabled = function() { return $state.includes('dashboard') }
    	}
    
})();