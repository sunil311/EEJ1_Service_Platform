(function() {
	"use strict";
	angular.module('EE.dashboard.module').controller('dashboardController',
			dashboardController);
	dashboardController.$inject = [ '$scope', '$state', '$rootScope',
			'$routeParams', '$location', '$http', 'Data', 'downloadFactory',
			'$injector' ];
	function dashboardController($scope, $state, $rootScope, $routeParams,
			$location, $http, Data, downloadFactory, $injector) {
		var vm = this;
		vm.data = {
			tenantId : 'tenantId',
			tokenId : 'tenantId',
			refererId : 'tenantId',
			payload : 'tenantId'
		};
		//TODO: get this value from session
		$scope.tenantId = 'sada23322swsqs1';
		vm.headerEnabled = function() {
			return $state.includes('dashboard');
		};

		vm.download = function() {
			// TODO: will add logic later
		};
		
		  


		
		
	}
})();