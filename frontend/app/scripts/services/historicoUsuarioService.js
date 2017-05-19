(function() {

	'use strict';

	angular
		.module('appModule')
		.service('historicoUsuariosService', function(request) {

			this.historicoUsuarios = function() {

				return request.get('historicoUsuarios');

			};
	});

})();