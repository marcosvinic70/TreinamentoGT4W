(function() {

	'use strict';

	angular
		.module('appModule')
		.service('inicialService', function(request) {

			this.inicial = function() {

				return request.get("");
			};

	});

})();
