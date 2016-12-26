//muda-de-cor.js

var trs = document.getElementsByTagName("tr");

percorreArray(trs, function(tr) {

	tr.addEventListener("dbclick", function() {
		this.setAttribute("bgcolor", "grey");
	});

});