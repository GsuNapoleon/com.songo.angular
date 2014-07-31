/**
 * 
 */
'use strict';
var projectServices = angular.module('projectServices', [ 'ngResource' ]);
projectServices.factory('ConsumerService', [ '$resource', function($resource) {
	return $resource('consumer/:id', {id:'@id'}, { 
    	'get': 		{method:'GET'},
    	'postAdd': 	{method:'POST'},
    	'update': 	{method:'PUT'},
    	'query':  	{method:'GET', isArray:true},
    	'remove': 	{method:'DELETE'}
	});
} ]);