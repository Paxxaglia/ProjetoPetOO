package controle;


import java.util.ArrayList;

import modelo.*;

/**
 * Controle responsavel por manipular os dados do sistema
 * 
 * @author Iago Passaglia
 * @version 1.0
 */
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

	/**
	 * Metodo que efetua o cadastro de uma ave
	 * 
	 * @param dadosAves Array contendo os atributos a serem cadastrados
	 * @return true após efetuar o cadastro de uma nova ave
	 */
	public boolean cadastrarAve(String[] dadosAves) {
		
		/*
		 * declara os atributos do objeto como sendo aqueles que foram passados no
		 * parametro
		 */
		if(Integer.parseInt(dadosAves[0])==dados.getQtdAves()) {
			Ave a = new Ave(dadosAves[1], dadosAves[2], Double.parseDouble(dadosAves[3]),
				Integer.parseInt(dadosAves[4]), new ArrayList<>(),Integer.parseInt(dadosAves[5]),
				dadosAves[6]);
			dados.cadastrarAve(a, Integer.parseInt(dadosAves[0]));
		}else {
			Ave a = new Ave(dadosAves[1], dadosAves[2], Double.parseDouble(dadosAves[3]),
					Integer.parseInt(dadosAves[4]), dados.getAves()[Integer.parseInt(dadosAves[0])].getVacinas(),Integer.parseInt(dadosAves[5]),
					dadosAves[6]);
			dados.cadastrarAve(a, Integer.parseInt(dadosAves[0]));
		}
		
		
		return true;

	}

	/**
	 * Metodo que efetua o cadastro de um cachorro
	 * 
	 * @param dadosCachorros Array contendo os atributos a serem cadastrados
	 * @return true após efetuar o cadastro de um novo cachorro
	 */
	public boolean cadastrarCachorro(String[] dadosCachorros) {

		/*
		 * declara os atributos do objeto como sendo aqueles que foram passados no
		 * parametro
		 */
		if(Integer.parseInt(dadosCachorros[0])==dados.getQtdCachorros()) {
			Cachorro c = new Cachorro(dadosCachorros[1], dadosCachorros[2],
					Double.parseDouble(dadosCachorros[3]),
					Integer.parseInt(dadosCachorros[4]), new ArrayList<>(), dadosCachorros[5],
					Integer.parseInt(dadosCachorros[6]), dadosCachorros[7]);

			dados.cadastrarCachorro(c, Integer.parseInt(dadosCachorros[0]));
		}else {
			Cachorro c = new Cachorro(dadosCachorros[1], dadosCachorros[2],
					Double.parseDouble(dadosCachorros[3]),
					Integer.parseInt(dadosCachorros[4]),  new ArrayList<>(),dadosCachorros[5],
					Integer.parseInt(dadosCachorros[6]), dadosCachorros[7]);

			dados.cadastrarCachorro(c, Integer.parseInt(dadosCachorros[0]));
		}
		
		
		return true;

	}

	/**
	 * Metodo que efetua o cadastro de um gato
	 * 
	 * @param dadosGatos Array contendo os atributos a serem cadastrados
	 * @return true após efetuar o cadastro de um novo gato
	 */

	public boolean cadastrarGato(String[] dadosGatos) {

		/*
		 * declara os atributos do objeto como sendo aqueles que foram passados no
		 * parametro
		 */
		if(Integer.parseInt(dadosGatos[0])==dados.getQtdGatos()) {
			Gato g = new Gato(dadosGatos[1], dadosGatos[2], Double.parseDouble(dadosGatos[3]),
					Integer.parseInt(dadosGatos[4]),new ArrayList<>(), dadosGatos[5], dadosGatos[6],
					dadosGatos[7]);

			dados.cadastrarGato(g, Integer.parseInt(dadosGatos[0]));
		}else {
			Gato g = new Gato(dadosGatos[1], dadosGatos[2], Double.parseDouble(dadosGatos[3]),
					Integer.parseInt(dadosGatos[4]), new ArrayList<>(),dadosGatos[5], dadosGatos[6],
					dadosGatos[7]);

			dados.cadastrarGato(g, Integer.parseInt(dadosGatos[0]));
		}
		
		return true;

	}

	/**
	 * Metodo que efetua o cadastro de uma vacina
	 * 
	 * @param dadosVacinas Array contendo os atributos a serem cadastrados
	 * @return true após efetuar o cadastro de uma nova vacina
	 */

	public boolean cadastrarVacina(String[] dadosVacinas,int posicao, int opcao) {

		/*
		 * declara os atributos do objeto como sendo aqueles que foram passados no
		 * parametro
		 */
		
		
		
		Vacina v = new Vacina(dadosVacinas[1], dadosVacinas[2],
				Integer.parseInt(dadosVacinas[3]));
		
		
		dados.cadastrarVacina(v, Integer.parseInt(dadosVacinas[0]));
		
		if(opcao == 1) {
			dados.getAves()[posicao].getVacinas().add(v);
		}
		return true;
	}

	/**
	 * Metodo para remoção de pets
	 * 
	 * @param i posicao da ave a ser removida
	 * @return true caso tudo ocorra bem
	 */
	public boolean removerAve(int i) {
		String aveRemovida = dados.getAves()[i].getNome();

		if (i == (dados.getQtdAves() - 1)) {// A ave que vai ser removida está no final do
											// array
			dados.setQtdAves(dados.getQtdAves() - 1);
			dados.getAves()[dados.getQtdAves()] = null;
			return true;
		} else {// a ave a ser removido está no meio do array
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

		if (i == (dados.getQtdGatos() - 1)) {// o gato que vai ser removida está no final do
												// array
			dados.setQtdGatos(dados.getQtdGatos() - 1);
			dados.getGatos()[dados.getQtdGatos()] = null;
			return true;
		} else {// o gato a ser removido está no meio do array
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

		if (i == (dados.getQtdCachorros() - 1)) {// o cachorro que vai ser removido está
													// no final do
													// array
			dados.setQtdCachorros(dados.getQtdCachorros() - 1);
			dados.getCachorros()[dados.getQtdCachorros()] = null;
			return true;
		} else {// a cachorro a ser removido está no meio do array
			int cont = 0;
			while (dados.getCachorros()[cont].getNome()
					.compareTo(cachorroRemovido) != 0) {
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
	
	/**
	 * Metodo para remoção de vacinas
	 * 
	 * @param i posicao da vacina a ser removida
	 * @return true caso tudo ocorra bem
	 */

	public boolean removerVacina(int i) {
		String vacinaRemovida = dados.getVacinas()[i].getTipo();

		if (i == (dados.getQtdVacinas() - 1)) {// A vacina que vai ser removida está no
												// final do
												// array
			dados.setQtdVacinas(dados.getQtdVacinas() - 1);
			dados.getVacinas()[dados.getQtdVacinas()] = null;
			return true;
		} else {// a vacina a ser removida está no meio do array
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

	
	public String[] listaVacina(int posicaoPet) {
		  
		String[] s = new String[dados.getQtdVacinas()];
		for (int i = 0; i < dados.getQtdVacinas(); i++) {
			s[i] = dados.getAves()[posicaoPet].getVacinas().get(i).getTipo() + "";
		}
		return s;
		
	}
	
	
	/**
	 * Metodo que pesquisa um determinado pet por meio do nome
	 * @param filtro Nome do pet a ser pesquisado
	 * @param opcao tipo do pet a ser pesquisado
	 * @return posição do pet encontrado caso encontre e 100 caso nao encontre
	 */
	public int buscarPet(String filtro, int opcao) {

		/*
		 * pesquisar ave
		 */
		if (opcao == 1) {
			int petSelecionado = 0;
			for (int i = 0; i < dados.getQtdAves(); i++) {
				if (dados.getAves()[i].getNome().equals(filtro)) {
					petSelecionado = i;
					return petSelecionado;
				}
			}

		}
		if (opcao == 3) {
			/*
			 * pesquisar cachorro
			 */
			int petSelecionado = 0;
			for (int i = 0; i < dados.getQtdCachorros(); i++) {
				if (dados.getCachorros()[i].getNome().equals(filtro)) {
					petSelecionado = i;
					return petSelecionado;
				}
			}
		} else {
			/*
			 * pesquisar gato
			 */

			int petSelecionado = 0;
			for (int i = 0; i < dados.getQtdGatos(); i++) {
				if (dados.getGatos()[i].getNome().equals(filtro)) {
					petSelecionado = i;
					return petSelecionado;
				}
			}
		}
		return 100;
	}

}
