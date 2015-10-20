app.controller('authCtrl', function ($scope, $rootScope, $routeParams, $location, $http, Data, $injector) {
    //initially set those objects to null to avoid undefined error
    $scope.login = {};
     var $validationProvider = $injector.get('$validation');
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
    }
    $scope.signup = {email:'',password:'',firstName:'',lastName:''};

    $scope.form = {
                requiredCallback: 'required',
                checkValid: $validationProvider.checkValid,
                submit: function () {
                    // angular validation 1.2 can reduce this procedure, just focus on your action
                    // $validationProvider.validate(form);
                },
                reset: function () {
                    // angular validation 1.2 can reduce this procedure, just focus on your action
                    // $validationProvider.reset(form);
                }
            };
    $scope.signUp = function (user) {
   Data.post('signUp', {
             user
        }).then(function (results) {
          results.status="success";
            if (results.status == "success") {
                  Data.toast(results);
                $location.path('dashboard');
            }
        });

      
         
    };
    $scope.logout = function () {
        Data.get('logout').then(function (results) {
            Data.toast(results);
            $location.path('login');
        });
    }
});