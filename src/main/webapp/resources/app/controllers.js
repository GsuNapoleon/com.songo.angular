/**
 * 
 */
'use strict';
var projectControllers = angular.module('projectControllers', []);
projectControllers.controller('ConsumerListCtrl', ['$scope', '$rootScope',
   		'$routeParams', '$location', 'ConsumerService',function($scope, $rootScope,
		$routeParams, $location, ConsumerService) {
	var failure = function(error) {
		console.log(error);
		console.log("Failure");
		// notifier.error(error.data.message);
		$location.path('/main');
	};
	var consumerPlans = ConsumerService.query(null, function (){
		$scope.consumerPlans = consumerPlans;
	}, failure);
}]);
projectControllers.controller('ConsumerEditCtrl', [ '$scope', '$rootScope',
		'$routeParams', '$location', 'ConsumerService',
		function($scope, $rootScope, $routeParams, $location, ConsumerService) {
			$scope.$on('$includeContentLoaded', function() {
				$('#payDate').datetimepicker({
					pickTime : false,
					language : 'zh-cn',
					orientation : 'left'
				});
			});
			
			/** définition d'handler. */
			var success = function(data) {
				// $rootScope.$broadcast('photosChange', {id: photo.id,
				// categoryId: categoryId});
				console.log(data);
				console.log("Successfully");
				$location.path('/menu/consumer/plan');
			};

			var failure = function(error) {
				console.log(error);
				console.log("Failure");
				// notifier.error(error.data.message);
				$location.path('/menu/consumer/plan');
			};
			$scope.save = function() {
				ConsumerService.postAdd($scope.consumerPlan, success, failure);
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
		isLeaf : false,
		submenus : [ {
			name : '工资管理',
			isLeaf : true,
			url : 'commons.html'
		}, {
			name : '私单管理',
			isLeaf : true,
			url : 'commons.html'
		}, {
			name : '理财管理',
			isLeaf : true,
			url : 'commons.html'
		}, {
			name : '其它管理',
			isLeaf : true,
			url : 'commons.html'
		} ]
	}, {
		name : '支出管理',
		isLeaf : false,
		submenus : [ {
			name : '常用支出管理',
			isLeaf : true,
			url : 'commons.html'
		}, {
			name : '临时支出管理',
			isLeaf : true,
			url : 'commons.html'
		}, {
			name : '支出汇总管理',
			isLeaf : true,
			url : 'commons.html'
		} ]
	} ];
	// $scope.menu = $scope.menus[0];
});
projectControllers.controller('MainKindsController', function($scope) {
	
});