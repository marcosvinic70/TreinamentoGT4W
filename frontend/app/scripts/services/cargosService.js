
(function() {

	'use strict';

	angular
		.module('appModule')
		.service('cargosService', function(request) {

			this.cargos = function() {

				return request.get("cargos");
			};

			this.removerCargo = function(id){
				return request.post('removerCargo/'+id);
			};

			this.cargoEditado = function(id) {
				return request.get('cargoParaEditar',id);
			};
	});

})();