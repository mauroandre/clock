package app.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.models.Relogio;

@WebServlet("/rest/clock/*")
public class Rest extends HttpServlet{
	private static final long serialVersionUID = 1L;	
	private Relogio relogio = new Relogio();
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String[] params = getParams(request);
		int hora = getHora(params);
		int minuto = getMinuto(params);

		getRelogio().calculaAnguloPara(hora, minuto);		
		imprimeAngulo(response.getWriter(), hora, minuto);
	}

	private void imprimeAngulo(PrintWriter saida, int hora, int minuto){		
		saida.println(relogio.getAnguloPara(hora, minuto));
	}

	private int getHora(String[] params) {		
		if (params.length > 1){
			return Integer.parseInt(params[1]);
		}
		
		return 0;
	}

	private int getMinuto(String[] params) {		
		if (params.length > 2){
			return Integer.parseInt(params[2]);
		}
		
		return 0;
	}

	private String[] getParams(HttpServletRequest request) {
		return request.getPathInfo().split("/");
	}

	public Relogio getRelogio() {
		return relogio;
	}
}