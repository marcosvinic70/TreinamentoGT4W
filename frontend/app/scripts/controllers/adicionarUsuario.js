(function() {

	'use strict';

	angular
		.module('appModule')
		.controller('AdicionarUsuarioController', function($scope, adicionarUsuarioService) {

			$scope.formulario = {};

			adicionarUsuarioService.carregarCargos().success(function(result){
				$scope.listaCargos = result;
			});

			adicionarUsuarioService.carregarPerfis().success(function(result){
				$scope.listaPerfis = result;
			});

			$scope.cadastrarUsuario = function() {
				adicionarUsuarioService.cadastrarUsuario($scope.formulario);
			}

		});
}());