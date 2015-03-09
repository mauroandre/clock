package app.controllers;

import org.junit.Assert;
import org.junit.Test;

import app.models.RelogioAngulo;

public class RelogioAnguloTest {
	
	@Test
	public void deveCalcularAngulo(){
		RelogioAngulo relogioAngulo = new RelogioAngulo(10, 55);
		Assert.assertEquals(30.0, relogioAngulo.getAngulo(), 0.00001);
	}
	
	@Test
	public void deveCalcularAnguloComPonteirosInvertidos(){
		RelogioAngulo relogioAngulo = new RelogioAngulo(-9, -10);
		Assert.assertEquals(150.0, relogioAngulo.getAngulo(), 0.00001);
	}
	
	@Test
	public void deveCalcularAnguloComMaisDe12Horas(){
		RelogioAngulo relogioAngulo1 = new RelogioAngulo(18, 25);
		Assert.assertEquals(30.0, relogioAngulo1.getAngulo(), 0.00001);
		
		RelogioAngulo relogioAngulo2 = new RelogioAngulo(-15, 25);
		Assert.assertEquals(30.0, relogioAngulo2.getAngulo(), 0.00001);
		
		RelogioAngulo relogioAngulo3 = new RelogioAngulo(250, 25);
		Assert.assertEquals(30.0, relogioAngulo3.getAngulo(), 0.00001);
		
		RelogioAngulo relogioAngulo4 = new RelogioAngulo(-230, 25);
		Assert.assertEquals(30.0, relogioAngulo4.getAngulo(), 0.00001);
	}
	
	@Test
	public void deveCalcularAnguloComMaisDe60Minutos(){
		RelogioAngulo relogioAngulo1 = new RelogioAngulo(18, 25);
		Assert.assertEquals(30.0, relogioAngulo1.getAngulo(), 0.00001);
		
		RelogioAngulo relogioAngulo2 = new RelogioAngulo(-15, 25);
		Assert.assertEquals(30.0, relogioAngulo2.getAngulo(), 0.00001);
		
		RelogioAngulo relogioAngulo3 = new RelogioAngulo(250, 25);
		Assert.assertEquals(30.0, relogioAngulo3.getAngulo(), 0.00001);
		
		RelogioAngulo relogioAngulo4 = new RelogioAngulo(-230, 25);
		Assert.assertEquals(30.0, relogioAngulo4.getAngulo(), 0.00001);
	}
}
