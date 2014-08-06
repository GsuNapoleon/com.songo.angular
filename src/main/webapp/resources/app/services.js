/**
 * 
 */
'use strict';
var projectServices = angular.module('projectServices', [ 'ngResource' ]);
projectServices.factory('ConsumerService', [ '$resource', function($resource) {
	return $resource('consumer/:id/:currentPage/:operate', {id:'@id', currentPage:'@currentPage', operate:'@operate'}, { 
    	'get': 		{method:'GET'},
    	'query':  	{method:'GET', isArray:true},
    	'pagination':{method:'GET'},
    	'postAdd': 	{method:'POST'},
    	'postUpdate': 	{method:'PUT'},
    	'postRemove': 	{method:'DELETE'},
    	'postFindById': {method:'GET'}
	});
} ]);