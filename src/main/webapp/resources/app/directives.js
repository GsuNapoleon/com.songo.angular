/**
 * 
 */
'use strict';
var projectDirectives = angular.module('projectDirectives', []);
projectDirectives.filter('', function () {
	return {
		restrict: 'A',
		require: '?ngModel',
		link: function (scope, element, attrs) {
			
		}
	};
});