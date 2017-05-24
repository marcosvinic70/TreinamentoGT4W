(function() {

	'use strict';

	angular
		.module('appModule')
		.service('editarCargosService', function(request) {
			this.buscarCargo = function(id) {
				return request.post('editarCargo/'+id);
			};

			this.salvarCargo = function(id,nomeEdicao) {
				return request.post('gravarCargo/'+id + '/' + nomeEdicao);
			};
	});

})();