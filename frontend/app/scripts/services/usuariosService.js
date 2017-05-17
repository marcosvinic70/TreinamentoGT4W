
(function() {

	'use strict';

	angular
		.module('appModule')
		.service('usuariosService', function(request) {

			this.usuarios = function() {

				request.get('/usuarios');
			};


	});

})();