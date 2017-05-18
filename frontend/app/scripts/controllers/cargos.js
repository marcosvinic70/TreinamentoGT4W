(function() {

	'use strict';

	angular
		.module('appModule')
		.controller('CargosController', function($scope,$location, cargosService) {

			cargosService.cargos().success(function(result){
				$scope.listaCargos = result;
				//$scope.erro = null;
			});

			$scope.ModalRemover = function(id){
				$scope.idRemocao = id;
				$('#modal').modal('show');
			};

			$scope.RemoverCargo = function(){
				cargosService.removerCargo($scope.idRemocao);
				$scope.inicio();
				$('#modal').modal('hide');
			};

			$scope.inicio = function(){
					cargosService.cargos().success(function(result){
				    $scope.listaCargos = result;
				    $location.path('/cargos');
				});
			};

			//$scope.erro = function(){
			//	if($scope.erro != null)
			//	{
			//		alert($scope.erro);
			//	}
			//}
		});
}());