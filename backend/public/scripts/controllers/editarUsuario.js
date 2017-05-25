(function() {

	'use strict';
	angular
		.module('appModule')
		.controller('EditarUsuariosController', function($scope,$location,$routeParams,usuariosService) {

			$scope.formulario = {};
			usuariosService.buscarUsuario($routeParams.id).success(function(result){
				$scope.usuario = result;
				$scope.formulario = $scope.usuario;
				$scope.formulario.cargo = $scope.usuario.cargo.nome;
				$scope.lista = [];
				angular.forEach($scope.usuario.listaPerfil, function(elemento) {
					$scope.lista.push(elemento.nome);
				});

			});

			usuariosService.carregarCargos().success(function(result){
				$scope.listaCargos = result;
			});

			usuariosService.carregarPerfis().success(function(result){
				$scope.listaPerfis = result;
			});

			$scope.editarUsuario = function() {
				$scope.formulario.array = [];
				angular.forEach($scope.listaPerfis, function(elemento) {
					var resposta = document.getElementsByName(elemento.nome);
					if(resposta[0].checked === true) {
						$scope.formulario.array.push(resposta[0].value);
					}
				});

				var respostaNovo = document.getElementsByName("perfilNovo");
				if(respostaNovo[0].checked === true) {
					$scope.formulario.array.push($scope.formulario.perfilNovo);
				}

				usuariosService.gravarAlteracoes($routeParams.id,$scope.formulario).success(function(result){
					$scope.message = result;
					alert($scope.message);
				});

				$location.path('/usuarios');
			};
	});
}());