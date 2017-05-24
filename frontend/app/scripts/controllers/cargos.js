(function() {

	'use strict';

	angular
		.module('appModule')
		.controller('CargosController', function($scope,$location, cargosService) {

			cargosService.cargos().success(function(result){
				$scope.listaCargos = result;
			});

			$scope.ModalRemover = function(id){
				$scope.idRemocao = id;
				$('#modal').modal('show');
			};

			$scope.RemoverCargo = function(){
				cargosService.removerCargo($scope.idRemocao).success(function(result){
					$scope.message = result;
					alert($scope.message);
				});
				$scope.inicio();
				$('#modal').modal('hide');
			};

			$scope.editarCargo = function(id){
				$scope.idEdicao = id;
				$scope.nomeEdicao = cargosService.cargoEditado($scope.idEdicao);
				alert($scope.nomeEdicao.nome);
				$location.path('/editarCargo');
			};

			$scope.inicio = function(){
					cargosService.cargos().success(function(result){
				    $scope.listaCargos = result;
				    $location.path('/cargos');
				});
			};
		});
}());