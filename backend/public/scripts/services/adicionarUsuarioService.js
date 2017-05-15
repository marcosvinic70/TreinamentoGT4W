
(function() {

	'use strict';

	angular
		.module('appModule')
		.service('adicionarUsuarioService', function(request) {

			this.adicionarUsuario = function() {

				return request.get("/adicionarUsuario");
			};

	});

})();