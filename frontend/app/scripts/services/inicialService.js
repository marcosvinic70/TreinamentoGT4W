(function() {

	'use strict';

	angular
		.module('appModule')
		.service('inicialService', function(request) {

			this.teste = function() {

				return request.get("/teste");
			};

	});

})();