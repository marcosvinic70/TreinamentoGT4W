(function() {

	'use strict';
	angular
		.module('appModule')
		.controller('EditarPerfisController', function($scope,$routeParams,$location,perfisService) {

			perfisService.buscarPerfil($routeParams.id).success(function(result){
				$scope.perfilEditado = result;

			});

			$scope.salvarPerfilEditado = function() {
				perfisService.salvarPerfil($routeParams.id,document.getElementsByName("nome")[0].value);
				$location.path('/perfis');
			};
	});
}());