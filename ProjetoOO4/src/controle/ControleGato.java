package controle;

import modelo.*;

public class ControleGato {
	
	private Gato[] getGatos;
	private int qtdGatos;

	public ControleGato(ControleDados dados) {
		getGatos = dados.getGatos();
		qtdGatos = dados.getQtdGatos();
	}

	public String[] getNomeGato() {
		String[] s = new String[qtdGatos];
		for (int i = 0; i < qtdGatos; i++) {
			s[i] = getGatos[i].getNome();
		}
		return s;
	}

}