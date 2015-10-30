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

		vm.headerEnabled = function() {
			return $state.includes('dashboard');
		};

		vm.download = function() {
			$http.post('DownloadTemplate/download', vm.data, {
				responseType : 'arraybuffer'
			}).then(function(results) {
				var file = new Blob([result.data], {type: 'application/octet-stream'});
                var fileURL = window.URL.createObjectURL(file);
                a.href = fileURL;
                a.download = fileName;
                a.click();
			});
			/*
			 * downloadFactory.post('download', vm.data).then(function(results) {
			 * var blob = new Blob([ results ], { type : "octet/stream" });
			 * saveAs(blob, "lol"); });
			 */
		};
	}

})();