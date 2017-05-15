(function() {

	'use strict';

	angular
		.module('appModule')
		.controller('CargosController', function($scope, cargosService) {

			cargosService.cargos().success(function(){

			});

		});
}());