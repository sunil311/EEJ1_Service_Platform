var app = angular.module('registerApp', []);

app.controller('registerAppController', function($scope, $http) {
    
    $http.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=utf-8';
    var pageData = '';
    $scope.submit = function() {

        $http({
            method : 'POST',
            url : 'spring/RegisterUser',
        }).success(function(data, status, headers, config) {
            alert("test");
        }).error(function(data, status, headers, config) {
            // called asynchronously if an error occurs
            // or server returns response with an error status.
            alert("Rakesh");
        });

    };

});

