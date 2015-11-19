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
		var dirty = false;
		var result = [];
			
		AggrigatorData.get('findInactiveAggrigator ').then(function (results) {
			vm.aggregatorsList=results;
    });
		vm.activate = function(user) {
            console.log(user);
            $scope.alert = true;
            AggrigatorData.post('updateAggrigator', user).then(function(results) {
                if (results == "SUCCESS") {
                    alert("USER is now activated and email has been sent.")
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