(function() {

	'use strict';

	angular
		.module('appModule')
		.controller('UsuariosController', function($scope,$location, usuariosService) {


			usuariosService.usuarios().success(function(result){
			    $scope.listaUsuarios = result;
			});

			$scope.ModalRemover = function(id){
				$scope.idRemocao = id;
				$('#modal').modal('show');
			};

			$scope.RemoverUsuario = function(){
				usuariosService.removerUsuario($scope.idRemocao);
				$scope.inicio();
				$('#modal').modal('hide');
			};

			$scope.EditarUsuario = function(id){
				$scope.idEdicao = id;
				usuariosService.usuarioEditado($scope.idEdicao);
				$location.path('/editarUsuario');
			};

			$scope.inicio = function(){
					usuariosService.usuarios().success(function(result){
				    $scope.listaUsuarios = result;
				    $location.path('/usuarios');
				});
			};
		});
}());