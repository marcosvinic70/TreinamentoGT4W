(function() {

	'use strict';

	angular
		.module('appModule')
		.controller('AdicionarUsuarioController', function($scope, adicionarUsuarioService) {

			adiconarUsuarioService.adicionarUsuario().success(function(){

			});

		});
}());