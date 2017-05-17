(function() {

	'use strict';

	angular
		.module('appModule')
		.controller('UsuariosController', function($scope, usuariosService) {

			usuariosService.usuarios().success(function(result){
			    $scope.listaUsuarios = result;
			});
				
			$scope.ModalRemover = function(){

				$('#modal').modal('show');

			};

			$scope.RemoverUsuario = function(id){

				usuariosService.removerUsuario(id);
 				
			};
		});
	

}());