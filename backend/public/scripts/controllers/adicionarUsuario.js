(function() {

	'use strict';

	angular
		.module('appModule')
		.controller('AdicionarUsuarioController', function($scope,$location, adicionarUsuarioService,usuariosService) {

			$scope.formulario = {};

			adicionarUsuarioService.carregarCargos().success(function(result){
				$scope.listaCargos = result;
			});

			adicionarUsuarioService.carregarPerfis().success(function(result){
				$scope.listaPerfis = result;
			});

			$scope.cadastrarUsuario = function() {
				$scope.formulario.array = [];
				angular.forEach($scope.formulario.perfisModelo, function(elemento) {
					$scope.formulario.array.push(elemento);
				});

				adicionarUsuarioService.cadastrarUsuario($scope.formulario, 0).success(function(result){
					$scope.message = result;
					alert($scope.message);
				});

				$scope.inicio();


			};

			$scope.inicio = function(){
					usuariosService.usuarios().success(function(result){
				    $scope.listaUsuarios = result;
				    $location.path('/usuarios');
				});
			};

		});
}());