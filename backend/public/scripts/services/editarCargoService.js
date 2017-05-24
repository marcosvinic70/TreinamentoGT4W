(function() {

	'use strict';

	angular
		.module('appModule')
		.service('editarCargosService', function(request) {
			this.buscarCargo = function(id) {
				return request.post('buscaEditarCargo/'+id);
			};
	});

})();