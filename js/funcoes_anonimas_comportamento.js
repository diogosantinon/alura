<script>

function percorreArray(array, comportamento) {

    for(var i = 0; i < array.length; i++) {

        // veja que a função agora esta sendo chamada recebendo um parâmetro
        comportamento(array[i]);
    }

}

var numeros = [1,2,3,4,5,6];

percorreArray(numeros, function (numero) {

    if(numero % 2 == 0) {
        console.log(numero);
    }

});

percorreArray(numeros, function (numero) {

    console.log(numero);
});

percorreArray(numeros, function (numero) {

    if(numero % 2 != 0) {
        console.log(numero);
    };
});

</script>