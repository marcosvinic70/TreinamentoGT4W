(function() {

	'use strict';

	angular
		.module('appModule')
		.controller('HistoricoUsuariosController', function($scope,$location, historicoUsuariosService) {


			historicoUsuariosService.historicoUsuarios().success(function(result){
			    $scope.listaHistoricoUsuarios = result;

			});
		});
}());