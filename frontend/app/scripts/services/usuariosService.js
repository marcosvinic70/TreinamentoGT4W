
(function() {

	'use strict';

	angular
		.module('appModule')
		.service('usuariosService', function(request) {

			this.usuarios = function() {
				return request.get('usuarios');
			};

			this.removerUsuario = function(id){
				request.post('removerUsuario/'+id);
			};

			this.carregarCargos = function() {
				return request.get('cargos');
			};

			this.carregarPerfis = function() {
				return request.get('perfis');
			};

			this.buscarUsuario = function(id) {
				return request.post('editarUsuario/'+id);
			};

			this.gravarAlteracoes = function(id) {
				return request.post('cadastrarUsuario/'+id);
			};
		});
})();