(function() {

	'use strict';

	angular
		.module('appModule')
		.controller('PerfisController', function($scope, perfisService) {

			perfisService.perfis().success(function(){

			});

		});
}());