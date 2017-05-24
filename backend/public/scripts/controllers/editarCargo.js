(function() {

	'use strict';
	angular
		.module('appModule')
		.controller('EditarCargosController', function($scope,$routeParams,editarCargoService) {

			editarCargoService.buscarUsuario($routeParams.id).success(function(result){
				$scope.cargoEditado = result;

			});

			/*$scope.editarUsuario = function() {
				$scope.formulario.array = [];
				angular.forEach($scope.formulario.perfisModelo, function(elemento) {
					$scope.formulario.array.push(elemento);
				});
				usuariosService.gravarAlteracoes($routeParams.id,$scope.formulario);
			};*/
	});
}());