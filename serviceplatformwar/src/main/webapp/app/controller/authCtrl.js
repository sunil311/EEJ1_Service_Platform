app.controller('authCtrl', function ($scope, $rootScope, $routeParams, $location, $http, Data) {
    //initially set those objects to null to avoid undefined error
    $scope.login = {};
    $scope.signup = {};
    $scope.alert=true;
    $scope.doLogin = function (customer) {
        console.log(customer);
        $scope.alert=true;
      /*  Data.post('login', {
            customer: customer
        }).then(function (results) {
            
            if (results.status == "success") {
                Data.toast(results);
                $location.path('dashboard');
            }
        });*/
        if (customer.email == "admin"&&customer.password == "admin") {
                $location.path('dashboard');
            }else{
                $scope.alert=false;
            }
    };
    $scope.hideAlertMessage = function () {
             console.log(1);
            $scope.alert=true;
    };
    $scope.signup = {email:'',password:'',name:'',phone:'',address:''};
    $scope.signUp = function (customer) {
      /*  Data.post('signUp', {
            customer: customer
        }).then(function (results) {
          results.status="success";
            if (results.status == "success") {
                  Data.toast(results);
                $location.path('dashboard');
            }
        });*/

        if (customer.email == "admin"&&customer.password == "admin") {
                  Data.toast(results);
                $location.path('dashboard');
            }
         
    };
    $scope.logout = function () {
        Data.get('logout').then(function (results) {
            Data.toast(results);
            $location.path('login');
        });
    };
});