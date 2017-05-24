(function() {

	'use strict';

	angular
		.module('appModule')
		.controller('CargosController', function($scope,$location,$window,cargosService) {

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
					$window.location.reload();
				});
			};
		});
}());