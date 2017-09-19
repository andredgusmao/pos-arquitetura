const UniArq = (function iniciaModulo($) {
	function filtraUnicos(array, propriedade, ordena) {
		let filtrado = 
			array.map(function (json) { 
				return json[propriedade]; 
			})
			.filter( function (valor, index, arr) {
				return arr.indexOf(valor) === index; 
			})
		if(ordena) filtrado = filtrado.sort(ordena);
		return filtrado;
	}
	
	function servicos() {
		let baseUrl = "/uniarq-esb/proxy/";
		function horarios (callback) {
//			let id = "ad9c004e-ff78-4d98-883a-0088623cf6b1";
			let id = $('#professor').val();
			$.getJSON(
				baseUrl.concat("grade/disciplinas/professor/").concat(id), 
				function recebeDados(dados) {
					let horarios = filtraUnicos(dados, 'inicio', true);
//					let dias = filtraUnicos(dados, 'dia', function (a, b) {
//						let jsonDias = {'SEGUNDA' : 1, 'TERCA': 2, 'QUARTA': 3, 'QUINTA': 4, 'SEXTA': 5};
//						return jsonDias[a] - jsonDias[b];
//					});
					let dias = ["SEGUNDA", "TERCA", "QUARTA", "QUINTA", "SEXTA"];
					let json = {};
					let tabela = dados.map(function (d) {
						let chave = d.dia.concat('-').concat(d.inicio.replace(new RegExp(':', 'g'), '-'));
						json[chave] = d;
						return d;
					});
					
					var retorno = { 'dados' : json, 'horarios': horarios, 'dias': dias };
					
					callback(retorno);
				}
			);
		}
		
		return {
			'horarios' : horarios 
		};
	}
	
	function view() {
		function preencheTabela($tabela, info) {
	    	for(let horario of info.horarios) {
	    		let $linha = $('<tr>');
	    		for(let dia of info.dias) {
	    			let chave = dia.concat('-').concat(horario.replace(new RegExp(':', 'g'), '-'));
	    			let disciplina = info.dados[chave];
	    			
	    			let $td = $('<td>');
	    			if(disciplina) {
	    				$td.append('<p class="text-center">' + disciplina.nome + '</p>')
	    				.append('<p class="text-center">' + disciplina.inicio + ' - ' + disciplina.fim + '</p>');
	    			}
	    			$linha.append($td);
	    		}
	    		$tabela.find('tbody').append($linha);
	    		$tabela.toggleClass('table-responsive').toggleClass('table-responsive');
	    	}
	    }
		
		return {
			'preencheTabela': preencheTabela  
		};
	}
	
	return {
		'Servicos': servicos(),
		'View' : view()
	}
}) (jQuery);