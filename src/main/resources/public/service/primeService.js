(function() {
	
	angular
		.module('primeApp')
		.service('primeService', primeService);
		
	primeService.$inject = ['$http'];
	
	function primeService($http) {
		
		var primeUrl = 'http://localhost:8080/findPrimes';
		
		var service = {
			findPrimes: findPrimes
		};
		return service;
		
		
		function findPrimes(inputNum) {
			
			var dataToSend = {"inputVal": inputNum};
			
			return $http.post(primeUrl, dataToSend)
				.then(function success(response) {
					return response.data;
				}, function error(response) {
					return response.error;
				});
		}
		
	}
	
	
})();