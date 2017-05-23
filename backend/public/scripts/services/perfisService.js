(function() {

	'use strict';

	angular
		.module('appModule')
		.service('perfisService', function(request) {

			this.perfis = function() {

				return request.get("perfis");
			};
			this.removerPerfil = function(id, successCallback, errorCallback){
				request.post('removerPerfil/'+id,successCallback,errorCallback);
			};
			this.validacao = function()
			{
				return request.get('validacao');
			};
	});

})();