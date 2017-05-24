(function() {

	'use strict';

	angular
		.module('appModule')
		.service('perfisService', function(request) {

			this.perfis = function() {

				return request.get("perfis");
			};
			this.removerPerfil = function(id){
				return request.post('removerPerfil/'+id);
			};

			this.buscarPerfil = function(id) {
				return request.post('editarPerfil/'+id);
			};

			this.salvarPerfil = function(id,nomeEdicao) {
				return request.post('gravarPerfil/'+id + '/' + nomeEdicao);
			};
	});

})();