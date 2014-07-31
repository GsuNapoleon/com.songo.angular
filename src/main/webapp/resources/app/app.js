/**
 * 
 */
'use strict';
var projectApp = angular.module('angular', [ 'ngRoute', 'ngResource',
		'projectControllers', 'projectServices' ]);
projectApp.config([ '$routeProvider', '$locationProvider',
		function($routeProvider, $locationProvider) {
			$locationProvider.hashPrefix('!');
			$routeProvider.when('/consumer-plans.html', {
				templateUrl : 'app/consume/consumer_plan.html',
				controller : 'ConsumerListCtrl'
			}).when('/pre/add/consumer/plan', {
				templateUrl : 'app/consume/add_consumer_plan.html',
				controller : 'ConsumerEditCtrl'
			}).otherwise({
				templateUrl : 'app/main.html',
				controller : 'WelcomeCtrl'
			});
		} ]);
