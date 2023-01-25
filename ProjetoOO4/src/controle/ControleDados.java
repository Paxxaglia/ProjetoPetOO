package controle;

import modelo.*;
 
public class ControleDados {

	private Dados dados = new Dados();

	public ControleDados() {
		dados.fillWithSomeData();
	}

	public Dados getDados() {
		return dados;
	}

	public void setDados(Dados dados) {
		this.dados = dados;
	}

	public Ave[] getAves() {
		return dados.getAves();
	}

	public int getQtdAves() {
		return dados.getQtdAves();
	}

	public Cachorro[] getCachorros() {
		return dados.getCachorros();
	}

	public int getQtdCachorros() {
		return dados.getQtdCachorros();
	}

	public Gato[] getGatos() {
		return dados.getGatos();
	}

	public int getQtdGatos() {
		return dados.getQtdGatos();
	}

	public Vacina[] getVacinas() {
		return dados.getVacinas();
	}

	public int getQtdVacinas() {
		return dados.getQtdVacinas();
	}

	public boolean cadastrarAve(String[] dadosAves) {

		Ave a = new Ave(dadosAves[1], dadosAves[2], Double.parseDouble(dadosAves[3]),
				Integer.parseInt(dadosAves[4]), Integer.parseInt(dadosAves[5]),
				dadosAves[6]);

		dados.cadastrarAve(a, Integer.parseInt(dadosAves[0]));
		return true;

	}

	public boolean cadastrarCachorro(String[] dadosCachorros) {

		Cachorro c = new Cachorro(dadosCachorros[1], dadosCachorros[2],
				Double.parseDouble(dadosCachorros[3]),
				Integer.parseInt(dadosCachorros[4]), dadosCachorros[5],
				Integer.parseInt(dadosCachorros[6]), dadosCachorros[7]);

		dados.cadastrarCachorro(c, Integer.parseInt(dadosCachorros[0]));
		return true;

	}
	
	public boolean cadastrarGato(String[] dadosGatos) {

		Gato g = new Gato(dadosGatos[1], dadosGatos[2],
				Double.parseDouble(dadosGatos[3]),
				Integer.parseInt(dadosGatos[4]), dadosGatos[5],(dadosGatos[6]),
				dadosGatos[7]);

		dados.cadastrarGato(g, Integer.parseInt(dadosGatos[0]));
		return true;

	}

	public boolean cadastrarVacina(String[] dadosVacinas) {

		Vacina v = new Vacina(dadosVacinas[1], dadosVacinas[2],
				Integer.parseInt(dadosVacinas[3]));

		dados.cadastrarVacina(v, Integer.parseInt(dadosVacinas[0]));
		return true;
	}
	
	
	public boolean removerAve(int i) {
		String aveRemovida = dados.getAves()[i].getNome();

		if (i == (dados.getQtdAves() - 1)) {// A ave que vai ser removida ta no final do
											// array
			dados.setQtdAves(dados.getQtdAves() - 1);
			dados.getAves()[dados.getQtdAves()] = null;
			return true;
		} else {// a ave a ser removido ta no meio do array
			int cont = 0;
			while (dados.getAves()[cont].getNome().compareTo(aveRemovida) != 0) {
				cont++;
			}

			for (int j = cont; j < dados.getQtdAves() - 1; j++) {
				dados.getAves()[j] = null;
				dados.getAves()[j] = dados.getAves()[j + 1];
			}
			dados.getAves()[dados.getQtdAves()] = null;
			dados.setQtdAves(dados.getQtdAves() - 1);
			return true;
		}

	}
	
	public boolean removerGato(int i) {
		String gatoRemovido = dados.getGatos()[i].getNome();

		if (i == (dados.getQtdGatos() - 1)) {// o gato que vai ser removida ta no final do
											// array
			dados.setQtdGatos(dados.getQtdGatos() - 1);
			dados.getGatos()[dados.getQtdGatos()] = null;
			return true;
		} else {// o gato  a ser removido ta no meio do array
			int cont = 0;
			while (dados.getGatos()[cont].getNome().compareTo(gatoRemovido) != 0) {
				cont++;
			}

			for (int j = cont; j < dados.getQtdGatos() - 1; j++) {
				dados.getGatos()[j] = null;
				dados.getGatos()[j] = dados.getGatos()[j + 1];
			}
			dados.getGatos()[dados.getQtdGatos()] = null;
			dados.setQtdGatos(dados.getQtdGatos() - 1);
			return true;
		}

	}
	
	public boolean removerCachorro(int i) {
		String cachorroRemovido = dados.getCachorros()[i].getNome();

		if (i == (dados.getQtdCachorros() - 1)) {// A cachorro que vai ser removida está no final do
											      // array
			dados.setQtdCachorros(dados.getQtdCachorros() - 1);
			dados.getCachorros()[dados.getQtdCachorros()] = null;
			return true;
		} else {// a cachorro a ser removido está no meio do array
			int cont = 0;
			while (dados.getCachorros()[cont].getNome().compareTo(cachorroRemovido) != 0) {
				cont++;
			}

			for (int j = cont; j < dados.getQtdCachorros() - 1; j++) {
				dados.getCachorros()[j] = null;
				dados.getCachorros()[j] = dados.getCachorros()[j + 1];
			}
			dados.getCachorros()[dados.getQtdCachorros()] = null;
			dados.setQtdCachorros(dados.getQtdCachorros() - 1);
			return true;
		}

	}
	
	public boolean removerVacina(int i) {
		String vacinaRemovida = dados.getVacinas()[i].getTipo();

		if (i == (dados.getQtdVacinas() - 1)) {// A vacina que vai ser removida está no final do
											      // array
			dados.setQtdVacinas(dados.getQtdVacinas() - 1);
			dados.getVacinas()[dados.getQtdVacinas()] = null;
			return true;
		} else {// a vacina a ser removido está no meio do array
			int cont = 0;
			while (dados.getVacinas()[cont].getTipo().compareTo(vacinaRemovida) != 0) {
				cont++;
			}

			for (int j = cont; j < dados.getQtdVacinas() - 1; j++) {
				dados.getVacinas()[j] = null;
				dados.getVacinas()[j] = dados.getVacinas()[j + 1];
			}
			dados.getVacinas()[dados.getQtdVacinas()] = null;
			dados.setQtdVacinas(dados.getQtdVacinas() - 1);
			return true;
		}

	}

}
