package controle;
 
import modelo.*;

/**
 * Classe de controle de cachorro
 * @author Iago Passaglia
 * @version 1.0
 */
public class ControleCachorro {
 
	private Cachorro[] cachorro;
	private int qtdCachorros;


	public Cachorro[] getCachorro() {
		return cachorro;
	}

	public void setCachorro(Cachorro[] cachorro) {
		this.cachorro = cachorro;
	}

	public int getQtdCachorros() {
		return qtdCachorros;
	}

	public void setQtdCachorros(int qtdCachorros) {
		this.qtdCachorros = qtdCachorros;
	}

	public ControleCachorro(ControleDados dados) {
		cachorro = dados.getCachorros();
		qtdCachorros = dados.getQtdCachorros();
	}
	
	/**
	 * Metodo para pegar o valor do nome de um determinado cachoorro
	 * @return Nome do cachorro
	 */
	public String[] getNomeCachorro() {
		String[] s = new String[qtdCachorros];
		for (int i = 0; i < qtdCachorros; i++) {
			s[i] = cachorro[i].getNome();
		}
		return s;
	}

}