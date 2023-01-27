package modelo;

/**
 * Classe vacina demonstra os atributos de uma vacina
 * 
 * @author Iago Passaglia
 * @version 1.0
 */

public class Vacina {

	private String tipo;
	private String data;
	private int tempoRevacina; // em meses

	/**
	 * Metodo construtor da classe ave para instanciar um objeto
	 * 
	 * @param tipo          tipo da vacina
	 * @param data          data da aplicacao da vacina
	 * @param tempoRevacina tempo da revacina
	 */
	public Vacina(String tipo, String data, int tempoRevacina) {

		this.tipo = tipo;
		this.data = data;
		this.tempoRevacina = tempoRevacina;

	}
	
	/**
	 * Sobrescrita do metodo toString.
	 * 
	 * @return Valores dos atributos da classe vacina
	 */
	public String toString() {
		return "\n\nTipo da vacina: " + tipo + "\nData: " + data + "\nTempo de revacina:"
				+ tempoRevacina + " meses";
	}

	// gets e sets

	public int getTempoRevacina() {
		return tempoRevacina;
	}

	public void setTempoRevacina(int tempoRevacina) {
		this.tempoRevacina = tempoRevacina;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}