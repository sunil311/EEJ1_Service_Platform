var app = angular.module('registerApp', []);

app.controller('registerAppController', function($scope, $http) {
    var pageData = '';
    $scope.submit = function() {

        console.log("Submitting Form");
        $http.get("spring/RegisterUser").success(function(response) {
            alert(response);
        }).error(function(response) {
            alert("Errro"+response);
        });
    };
});