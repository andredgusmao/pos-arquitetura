$(document).ready(function () {
    UniArq.Servicos.horarios( function (info) {    	
    	UniArq.View.preencheTabela($('.horarios'), info);
    });
});

