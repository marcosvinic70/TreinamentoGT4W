(function() {

	'use strict';

	angular
		.module('appModule')
		.service('inicialService', function(request) {

<<<<<<< HEAD
			this.incial = function() {

				return request.get("/index");
=======
			this.inicial = function() {

				return request.get("");
>>>>>>> 1e47aa4836e1c87adb9f185b157788be3319b1d1
			};

	});

})();
