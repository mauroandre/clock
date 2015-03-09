package app.models;

import java.util.ArrayList;
import java.util.List;

public class Relogio {

	private List<RelogioAngulo> angulosCalculados = new ArrayList<RelogioAngulo>();
	
	public void calculaAnguloPara(int hora, int minuto) {
		if (!jaCalculouPara(hora, minuto)){
			angulosCalculados.add(new RelogioAngulo(hora, minuto));
		}
	}

	private boolean jaCalculouPara(int hora, int minuto) {
		for (RelogioAngulo relogioAngulo : angulosCalculados) {
			if (isAnguloPara(relogioAngulo, hora, minuto)){
				return true;	
			}
		}
		
		return false;
	}

	public float getAnguloPara(int hora, int minuto) {
		for (RelogioAngulo relogioAngulo : angulosCalculados) {
			if (isAnguloPara(relogioAngulo, hora, minuto)){
				return relogioAngulo.getAngulo();
			}
		}
		
		return 0;
	}

	private boolean isAnguloPara(RelogioAngulo relogioAngulo, int hora, int minuto){
		return relogioAngulo.getHora() == hora &&
			   relogioAngulo.getMinuto() == minuto;
	}
	
	public List<RelogioAngulo> getAngulosCalculados() {
		return angulosCalculados;
	}
}