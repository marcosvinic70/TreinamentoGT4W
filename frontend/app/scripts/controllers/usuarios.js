(function() {

	'use strict';

	angular
		.module('appModule')
		.controller('UsuariosController', function($scope, $location, usuariosService, DTOptionsBuilder) {


			usuariosService.usuarios().success(function(result){
			    $scope.listaUsuarios = result;
			});

			$scope.ModalRemover = function(id){
				$scope.idRemocao = id;
				$('#modal').modal('show');
			};

			$scope.ModalVisualizar = function(id) {
				var contador = 0;
				var i = 0;
				angular.forEach($scope.listaUsuarios, function(elemento) {
					if(elemento.id == id) {contador = i;}
					i++;
				});

				$scope.usuarioVisualizar = $scope.listaUsuarios[contador];
				$('#modalVisualizar').modal('show');
			};

			$scope.RemoverUsuario = function(){
				usuariosService.removerUsuario($scope.idRemocao).success(function(result){
					$scope.message = result;
					alert($scope.message);
				});
				$('#modal').modal('hide');
			};

			var vm = this;
		    vm.dtOptions = DTOptionsBuilder.fromSource('data.json')
		        .withLanguage(
				{
				    "sEmptyTable": "Nenhum registro encontrado",
				    "sInfo": "Mostrando de _START_ até _END_ de _TOTAL_ registros",
				    "sInfoEmpty": "Mostrando 0 até 0 de 0 registros",
				    "sInfoFiltered": "(Filtrados de _MAX_ registros)",
				    "sInfoPostFix": "",
				    "sInfoThousands": ".",
				    "sLengthMenu": "_MENU_ resultados por página",
				    "sLoadingRecords": "Carregando...",
				    "sProcessing": "Processando...",
				    "sZeroRecords": "Nenhum registro encontrado",
				    "sSearch": "Pesquisar",
				    "oPaginate": {
				        "sNext": "Próximo",
				        "sPrevious": "Anterior",
				        "sFirst": "Primeiro",
				        "sLast": "Último"
				    },
				    "oAria": {
				        "sSortAscending": ": Ordenar colunas de forma ascendente",
				        "sSortDescending": ": Ordenar colunas de forma descendente"
				    }
		        });

		});
}());