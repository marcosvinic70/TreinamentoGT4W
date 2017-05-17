
(function() {

	var modulo = angular.module('appModule', ['ngRoute', 'ui.bootstrap']);

	modulo.config(['$routeProvider',

		function($routeProvider){

			$routeProvider
<<<<<<< HEAD
				.when('/', {
					templateUrl: 'views/sections/inicial.html',
					controller: 'InicialController',
				})
				.when('/index', {
					templateUrl: 'views/sections/inicial.html',
					controller: 'InicialController',
				})
=======
>>>>>>> 1e47aa4836e1c87adb9f185b157788be3319b1d1
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