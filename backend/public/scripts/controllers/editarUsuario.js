(function() {

	'use strict';
	angular
		.module('appModule')
		.controller('EditarUsuariosController', function($scope,$location,$routeParams) {

			$scope.formulario = {};
			usuariosService.buscarUsuario($routeParams.id).success(function(result){
				$scope.usuario = result;
				$scope.formulario = $scope.usuario;
				$scope.formulario.cargo = $scope.usuario.cargo.nome;

			});

			usuariosService.carregarCargos().success(function(result){
				$scope.listaCargos = result;
			});

			usuariosService.carregarPerfis().success(function(result){
				$scope.listaPerfis = result;

			});

			$scope.editarUsuario = function() {
				$scope.formulario.array = [];
				angular.forEach($scope.formulario.perfisModelo, function(elemento) {
					$scope.formulario.array.push(elemento);
				});
				usuariosService.gravarAlteracoes($routeParams.id,$scope.formulario).success(function(result){
					$scope.message = result;
					alert($scope.message);
				});

				$location.path('/usuarios');
			};
	});
}());