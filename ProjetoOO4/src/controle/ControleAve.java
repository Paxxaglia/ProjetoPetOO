package controle;
 
import modelo.*;

public class ControleAve {

	private Ave[] ave;
	private int qtdAves;

	public ControleAve(ControleDados dados) {
		ave = dados.getAves();
		qtdAves = dados.getQtdAves();
	}

	public String[] getNomeAve() {
		String[] s = new String[qtdAves];
		for (int i = 0; i < qtdAves; i++) {
			s[i] = ave[i].getNome();
		}
		return s;
	}

}
