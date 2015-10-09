var app = angular.module('loginApp', []);
app.controller('loginAppController', [ '$scope', '$http',
		function($scope, $http) {
			$scope.submit = function() {
				
				var formData = {
						"email" : "sadsada",
					};
				var response = $http.post('../spring/login', $scope.formData);
				response.success(function(data, status, headers, config) {
					$scope.result = "success";
				});
				response.error(function(data, status, headers, config) {
					$scope.result = "failed";
				});
			};
		} ]);