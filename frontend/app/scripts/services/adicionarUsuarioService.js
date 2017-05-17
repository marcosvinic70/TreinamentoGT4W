(function() {

	'use strict';

	angular

		.module('appModule')

		.service('adicionarUsuarioService', function(request) {

			this.carregarCargos = function() {

				return request.get('cargos');

			};

			this.carregarPerfis = function() {

				return request.get('perfis');

			};

			this.cadastrarUsuario = function(formulario) {

				request.post('cadastrarUsuario',formulario);

			};

	});

})();