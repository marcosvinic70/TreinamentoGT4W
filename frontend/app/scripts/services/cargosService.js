
(function() {

	'use strict';

	angular
		.module('appModule')
		.service('cargosService', function(request) {

			this.cargos = function() {

				return request.get("/cargos");
			};

	});

})();