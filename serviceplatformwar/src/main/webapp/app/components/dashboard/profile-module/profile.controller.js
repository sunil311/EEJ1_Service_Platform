(function() {
    "use strict";
    angular
        .module('EE.dashboard.module')
        .controller('profileController', profileController);
    profileController.$inject = ['$scope','$state','$rootScope', '$routeParams', '$location', '$http', 'Data', '$injector'];
    	function profileController($scope,$state, $rootScope, $routeParams, $location, $http, Data, $injector) {
    		var vm = this;	
    		vm.headerEnabled = function() { return $state.includes('dashboard.profile') }
    	}
    
})();