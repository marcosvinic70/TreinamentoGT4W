(function() {

	'use strict';

	angular
		.module('appModule')
		.controller('InicialController', function($scope, inicialService) {

			inicialService.teste().success(function(result){
					$scope.retornoBackend = result;
			});

		});
}());