/**
 * 
 */
'use strict';
projectControllers.controller('SearchCtrl', [
		'$scope',
		'$rootScope',
		'$route',
		'$routeParams',
		'$location',
		'SearchService',
		function($scope, $rootScope, $route, $routeParams, $location,
				SearchService) {
			var failure = function(error) {
				$location.path('/search.html');
			};
			var success = function(data) {
				// $rootScope.$broadcast('photosChange', {id: photo.id,
				// categoryId: categoryId});
				console.log(data);
				console.log("Successfully");
				$location.path('/search.html');
				$route.reload();
			};
			$scope.search = function() {
				SearchService.query({
					keywords : $scope.keywords,
					btnK : "UTF8",
					operate : "search"
				}, function() {
					console.log("查询结果出来了");
				}, failure);
			};
		} ]);