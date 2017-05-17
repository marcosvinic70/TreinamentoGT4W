(function() {

	'use strict';

	angular
		.module('appModule')
		.controller('InicialController', function($scope, inicialService) {

<<<<<<< HEAD
			inicialService.inicial().success(function(result){
=======
			inicialService.inicial().success(function(){
>>>>>>> 1e47aa4836e1c87adb9f185b157788be3319b1d1
					$scope.retornoBackend = result;
			});

		});
}());