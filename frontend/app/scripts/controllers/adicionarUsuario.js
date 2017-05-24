(function() {

	'use strict';

	angular
		.module('appModule')
		.controller('AdicionarUsuarioController', function($scope,$location, usuariosService) {

			$scope.formulario = {};

			usuariosService.carregarCargos().success(function(result){
				$scope.listaCargos = result;
			});

			usuariosService.carregarPerfis().success(function(result){
				$scope.listaPerfis = result;
			});

			$scope.cadastrarUsuario = function() {
				$scope.formulario.array = [];
				angular.forEach($scope.formulario.perfisModelo, function(elemento) {
					$scope.formulario.array.push(elemento);
				});

				usuariosService.gravarAlteracoes(0,$scope.formulario).success(function(result){
					$scope.message = result;
					alert($scope.message);
				});

				$location.path('/usuarios');


			};

		});
}());