angular.module('minhasDiretivas', [])
    .directive('meuPainel', function() {

        var ddo = {};

        ddo.restrict = 'AE'; //pode ser um atributo ou um elemento
        ddo.transclude = true; //no elemento que deve preservar seus elementos filhos
        ddo.scope = {
            titulo: '@' //qdo o nome do campo fo o mesmo pd usar @, se nao deve declarar o nome q esta no html
        };

        ddo.templateUrl = 'js/directives/meu-painel.html'; 

        return ddo;
    })
    .directive('minhaFoto', function() {
        var ddo = {};

        ddo.restrict = 'AE';
        ddo.scope = {
            titulo: '@',
            url: '@'
        }
        ddo.templateUrl = 'js/directives/minha-foto.html';

        return ddo;
    })

    .directive('meuBotaoPerigo', function() {
        var ddo = {};
        ddo.restrict = "E";
        ddo.scope = {
            nome: '@', //passa valor
            acao : '&' //passa referencia
        }
        ddo.template = '<button class="btn btn-danger btn-block" ng-click="acao()">{{nome}}</button>';

        return ddo;
    })

    .directive('meuFocus', function() {
        var ddo = {};
        ddo.restrict = "A";

        ddo.link = function(scope, element) {
            scope.$on('fotoCadastrada', function() {
                 element[0].focus();
             });
        };

        return ddo;
    })

    .directive('meusTitulos', function() {
        var ddo = {};
        ddo.restrict = 'E';
        ddo.template = '<ul><li ng-repeat="titulo in titulos">{{titulo}}</li></ul>';
        ddo.controller = function($scope, recursoFoto) {
            recursoFoto.query(function(fotos) {
                $scope.titulos = fotos.map(function(foto) {
                    return foto.titulo;
                });    
            });
        };
        return ddo;
    });