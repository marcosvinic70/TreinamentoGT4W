(function() {

	var modulo = angular.module('appModule', ['ngRoute', 'ui.bootstrap','datatables']);

	modulo.config(['$routeProvider',

		function($routeProvider){

			$routeProvider
				.when("/usuarios", {
					templateUrl: 'views/sections/usuarios.html',
					controller: 'UsuariosController',
				})
				.when("/editarUsuario/:id", {
					templateUrl: 'views/sections/editarUsuario.html',
					controller: 'EditarUsuariosController',
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
                .when("/historico", {
                    templateUrl: 'views/sections/historicoUsuarios.html',
                    controller: 'HistoricoUsuariosController',
                })
                .when("/editarCargo/:id", {
                    templateUrl: 'views/sections/editarCargos.html',
                    controller: 'EditarCargosController',
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