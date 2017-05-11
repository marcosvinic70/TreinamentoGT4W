(function () {

	'use strict';


	function Request(angularResource, httpConfig){

		var http = angularResource.$http(httpConfig);

		http.error(function(result, statusHttp){

			if(statusHttp === 401){

				location.href = 'logout';
				
			}

		});

		return http;

	}

	angular.module('appModule')
		.factory('request', function ($http) {

			var angularResource = {

				$http : $http

			};

			return {

				get: function(url, params) {

					return new Request(angularResource, {

						url: url,

						method: 'GET',

						params: params,

						paramSerializer: '$httpParamSerializerJQLike'

					});

				},

				post: function(url, params, httpConfig) {

					var config = angular.extend({

						url: url,

						method: 'POST',

						data: params,

						headers: {'Content-Type': 'application/json'}

					}, httpConfig);

					return new Request(angularResource, config);

				},

				delete: function(url, params, httpConfig) {

					var config = angular.extend({

						url: url,

						method: 'DELETE',

						data: params,

						headers: {'Content-Type': 'application/json'}

					}, httpConfig);

					return new Request(angularResource, config);

				},

				put: function(url, params) {

					return new Request(angularResource, {

						url: url,

						method: 'PUT',

						params: params

					});

				},

				download: function(url) {

					location.href = url;
				},

				redirect: function(url) {
					
					var win = window.open(url, '_blank');
					win.focus();
				}
			};
		});
}());