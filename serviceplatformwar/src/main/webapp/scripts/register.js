var app = angular.module('registerApp', []);
app.controller('registerAppController', [ '$scope', '$http',
		function($scope, $http) {
			$scope.result = "Ready..";
			$scope.submit = function() {
				var formData = {
					"firstName" : $scope.firstName,
					"email" : $scope.email,
					"lastName" : $scope.lastName,
					"password" : $scope.password,
				};

				var response = $http.post('RegisterUser', formData);
				response.success(function(data, status, headers, config) {
					// $scope.result = "success";
					if (data.status != "SUCCESS") {
						alert(data.status);
					} else {
						window.location.href = 'views/success.html';
					}
				});
				response.error(function(data, status, headers, config) {
					$scope.result = "failed";
				});
			};
		} ]);