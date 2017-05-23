(function() {

	'use strict';

	angular
		.module('appModule')
		.service('editarUsuarioService', function(request) {

			this.carregarCargos = function() {

				return request.get('cargos');

			};

			this.carregarPerfis = function() {

				return request.get('perfis');

			};

			this.buscarUsuario = function() {

				return request.get('buscarUsuarioParaEditar');

			};

			this.gravarAlteracoes = function(id) {

				return request.post('cadastrarUsuario/'+id);

			};
		});

})();