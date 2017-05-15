
(function() {

	var modulo = angular.module('appModule', ['ngRoute', 'ui.bootstrap']);

	modulo.config(['$routeProvider',

		function($routeProvider){

			$routeProvider
				.when('/', {
					templateUrl: 'views/sections/inicial.html',
					controller: 'InicialController',
				})
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