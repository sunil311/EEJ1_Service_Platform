var app = angular.module('registerApp', []);
app.controller('registerAppController', [ '$scope', '$http',
		function($scope, $http) {
			$scope.result = "Ready..";
			$scope.submit = function() {
				var formData = {
					"email" : "sadsada",
				};
				var response = $http.post('/spring/RegisterUser', formData);
				response.success(function(data, status, headers, config) {
					$scope.result = "success";
				});
				response.error(function(data, status, headers, config) {
					$scope.result = "failed";
				});
			};
		} ]);
