package app.models;

public class RelogioAngulo {
	private int hora;
	private int minuto; 
	private float angulo;
	
	public RelogioAngulo(int hora, int minuto) {
		this.hora = hora;
		this.minuto = minuto;
		
		calculaAngulo(hora, minuto);
	}

	private void calculaAngulo(int hora, int minuto) {
		float angHora = 360 / 12 * hora;   
		float angMin = 360 / 60 * minuto;  
		float ang = Math.abs(angHora - angMin);
		
		this.angulo = getMenorAngulo(ang);
	}

	private float getMenorAngulo(float ang) {
		if (ang  > 360 || ang < -360){
			ang = (ang % 360);
		}
		
		if (ang > 180){
			ang = 360 - ang;
		}

		return ang;
	}
	
	public int getHora() {
		return hora;
	}

	public int getMinuto() {
		return minuto;
	}

	public float getAngulo() {
		return angulo;
	}
}