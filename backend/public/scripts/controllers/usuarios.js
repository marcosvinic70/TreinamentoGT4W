(function() {

	'use strict';

	angular
		.module('appModule')
		.controller('UsuariosController', [ '$scope', 'usuariosService' , function($scope, usuariosService) {

			usuariosService.usuarios(function(result){
			    $scope.listaUsuarios = result;
			});
				
		}]);
	

}());