
(function() {

	'use strict';

	angular
		.module('appModule')
		.service('usuariosService', function(request) {

			this.usuarios = function() {

<<<<<<< HEAD
				request.get('/usuarios');
=======
				return request.get('usuarios');
>>>>>>> ac9b0650fa4a858093dbf189c1c89d211782f2e2
			};


	});

})();