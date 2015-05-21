/**
 * 
 */
'use strict';
var projectServices = angular.module('projectServices', [ 'ngResource' ]);
projectServices.factory('ConsumerService', [ '$resource', function($resource) {
	return $resource('consumer/:id/:currentPage/:searchContent/:operate', 
			{id:'@id', currentPage:'@currentPage', searchContent:'@searchContent', operate:'@operate'}, { 
    	'get': 			{method:'GET'},
    	'query':  		{method:'GET', isArray:true},
    	'pagination':	{method:'GET'},
    	'postAdd': 		{method:'POST'},
    	'postUpdate': 	{method:'PUT'},
    	'postRemove': 	{method:'DELETE'},
    	'postFindById': {method:'GET'}
	});
} ]);
projectServices.factory('IncomeService', [ '$resource', function($resource) {
	return $resource('income/:id/:currentPage/:searchContent/:operate', 
		{id:'@id', currentPage:'@currentPage', searchContent:'@searchContent', operate:'@operate'}, { 
			'get': 			{method:'GET'},
			'query':  		{method:'GET', isArray:true},
			'pagination':	{method:'GET'},
			'postAdd': 		{method:'POST'},
			'postUpdate': 	{method:'PUT'},
			'postRemove': 	{method:'DELETE'},
			'postFindById': {method:'GET'}
		});
} ]);
projectServices.factory('SearchService', [ '$resource', function($resource) {
	return $resource('search/:keywords/:btnK/:operate', 
		{keywords:'@keywords', btnK:'@btnK', operate:'@operate'}, { 
			'query':{method:'GET'},
		});
} ]);
