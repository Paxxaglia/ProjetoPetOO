package controle;
 
import modelo.*;

/**
 * Classe controladora de aves
 * @author Iago Passaglia
 * @version 1.0
 */
public class ControleAve { 
	

	private Ave[] ave;
	private int qtdAves;
	

	public Ave[] getAve() {
		return ave;
	}

	public void setAve(Ave[] ave) {
		this.ave = ave;
	}

	public int getQtdAves() {
		return qtdAves;
	}

	public void setQtdAves(int qtdAves) {
		this.qtdAves = qtdAves;
	}
	
	public ControleAve(ControleDados dados) {
		ave = dados.getAves();
		qtdAves = dados.getQtdAves();
	}
	
	
	/**
	 * Metodo para pegar o valor do nome de uma determinada ave
	 * @return Nome da ave
	 */
	
	public String[] getNomeAve() {
		String[] s = new String[qtdAves];
		for (int i = 0; i < qtdAves; i++) {
			s[i] = ave[i].getNome();
		}
		return s;
	}


}
