(function() {

	'use strict';

	angular
		.module('appModule')
		.service('editarCargoService', function(request) {
			this.nome = function() {
				return request.get("/nomecargo");
			};

	});

})();