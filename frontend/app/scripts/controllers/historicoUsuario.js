(function() {

	'use strict';

	angular
		.module('appModule')
		.controller('HistoricoUsuariosController', function($scope,$location, usuariosService) {


			usuariosService.historicoUsuarios().success(function(result){
			    $scope.listaHistoricoUsuarios = result;

			});
		});
}());