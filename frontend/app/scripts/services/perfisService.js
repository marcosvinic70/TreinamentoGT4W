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
			this.validacao = function()
			{
				return request.get('validacao');
			};
	});

})();