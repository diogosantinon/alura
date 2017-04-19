
// var pacientes = document.querySelectorAll(".paciente");

// 	function addEventoRemoverElementos() {
// 		Array.from(pacientes).forEach(function(paciente) {
//     		paciente.addEventListener("dblclick", function() {
//         		this.remove();
// 			});
// 		});		
// 	}

var tabela = document.querySelector("#tabela-pacientes");//evento na tabela para ser por tr, para qdo add novas

function addEventoRemoverElementos() {
	tabela.addEventListener("dblclick", function(event) {
		event.target.parentNode.classList.add("fadeOut");
		setTimeout(function() {
    	    event.target.parentNode.remove();
    	}, 500);
	    // var alvoEvento = event.target;
	    // var paiDoAlvo = alvoEvento.parentNode;

	    paiDoAlvo.remove();
	});
}

addEventoRemoverElementos();
