(function() {

	'use strict';
	angular
		.module('appModule')
		.controller('EditarCargosController', function($scope,$routeParams,$location,editarCargosService) {

			editarCargosService.buscarCargo($routeParams.id).success(function(result){
				$scope.cargoEditado = result;

			});

			$scope.salvarCargoEditado = function() {
				editarCargosService.salvarCargo($routeParams.id, $scope.nomeCargo);
				$location.path('/cargos');
			};
	});
}());