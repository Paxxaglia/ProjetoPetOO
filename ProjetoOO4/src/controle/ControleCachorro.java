package controle;
 
import modelo.*;

public class ControleCachorro {

	private Cachorro[] cachorro;
	private int qtdCachorros;

	public ControleCachorro(ControleDados dados) {
		cachorro = dados.getCachorros();
		qtdCachorros = dados.getQtdCachorros();
	}

	public String[] getNomeCachorro() {
		String[] s = new String[qtdCachorros];
		for (int i = 0; i < qtdCachorros; i++) {
			s[i] = cachorro[i].getNome();
		}
		return s;
	}

}