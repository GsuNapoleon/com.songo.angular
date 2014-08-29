/**
 * 
 */
'use strict';
projectControllers.controller('IncomeListCtrl', [
		'$scope',
		'$rootScope',
		'$route',
		'$routeParams',
		'$location',
		'IncomeService',
		function($scope, $rootScope, $route, $routeParams, $location,
				IncomeService) {
			var failure = function(error) {
				console.log(error);
				console.log("Failure");
				// notifier.error(error.data.message);
				$location.path('/income-lists.html');
			};
			var success = function(data) {
				// $rootScope.$broadcast('photosChange', {id: photo.id,
				// categoryId: categoryId});
				console.log(data);
				console.log("Successfully");
				$location.path('/income-lists.html');
				$route.reload();
			};

			$scope.maxSize = 5;
			$scope.bigTotalItems = 0;
			$scope.bigCurrentPage = 1;
			$scope.searchContent = "default";
			
		} ]);