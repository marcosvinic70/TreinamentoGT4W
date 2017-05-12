
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