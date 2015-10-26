app.controller('authCtrl', function($scope, $rootScope, $routeParams, $location, $http, Data, $injector) {
    // initially set those objects to null to avoid undefined error
    $scope.login = {};
    var $validationProvider = $injector.get('$validation');
    $scope.signup = {};
    $scope.alert = true;
    $scope.hideAlertMessage = function() {
        console.log(1);
        $scope.alert = true;
    };
    $scope.signup = {
        email : '',
        password : '',
        firstName : '',
        lastName : ''
    };

    $scope.form = {
        requiredCallback : 'required',
        checkValid : $validationProvider.checkValid,
        submit : function() {
            // angular validation 1.2 can reduce this procedure, just focus on
            // your action
            // $validationProvider.validate(form);
        },
        reset : function() {
            // angular validation 1.2 can reduce this procedure, just focus on
            // your action
            // $validationProvider.reset(form);
        }
    };
    $scope.signUp = function(user) {
        Data.post('signUp', user).then(function(results) {
            if (results.status == "SUCCESS") {
                Data.toast(results);
                $location.path('dashboard');
            } else if (results.status == "EMAIL ALREADY IN USE") {
                alert("Email is already in use, try Login button.");
            } else {
                alert("Some thing went wrong!");
            }
        });
    };
    $scope.logout = function() {
        Data.get('logout').then(function(results) {
            Data.toast(results);
            $location.path('login');
        });
    };
});