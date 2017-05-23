(function() {

	'use strict';

	angular
		.module('appModule')
		.controller('PerfisController', function($scope,$location, perfisService) {

			perfisService.perfis().success(function(result){
				$scope.listaPerfis = result;
			});

			$scope.ModalRemover = function(id){
				$scope.idRemocao = id;
				$('#modal').modal('show');
			};

			$scope.RemoverPerfil = function(){
				perfisService.removerPerfil($scope.idRemocao,function(response){
					Mensagem.exibir(response.text, 'success');
                    $location.path('/perfis');
                },
	                function(error) {
	                    Mensagem.exibir(error, 'error');
	                }
                );
			
				//$scope.validacao();
				$scope.inicio();
				$('#modal').modal('hide');
			};


			$scope.inicio = function(){
					perfisService.perfis().success(function(result){
				    $scope.listaPerfis = result;
				    $location.path('/perfis');
				});
			};



			/*$scope.validacao = function(){

				perfisService.validacao().success(function(result){//result chegando NULL por motivos inimaginaveis
					$scope.mensagemDeValidacao = result;
					if($scope.mensagemDeValidacao.mensagemErro !== null)
						alert('$scope.mensagemDeValidacao.mensagemErro');
					
					else if($scope.mensagemDeValidacao.mensagemSucesso !== null)
						alert('$scope.mensagemDeValidacao.mensagemSucesso');
					
					
				});
				return;
			};*/
		});
}());