(function() {
	"use strict";
	angular.module('EE.dashboard.module').controller(
			'activateAggrigatorController', activateAggrigatorController);
	activateAggrigatorController.$inject = [ '$scope', '$rootScope',
			'$routeParams', '$location', '$http', 'AggrigatorData', '$injector' ];
	function activateAggrigatorController($scope, $rootScope, $routeParams,
			$location, $http, AggrigatorData, $injector) {
		var vm = this;
		vm.dbprofile = {};
		vm.options = [ "1", "2", "3" ];
		var dirty = false;
		var result = [];
			
			
		AggrigatorData.get('findInactiveAggrigator ').then(function (results) {
			console.log(results);
			vm.dbprofile.aggregatorsList=results;
       
    });
		vm.active = function(user) {
            console.log(user);
            $scope.alert = true;
            AggrigatorData.post('doLogin', user).then(function(results) {
                if (results.status == "SUCCESS") {
                    
                    $location.path('dashboard');
                } else if (results.status == "USER DO NOT EXISTS") {
                    vm.alert=false;
                } else {
                    vm.alert=false;
                }
            });

        };
		}
	

})();