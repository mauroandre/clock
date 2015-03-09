package app.controllers;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import app.models.Relogio;

public class RelogioTest {
	
	private Relogio relogio;

	@Before
	public void setUp(){
		relogio = new Relogio(); 
	}
	
	@Test
	public void deveCalcularAngulo(){
		relogio.calculaAnguloPara(3, 55);
		
		Assert.assertEquals(120, relogio.getAnguloPara(3, 55), 0.0001);
	}
	
	@Test
	public void naoDeveRecalcularAngulo(){
		relogio.calculaAnguloPara(3, 55);
		relogio.calculaAnguloPara(3, 55);
		relogio.calculaAnguloPara(9, 40);
		relogio.calculaAnguloPara(8, 40);
		relogio.calculaAnguloPara(3, 55);
		
		Assert.assertEquals(3, relogio.getAngulosCalculados().size());
	}
}
