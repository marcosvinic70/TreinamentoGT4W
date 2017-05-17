
(function() {

	var modulo = angular.module('appModule', ['ngRoute', 'ui.bootstrap']);

	modulo.config(['$routeProvider',

		function($routeProvider){

			$routeProvider
				.when("/usuarios", {
					templateUrl: 'views/sections/usuarios.html',
					controller: 'UsuariosController',
				})
                .when("/cargos", {
                    templateUrl: 'views/sections/cargos.html',
                    controller: 'CargosController',
                })
                .when("/perfis", {
                    templateUrl: 'views/sections/perfis.html',
                    controller: 'PerfisController',
                })
                .when("/adicionarUsuario", {
                    templateUrl: 'views/sections/adicionarUsuario.html',
                    controller: 'AdicionarUsuarioController',
                })
                .when("/modal", {
                    templateUrl: 'views/sections/usuarios.html',
                    controller: 'UsuariosController',
                })
				.otherwise({
					redirectTo: '/',
					templateUrl: 'views/sections/inicial.html',
					controller: 'InicialController'
				});
				
		}

	])


	.controller('AppCtrl', ["$scope", "$rootScope",
		function() {


		}

	]);

})(jQuery);