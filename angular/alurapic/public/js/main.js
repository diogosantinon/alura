angular.module('alurapic', ['minhasDiretivas', 'ngAnimate', 'ngRoute', 'meusServicos'])
	.config(function($routeProvider, $locationProvider) {
		$locationProvider.html5Mode(true); //remove # da endpoint

		$routeProvider.when('/fotos', {
			templateUrl: 'partials/principal.html',
			controller: 'FotosController',
			caseInsensitiveMatch: true //permite a digitacao caseInsensitive
		});

		$routeProvider.when('/fotos/new', {
            templateUrl: 'partials/foto.html',
            controller: 'FotoController'
        });

        $routeProvider.when('/fotos/edit/:fotoId', {
            templateUrl: 'partials/foto.html',
            controller: 'FotoController'
        });

		$routeProvider.otherwise({redirectTo: '/fotos'});
		
	});

