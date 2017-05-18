
(function() {

	'use strict';

	angular
		.module('appModule')
		.service('cargosService', function(request) {

			this.cargos = function() {

				return request.get("cargos");
			};

			this.removerCargo = function(id){
				//passar variavel de erro?? como fazer
				request.post('removerCargo/'+id);
			};
	});

})();