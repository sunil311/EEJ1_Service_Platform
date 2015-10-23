var app = angular.module('myApp', ['ngRoute', 'ngAnimate','ngResource', 'toaster','validation', 'validation.rule','angularRipple']);

app.config(['$routeProvider','$validationProvider',
  function ($routeProvider,$validationProvider) {
                var defaultMsg, expression;
            /**
             * Setup a default message for Url
             */
            defaultMsg = {
                url: {
                    error: 'This is a error url given by user',
                    success: 'It\'s Url'
                }
            };
            $validationProvider.setDefaultMsg(defaultMsg);
            /**
             * Setup a new Expression and default message
             * In this example, we setup a IP address Expression and default Message
             */
            expression = {
                ip: /^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$/
            };
            defaultMsg = {
                ip: {
                    error: 'This isn\'t ip address',
                    success: 'It\'s ip'
                }
            };
            $validationProvider.setExpression(expression)
                               .setDefaultMsg(defaultMsg);
            // or we can just setup directly
            $validationProvider.setDefaultMsg({ ip: { error: 'This no ip', success: 'this ip'}})
                               .setExpression({ ip: /^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$/ });
            /**
             * Additions validation
             */
            $validationProvider
                .setExpression({
                    huei: function (value, scope, element, attrs) {
                        return value === 'Huei Tan';
                    }
                })
                .setDefaultMsg({
                    huei: {
                        error: 'This should be Huei Tan',
                        success: 'Thanks!'
                    }
                });
            /**
             * Range Validation
             */
            $validationProvider
                .setExpression({
                    range: function (value, scope, element, attrs) {
                        if (value >= parseInt(attrs.min) && value <= parseInt(attrs.max)) {
                            return value;
                        }
                    }
                })
                .setDefaultMsg({
                    range: {
                        error: 'Number should between 5 ~ 10',
                        success: 'good'
                    }
                });
        $routeProvider.
	        when('/login', {
	            title: 'Login',
	            templateUrl: 'partials/login.html',
	            controller: 'authCtrl'
	        })
            .when('/logout', {
                title: 'Logout',
                templateUrl: 'partials/login.html',
                controller: 'logoutCtrl'
            })
            .when('/signup', {
                title: 'Signup',
                templateUrl: 'partials/signup.html',
                controller: 'authCtrl'
            })
            .when('/dashboard', {
                title: 'Dashboard',
                templateUrl: 'partials/dashboard.html',
                controller: 'authCtrl'
            })
            .when('/', {
                title: 'Login',
                templateUrl: 'partials/home-template.html',
                controller: 'authCtrl',
                role: '0'
            })
            .otherwise({
                redirectTo: '/login'
            });
  }])
    .run(function ($rootScope, $location, Data) {
        $rootScope.$on("$routeChangeStart", function (event, next, current) {
            $rootScope.authenticated = false;
           /* Data.get('session').then(function (results) {
                if (results.uid) {
                    $rootScope.authenticated = true;
                    $rootScope.uid = results.uid;
                    $rootScope.name = results.name;
                    $rootScope.email = results.email;
                } else {
                    var nextUrl = next.$$route.originalPath;
                    if (nextUrl == '/signup' || nextUrl == '/login') {

                    } else {
                        $location.path("/login");
                    }
                }
            });*/
        });
    });