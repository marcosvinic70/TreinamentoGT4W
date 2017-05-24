(function() {

	'use strict';
	angular
		.module('appModule')
		.controller('EditarCargosController', function($scope,$routeParams,$location,cargosService) {

			cargosService.buscarCargo($routeParams.id).success(function(result){
				$scope.cargoEditado = result;

			});

			$scope.salvarCargoEditado = function() {
				cargosService.salvarCargo($routeParams.id, $scope.nomeCargo).success(function(result){
					$scope.message = result;
					alert($scope.message);
			});

				$location.path('/cargos');
			};
	});
}());