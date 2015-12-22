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
		vm.alertSuccess = true;
        vm.alertFailed = true;
			
		AggrigatorData.get('findInactiveAggrigator ').then(function (results) {
			vm.aggregatorsList=results;
    });
		
		 vm.hideAlertMessage = function () {
	        	vm.alertSuccess = true;
	            vm.alertFailed = true;
	         
	        };
	        
		vm.activate = function(user) {
			vm.alertSuccess = true;
	        vm.alertFailed = true;
            $('#submit_button_id').attr('disabled',true);
            AggrigatorData.post('updateAggrigator', user).then(function(results) {
            	$('#submit_button_id').attr('disabled', false);
                if (results == "Database created successfully") {                 
                    vm.alertSuccess = false;
                    vm.dbprofile = {};
                } else {
                	$('#submit_button_id').attr('disabled', false);
                	vm.alertFailed = false;
                	
                }
            },function(e){
            	$('#submit_button_id').attr('disabled', false);
            	vm.alertFailed = false;
            	});

        };
		}
	

})();