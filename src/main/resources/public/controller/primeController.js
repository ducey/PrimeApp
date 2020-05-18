(function() {
	'use scrict';
	
	angular
		.module('primeApp')
		.controller('PrimeController', PrimeController);
		
	PrimeController.$inject = ['$scope', 'primeService'];
		
	function PrimeController($scope, primeService) {
		
		$scope.inputVal = null;
		var result = [];
		var counter = 0;
	
		
		$scope.submitForm = function() {
			
			if ($scope.primeForm.$valid) {
				reset();
			
				if($scope.inputVal) {
					
					primeService.findPrimes($scope.inputVal)
						.then(function(returned){
														
							for (var i = 0; i < returned['primes'].length; i++) {
								result.push([returned['primes'][i]]);
							}
							
							$scope.results = result;
							if(!$scope.pageLength) {
								$scope.pageLength = 10;
							}
							$(document).ready( function () {
							    $('#resultsTable').DataTable( {
							        data: $scope.results,
							        paging: true,
							        bFilter: false,
							        lengthMenu: [[Number($scope.pageLength)],[Number($scope.pageLength)]],
							        columns: [
							            { title: "Prime Numbers" }
							            ]
							    } );
							} );
						});				
				}
			} else {
				$scope.errors = "Invalid form input, please check and try again.";
			}
		}
		
		populateGridData = function(index, item) {
			result[count] = item;
			count++;
		}
		
		reset = function() {
			result = [];
			counter = 0;
			$scope.results = null;
			$('#resultsTable').DataTable().destroy();
		}
		
		$scope.clearErrors = function() {
			$scope.errors = null;
		}
	}

})();