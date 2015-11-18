(function() {
	"use strict";
	angular.module('EE.dashboard.module').controller(
			'activateAggrigatorController', activateAggrigatorController);
	activateAggrigatorController.$inject = [ '$scope', '$rootScope',
			'$routeParams', '$location', '$http', 'Data', '$injector' ];
	function activateAggrigatorController($scope, $rootScope, $routeParams,
			$location, $http, Data, $injector) {
		var vm = this;
		this.dbprofile = {};
		this.options = [ "1", "2", "3" ];
		var dirty = false;
		var result = [];
		$scope.getData = function() {
			if (!dirty) {
				dirty = true;

	           /* Data.post('../activateAgg').then(function(results) {
	                vm.alert = true;
	                    Data.toast(results);
	            });*/
	        
				//result = [ "1", "2", "3" ];
				
			}
			return result;
		}
	}

})();