(function() {

	'use strict';

	angular
		.module('appModule')
		.controller('AdicionarUsuarioController', function($scope, adicionarUsuarioService) {

			adicionarUsuarioService.adicionarUsuario().success(function(){

			});

		});
}());