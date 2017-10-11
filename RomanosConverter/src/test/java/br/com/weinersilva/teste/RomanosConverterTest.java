package br.com.weinersilva.teste;

import org.junit.Assert;
import org.junit.Test;

import br.com.weinersilva.dominio.RomanosConverter;

public class RomanosConverterTest{
	
	
	@Test
	public void testandoConversorNumeros() {
		
		RomanosConverter conversor = new RomanosConverter();
		
		Assert.assertEquals(new Integer(1), conversor.conversor("i"));
		Assert.assertEquals(new Integer(5), conversor.conversor("v"));
		Assert.assertEquals(new Integer(100), conversor.conversor("c"));
		Assert.assertEquals(new Integer(500), conversor.conversor("d"));
	
		Assert.assertEquals(new Integer(1280), conversor.conversor("MCCLXXX"));
		
		Assert.assertEquals(new Integer(4999), conversor.conversor("MMMMCMXCIX"));
		
	}
	
	
	@Test
	public void testandoConversorInvalidos() {
		
		RomanosConverter conversor2 = new RomanosConverter();
		Assert.assertEquals(null, conversor2.conversor("0"));
		Assert.assertEquals(null, conversor2.conversor("wei"));
		Assert.assertEquals(null, conversor2.conversor("xxiiii"));
		Assert.assertEquals(null, conversor2.conversor(""));
	}

}
