package app.model;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import app.controllers.Rest;

public class RestTest extends Mockito{

	private Rest rest;
	private HttpServletRequest request;
	private HttpServletResponse response;

	private ByteArrayOutputStream retorno;
	private PrintWriter writer;

	@Before
	public void setUp() throws IOException{		
        request = mock(HttpServletRequest.class);       
        response = mock(HttpServletResponse.class);
        
		rest = new Rest();		
		retorno = new ByteArrayOutputStream();
		writer = new PrintWriter(retorno, true);
		
        when(response.getWriter()).thenReturn(writer);
	}
	
	@Test
	public void deveCalcularAngulosComHoraEMinuto() throws ServletException, IOException{        
		when(request.getPathInfo()).thenReturn("/6/15");        
        rest.service(request, response);        
        
		when(request.getPathInfo()).thenReturn("/7/55");        
        rest.service(request, response);
        
		when(request.getPathInfo()).thenReturn("/4/45");        
        rest.service(request, response);
        
        Assert.assertEquals("90.0\n120.0\n150.0\n", retorno.toString());
	}
	
	@Test
	public void deveCalcularAngulosSomenteComHora() throws ServletException, IOException{
        
        when(request.getPathInfo()).thenReturn("/4");        
        rest.service(request, response);
        
        when(request.getPathInfo()).thenReturn("/6");        
        rest.service(request, response);     
        
        when(request.getPathInfo()).thenReturn("/9");        
        rest.service(request, response);     
        
        Assert.assertEquals("120.0\n180.0\n90.0\n", retorno.toString());
	}
	
	@Test
	public void deveCalcularAngulosSomenteSemParametros() throws ServletException, IOException{        
        when(request.getPathInfo()).thenReturn("");        
        rest.service(request, response);
        
        Assert.assertEquals("0.0\n", retorno.toString());
	}
}