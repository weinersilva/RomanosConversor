package br.com.weinersilva.dominio;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RomanosConverter {
	
	private Map<String, Integer> referenciaRomanoArabico;
	
	
	public Integer conversor(String numerosRomanos) {
		
		Integer numeroArabico = null;
		carregarReferencia();
		
		if(numerosRomanos != null && !numerosRomanos.isEmpty() && validarString(numerosRomanos)) {
			numerosRomanos = numerosRomanos.toUpperCase();
			numeroArabico = referenciaRomanoArabico.get(numerosRomanos);
			
			if(numeroArabico == null) {
				numeroArabico = 0;
				
				int i = 0;
				
				while (i < numerosRomanos.length()) {
					char romano = numerosRomanos.charAt(i);
					String fraseRomana = romano + "";
					
					if(referenciaRomanoArabico.containsKey(fraseRomana)) {
						int numeroConvertido = referenciaRomanoArabico.get(fraseRomana);
						i++;
						
						if (i == numerosRomanos.length()) {
							
							numeroArabico += numeroConvertido;
						}else {
							char proximoRomano = numerosRomanos.charAt(i);
							String proximoNumeroRomano = proximoRomano + "";
							int proximoNumeroArabico = referenciaRomanoArabico.get(proximoNumeroRomano);
							if(proximoNumeroArabico > numeroConvertido) {
								numeroArabico += (proximoNumeroArabico - numeroConvertido);
								i++;
							}else {
								numeroArabico += numeroConvertido;
							}
						}
					}
				}
			}
			
			return numeroArabico;
		}
		return numeroArabico;
		
	}

	private boolean validarString(String numerosRomanos2) {
		boolean resposta = false;
		
		numerosRomanos2 = numerosRomanos2.toUpperCase();
		
		Pattern expressao = Pattern.compile("^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$");
		Matcher operacao = expressao.matcher(numerosRomanos2);
		boolean eValido = operacao.matches();
		
		if(eValido) {
			resposta = true;
		}
		
		return resposta;
	}

	private void carregarReferencia() {

		referenciaRomanoArabico = new HashMap<String, Integer>();
		
		referenciaRomanoArabico.put("I", 1);
		referenciaRomanoArabico.put("II", 2);
		referenciaRomanoArabico.put("III", 3);
		referenciaRomanoArabico.put("IV", 4);
		referenciaRomanoArabico.put("V", 5);
		referenciaRomanoArabico.put("VI", 6);
		referenciaRomanoArabico.put("VII", 7);
		referenciaRomanoArabico.put("VIII", 8);
		referenciaRomanoArabico.put("IX", 9);
		referenciaRomanoArabico.put("X", 10);
		referenciaRomanoArabico.put("L", 50);
		referenciaRomanoArabico.put("C", 100);
		referenciaRomanoArabico.put("D", 500);
		referenciaRomanoArabico.put("M", 1000);

	}
}
