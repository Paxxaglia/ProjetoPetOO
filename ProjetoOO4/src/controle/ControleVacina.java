package controle;

import modelo.*;

public class ControleVacina {
 
	private Vacina[] vacina;
	private int qtdVacinas;

	public ControleVacina(ControleDados dados) {
		vacina = dados.getVacinas();
		qtdVacinas = dados.getQtdVacinas();
	}

	public String[] getTipoVacina() {
		String[] s = new String[qtdVacinas];
		for (int i = 0; i < qtdVacinas; i++) {
			s[i] = vacina[i].getTipo();
		}
		return s;
	} 

}  