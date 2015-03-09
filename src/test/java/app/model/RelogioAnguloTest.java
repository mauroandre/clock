package app.model;

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
		RelogioAngulo relogioAngulo1 = new RelogioAngulo(18, 25); // 6:25
		Assert.assertEquals(30.0, relogioAngulo1.getAngulo(), 0.00001);
		
		RelogioAngulo relogioAngulo2 = new RelogioAngulo(-15, 20); // 9:20
		Assert.assertEquals(150.0, relogioAngulo2.getAngulo(), 0.00001);
		
		RelogioAngulo relogioAngulo3 = new RelogioAngulo(250, 40); // 10:40
		Assert.assertEquals(60.0, relogioAngulo3.getAngulo(), 0.00001);
	}
	
	@Test
	public void deveCalcularAnguloComMaisDe60Minutos(){
		RelogioAngulo relogioAngulo1 = new RelogioAngulo(18, -75); // 6:45
		Assert.assertEquals(90.0, relogioAngulo1.getAngulo(), 0.00001);
		
		RelogioAngulo relogioAngulo2 = new RelogioAngulo(-15, 115); // 9:55
		Assert.assertEquals(60.0, relogioAngulo2.getAngulo(), 0.00001);
		
		RelogioAngulo relogioAngulo3 = new RelogioAngulo(256, -250); //4:50
		Assert.assertEquals(180.0, relogioAngulo3.getAngulo(), 0.00001);
	}
}
