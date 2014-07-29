/**
 * 
 */
var projectApp = angular.module('angular', [ 'ngRoute', 'ngResource' ]);
projectApp.config([ '$routeProvider', '$locationProvider',
		function($routeProvider, $locationProvider) {
			$locationProvider.hashPrefix('!');
			console.error(window.location);
			$routeProvider.when('/menu/consumer/plan', {
				templateUrl : 'menu/consumer/plan',
				controller: 'ConsumerListCtrl'	
			}).otherwise({
				templateUrl : 'main',
				controller: 'WelcomeCtrl'	
			});
		} ]);
projectApp.controller('ConsumerListCtrl', function($scope) {});
projectApp.controller('WelcomeCtrl', function($scope) {});
projectApp.controller('MenuController', function($scope) {
	$scope.menus = [ {
		name : '消费总览',
		isLeaf : true,
		url : 'main'
	}, {
		name : '消费计划',
		isLeaf : true,
		url : 'menu/consumer/plan'
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
projectApp.controller('MainKindsController', function($scope) {
	$scope.url = 'main';
	$scope.nodeOnclick = function(menu) {
		$scope.url = menu.url;
	};
	$scope.newAdd = function(url) {
		$scope.url = url;
		$scope.$on('$includeContentLoaded', function() {
			$('#payDate').datetimepicker({
				pickTime : false,
				language : 'zh-cn',
				orientation : 'left'
			});
		});
	};
});