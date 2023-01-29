package controle;

import modelo.*;

/**
 * Classe controladora de vacinas
 * @author Iago Passaglia
 * @version 1.0
 */
public class ControleVacina { 
 
	private Vacina[] vacina;
	private int qtdVacinas;

	public ControleVacina(ControleDados dados) {
		
		vacina = dados.getVacinas();
		qtdVacinas = dados.getQtdVacinas();
	}
	
	/**
	 * Metodo para pegar o valor do nome de uma determinada ave
	 * @return Nome do gato
	 */
	
	public String[] getTipoVacina() {
		String[] s = new String[qtdVacinas];
		for (int i = 0; i < qtdVacinas; i++) {
			s[i] = vacina[i].getTipo();
		}
		return s;
	} 
	


}  