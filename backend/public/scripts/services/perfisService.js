(function() {

	'use strict';

	angular
		.module('appModule')
		.service('perfisService', function(request) {

			this.perfis = function() {

				return request.get("/perfis");
			};

	});

})();