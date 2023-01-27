package controle;

import modelo.*;

/**
 * Classe controladora de gatos
 * @author Iago Passaglia
 * @version 1.0
 */
public class ControleGato {
	  
	private Gato[] getGatos;
	private int qtdGatos;
	
	
	public ControleGato(ControleDados dados) {
		getGatos = dados.getGatos();
		qtdGatos = dados.getQtdGatos();
	}

	/**
	 * Metodo para pegar o valor do nome de uma determinada ave
	 * @return Nome do gato
	 */
	public String[] getNomeGato() {
		String[] s = new String[qtdGatos];
		for (int i = 0; i < qtdGatos; i++) {
			s[i] = getGatos[i].getNome();
		}
		return s;
	}

}