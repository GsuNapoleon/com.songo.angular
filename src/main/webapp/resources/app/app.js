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
			}).when('/edit-consumer-plan.html', {
				templateUrl : 'app/consume/edit_consumer_plan.html',
				controller : 'ConsumerEditCtrl'
			}).when('/edit-consumer-plan.html/:id', {
				templateUrl : 'app/consume/edit_consumer_plan.html',
				controller : 'ConsumerEditCtrl'
			}).when('/income-lists.html', {
				templateUrl : 'app/income/incomes.html',
				controller : 'IncomeListCtrl'
			}).when('/edit-income.html', {
				templateUrl : 'app/income/edit_income.html',
				controller : 'IncomeListCtrl'
			}).when('/edit-income.html/:id', {
				templateUrl : 'app/income/edit_income.html',
				controller : 'IncomeListCtrl'
			}).when('/search.html', {
				templateUrl : 'app/search/search.html',
				controller : 'SearchCtrl'
			}).otherwise({
				templateUrl : 'app/main.html',
				controller : 'WelcomeCtrl'
			});
		} ]);
