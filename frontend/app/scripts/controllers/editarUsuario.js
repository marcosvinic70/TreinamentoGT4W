(function() {

	'use strict';

	angular
		.module('appModule')
		.controller('EditarUsuariosController', function($scope,editarUsuarioService) {

			$scope.formulario = {};

			editarUsuarioService.buscarUsuario().success(function(result){
				$scope.usuario = result;
			});

			editarUsuarioService.carregarCargos().success(function(result){
				$scope.listaCargos = result;
			});

			editarUsuarioService.carregarPerfis().success(function(result){
				$scope.listaPerfis = result;
			});

			$scope.editarUsuario = function() {
				$scope.formulario.array = [];
				angular.forEach($scope.formulario.perfisModelo, function(elemento) {
					$scope.formulario.array.push(elemento);
				});

				editarUsuarioService.gravarAlteracoes($scope.formulario,$scope.usuario.id);
		};
	});
}());