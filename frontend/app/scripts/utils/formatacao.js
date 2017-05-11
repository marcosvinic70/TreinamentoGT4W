(function() {

	'use strict';

	String.prototype.formatarCpfCnpj = function() {

		var v = this.toString().replace(/\D/g, '');
		if (v.length <= 11) { //CPF
			v = v.replace(/(\d{3})(\d)/, '$1.$2');
			v = v.replace(/(\d{3})(\d)/, '$1.$2');
			v = v.replace(/(\d{3})(\d{1,2})$/, '$1-$2');
		} else {
			v = v.replace(/^(\d{2})(\d)/, '$1.$2');
			v = v.replace(/^(\d{2})\.(\d{3})(\d)/, '$1.$2.$3');
			v = v.replace(/\.(\d{3})(\d)/, '.$1/$2');
			v = v.replace(/(\d{4})(\d)/, '$1-$2');
		}

		return v;
	};

	var formatarNumero = function(number, casas) {

		var numeros = number.toFixed(casas).toString().split('.');
		var esquerdo = numeros[0].replace(/\B(?=(\d{3})+(?!\d))/g, '.');
		var direito = numeros[1];
		return esquerdo + ',' + direito;
	};

	String.prototype.formatarNumero = function(casas) {

		casas = casas || 2;
		return formatarNumero(parseFloat(this), casas);
	};

	Number.prototype.formatarNumero = function(casas) {

		casas = casas || 2;
		return formatarNumero(this, casas);
	};

	String.prototype.formatarTelefone = function() {

		return this.replace(/\D/g,'').replace(/^(\d{2})(\d)/g,'($1) $2');
	};

	String.prototype.capitalize = function() {

		return this.toLowerCase().replace(/(?:^|\s)\S/g, function(a) { return a.toUpperCase(); });
	};

	String.prototype.formatarCEP = function() {

		return this.replace(/\D/g,'').replace(/^(\d{5})(\d)/,'$1-$2');
	};

	String.prototype.deixarSomenteNumeros = function() {

		return this.toString().replace(/[-_./]/g,'');
	};

	String.prototype.convertData = function() {

		var parts =this.toString().split('/');
		return new Date(parts[2],parts[1]-1,parts[0]);
	};

	String.prototype.removeAcentos = function(palavra) {
		
		var comAcento = 'áàãâäéèêëíìîïóòõôöúùûüçÁÀÃÂÄÉÈÊËÍÌÎÏÓÒÕÖÔÚÙÛÜÇ';
		var semAcento = 'aaaaaeeeeiiiiooooouuuucAAAAAEEEEIIIIOOOOOUUUUC';
		var nova = '';

		for(var i = 0; i < palavra.length; i++) {

			if (comAcento.search(palavra.substr(i,1).replace('(', '\\(').replace(')', '\\)')) >= 0) {

				nova += semAcento.substr(comAcento.search(palavra.substr(i,1)),1);
			
			} else {

				nova += palavra.substr(i,1);
			
			}
		}

		return nova;
	};

	String.prototype.snakeCase = function(){
		return this.removeAcentos(this.toString()).toLowerCase().replace(/ /g, '_');
	};

	Date.prototype.convertDate = function() {

		var d = this,
			month = '' + (d.getMonth() + 1),
			day = '' + d.getDate(),
			year = d.getFullYear();

		if (month.length < 2){
			month = '0' + month;
		}

		if (day.length < 2) {
			day = '0' + day;
		}

		return [day, month, year].join('/');
	};

	Date.prototype.subtrairDias = function(dias){

		return new Date(this.getTime() - (dias * 24 * 60 * 60 * 1000));
	};

}());