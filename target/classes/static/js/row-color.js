$(document).ready(function () {
	var table = document.getElementById("tableConteudos");
	for (var i = 1, row; row = table.rows[i]; i++) {
		if(row.cells[2].innerHTML === "Péssimo"){
			$(row).addClass("alert alert-danger")
			$(row.cells[2]).html('<span class="fa fa-star checked"></span> <span class="fa fa-star"></span> <span class="fa fa-star"></span> <span class="fa fa-star"></span> <span class="fa fa-star"></span>')
		}
		else if(row.cells[2].innerHTML === "BlockBuster"){
			$(row).addClass("alert alert-success")
			$(row.cells[2]).html('<span class="fa fa-star checked"></span> <span class="fa fa-star checked"></span> <span class="fa fa-star checked"></span> <span class="fa fa-star checked"></span> <span class="fa fa-star checked"></span>')
		}
		else if(row.cells[2].innerHTML === "Ruim"){
			$(row).addClass("alert alert-warning")
			$(row.cells[2]).html('<span class="fa fa-star checked"></span> <span class="fa fa-star checked"></span> <span class="fa fa-star"></span> <span class="fa fa-star"></span> <span class="fa fa-star"></span>')
		}
		else if(row.cells[2].innerHTML === "Bom"){
			$(row).addClass("alert alert-warning")
			$(row.cells[2]).html('<span class="fa fa-star checked"></span> <span class="fa fa-star checked"></span> <span class="fa fa-star checked"></span> <span class="fa fa-star"></span> <span class="fa fa-star"></span>')
		}
		else if(row.cells[2].innerHTML === "Muito Bom"){
			$(row).addClass("alert alert-warning")
			$(row.cells[2]).html('<span class="fa fa-star checked"></span> <span class="fa fa-star checked"></span> <span class="fa fa-star checked"></span> <span class="fa fa-star checked"></span> <span class="fa fa-star"></span>')
		}
	}  
})