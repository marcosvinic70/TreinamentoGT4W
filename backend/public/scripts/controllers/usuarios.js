(function() {

	'use strict';

	angular
		.module('appModule')
		.controller('UsuariosController', function($scope, $location,$window, usuariosService, DTOptionsBuilder) {


			usuariosService.usuarios().success(function(result){
			    $scope.listaUsuarios = result;
			});

			$scope.ModalRemover = function(id){
				$scope.idRemocao = id;
				$('#modal').modal('show');
			};

			$scope.ModalVisualizar = function(id) {
				var contador = 0;
				var i = 0;
				angular.forEach($scope.listaUsuarios, function(elemento) {
					if(elemento.id == id) {contador = i;}
					i++;
				});

				$scope.usuarioVisualizar = $scope.listaUsuarios[contador];
				$('#modalVisualizar').modal('show');
			};

			$scope.RemoverUsuario = function(){
				usuariosService.removerUsuario($scope.idRemocao).success(function(result){
					$scope.message = result;
					alert($scope.message);
					$window.location.reload();
				});
			};

		});
}());