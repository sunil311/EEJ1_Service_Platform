app.factory("RegisterProvider", [ '$http', function($http, toaster) {
	// This service connects to our REST API
	var serviceBase = 'http://localhost:8080/206e789b-07c0-470f-ae77-88555f080565/';

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