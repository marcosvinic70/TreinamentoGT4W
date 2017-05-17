(function() {

	'use strict';

	angular
		.module('appModule')
		.controller('InicialController', function($scope, inicialService) {

			inicialService.inicial().success(function(result){
					$scope.retornoBackend = result;
			});

		});
}());