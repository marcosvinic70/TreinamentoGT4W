(function() {

	'use strict';
	angular
		.module('appModule')
		.controller('EditarPerfisController', function($scope,$routeParams,$location,editarPerfisService) {

			editarPerfisService.buscarPerfil($routeParams.id).success(function(result){
				$scope.perfilEditado = result;

			});

			$scope.salvarPerfilEditado = function() {
				editarPerfisService.salvarPerfil($routeParams.id, $scope.nomePerfil);
				$location.path('/perfis');
			};
	});
}());