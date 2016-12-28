angular.module('alurapic').controller('FotosController', ['$scope', 'recursoFoto' , function($scope, recursoFoto) {

	$scope.filtro = '';

	$scope.fotos = [];

	$scope.mensagem = '';

    recursoFoto.query(function(fotos) {
        $scope.fotos = fotos;
    }, function(erro) {
        console.log(erro);
    });

    //com $http 
/*	$http.get('/v1/fotos')
    .success(function(fotos) {
        console.log(fotos);
        $scope.fotos = fotos; // não precisa fazer retorno.data
    })
    .error(function(erro) {
        console.log(erro);
    });
*/
    /* Ou
	    $http.get('v1/fotos')
		  .then(function(retorno) {
		    $scope.fotos = retorno.data;
		  })
		  .catch(function(erro) {
		    // trata o erro
	 	 });
    */

    $scope.remover = function(foto) {

        recursoFoto.delete({fotoId: foto._id}, function() {
            var indiceDaFoto = $scope.fotos.indexOf(foto);
            $scope.fotos.splice(indiceDaFoto, 1);
            $scope.mensagem = 'Foto ' + foto.titulo + ' removida com sucesso!';
        }, function(erro) {
            console.log(erro);
            $scope.mensagem = 'Não foi possível apagar a foto ' + foto.titulo;
        });
    };       

}]);