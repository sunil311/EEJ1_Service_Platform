app.factory("Data", [ '$http', function($http, toaster) {
	// This service connects to our REST API
	var serviceBase = 'resources/config.properties';

	var obj = {};
	
	obj.get = function(q) {
		return $http.get(serviceBase + q).then(function(results) {
			return results.data;
		});
	};
	obj.post = function(q, object) {
		return $http.post(serviceBase + q, object).then(function(results) {
			return results.data;
		});
	};
	obj.put = function(q, object) {
		return $http.put(serviceBase + q, object).then(function(results) {
			return results.data;
		});
	};
	return obj;
} ]);