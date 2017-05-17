(function() {

	'use strict';

	angular
		.module('appModule')
		.service('inicialService', function(request) {

			this.incial = function() {

				return request.get("/index");
			};

	});

})();
