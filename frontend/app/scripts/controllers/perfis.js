(function() {

	'use strict';

	angular
		.module('appModule')
		.controller('PerfisController', function($scope,$location,$window, perfisService) {

			perfisService.perfis().success(function(result){
				$scope.listaPerfis = result;
			});

			$scope.ModalRemover = function(id){
				$scope.idRemocao = id;
				$('#modal').modal('show');
			};

			$scope.RemoverPerfil = function(){
				perfisService.removerPerfil($scope.idRemocao).success(function(result){
					$scope.message = result;
					alert($scope.message);
					$window.location.reload();
				});
			};
		});
}());