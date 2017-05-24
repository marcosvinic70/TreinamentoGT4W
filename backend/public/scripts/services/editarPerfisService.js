(function() {

	'use strict';

	angular
		.module('appModule')
		.service('editarPerfisService', function(request) {
			this.buscarPerfil = function(id) {
				return request.post('editarPerfil/'+id);
			};

			this.salvarPerfil = function(id,nomeEdicao) {
				return request.post('gravarPerfil/'+id + '/' + nomeEdicao);
			};
	});

})();