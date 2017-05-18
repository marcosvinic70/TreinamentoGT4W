
(function() {

	'use strict';

	angular
		.module('appModule')
		.service('usuariosService', function(request) {

			this.usuarios = function() {

				return request.get('usuarios');

			};
			this.removerUsuario = function(id){
				request.post('removerUsuario/'+id);
			};

	});

})();