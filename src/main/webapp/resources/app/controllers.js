/**
 * 
 */
'use strict';
var projectControllers = angular.module('projectControllers',
		[ 'ui.bootstrap' ]);
projectControllers.controller('ConsumerListCtrl', [
		'$scope',
		'$rootScope',
		'$route',
		'$routeParams',
		'$location',
		'ConsumerService',
		function($scope, $rootScope, $route, $routeParams, $location,
				ConsumerService) {
			var failure = function(error) {
				console.log(error);
				console.log("Failure");
				// notifier.error(error.data.message);
				$location.path('/consumer-plans.html');
			};
			var success = function(data) {
				// $rootScope.$broadcast('photosChange', {id: photo.id,
				// categoryId: categoryId});
				console.log(data);
				console.log("Successfully");
				$location.path('/consumer-plans.html');
				$route.reload();
			};

			$scope.maxSize = 5;
			$scope.bigTotalItems = 0;
			$scope.bigCurrentPage = 1;
			$scope.searchContent = "default";
			$scope.$watch("bigCurrentPage", function(newValue, oldValue) {
				doPaging(newValue, $scope.searchContent);
			});
			$scope.search = function() {
				doPaging(1, $scope.searchContent);
			};
			function doPaging(currentPage, searchContent) {
				var paginations = ConsumerService.pagination({
					currentPage : currentPage,
					searchContent : searchContent,
					operate : 'pagination'
				}, function() {
					$scope.consumerPlans = paginations.results;
					$scope.bigTotalItems = paginations.totalRecords;
					$scope.totalPages = paginations.totalPages;
					$scope.itemsPerPage = paginations.pageSize;
				}, failure);
			}
			$scope.remove = function(id) {
				if (!id) {
					throw {
						name : "Error",
						message : "Delete this ConsumerPlan is not possible"
					};
				}
				ConsumerService.postRemove({
					id : id
				}, success);
			};
			$scope.isInvalid = function(field) {
				return $scope.ConsumerPlanForm[field].$invalid
						&& $scope.ConsumerPlanForm[field].$dirty;
			};

			$scope.isValid = function(field) {
				return $scope.ConsumerPlanForm[field].$valid
						&& $scope.ConsumerPlanForm[field].$dirty;
			};
			// var consumerPlans = ConsumerService.query(null, function (){
			// $scope.consumerPlans = consumerPlans;
			// }, failure);
		} ]);
projectControllers.controller('ConsumerEditCtrl', [
		'$scope',
		'$rootScope',
		'$routeParams',
		'$location',
		'ConsumerService',
		function($scope, $rootScope, $routeParams, $location, ConsumerService) {
			$scope.$on('$viewContentLoaded', function() {

			});

			var id = $routeParams.id;
			$scope.$location = $location;
			if (id > 0) {
				$scope.consumerPlan = {
					id : id
				};
				ConsumerService.postFindById({
					id : id,
					operate : 'findById'
				}, function(consumerPlan) {
					$scope.master = consumerPlan;
					$scope.reset();
				}, failure);
			}

			/** définition d'handler. */
			var success = function(data) {
				// $rootScope.$broadcast('photosChange', {id: photo.id,
				// categoryId: categoryId});
				console.log(data);
				console.log("Successfully");
				$location.path('/consumer-plans.html');
			};

			var failure = function(error) {
				console.log(error);
				console.log("Failure");
				// notifier.error(error.data.message);
				$location.path('/consumer-plans.html');
			};
			$scope.save = function() {
				if (id > 0) {
					ConsumerService.postUpdate({
						id : id
					}, $scope.consumerPlan, success, failure);
				} else {
					ConsumerService.postAdd($scope.consumerPlan, success,
							failure);
				}
			};
			$scope.reset = function() {
				$scope.consumerPlan = angular.copy($scope.master);
			};
			$scope.isUnchanged = function() {
				return angular.equals($scope.consumerPlan, $scope.master);
			};
		} ]);
projectControllers.controller('WelcomeCtrl', function($scope) {
});
projectControllers.controller('MenuController', function($scope) {
	$scope.menus = [ {
		name : '消费总览',
		isLeaf : true,
		url : '/main.html'
	}, {
		name : '消费计划',
		isLeaf : true,
		url : '/consumer-plans.html'
	}, {
		name : '收入管理',
		isLeaf : true,
		url : '/income-lists.html'
	}, {
		name : '支出管理',
		isLeaf : true
	}, {
		name : '人员管理',
		isLeaf : true
	}, {
		name : '搜索引擎',
		isLeaf : true,
		url	: '/search.html'
	} ];
	// $scope.menu = $scope.menus[0];
});
projectControllers.controller('MainKindsController', function($scope) {

});