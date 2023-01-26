package modelo;

public class Vacina  {

	private String tipo;
	private String data;
	private int tempoRevacina; // em meses

	public Vacina(String tipo, String data, int tempoRevacina) {

		this.tipo = tipo;
		this.data = data;
		this.tempoRevacina = tempoRevacina;

	}
 
	public String toString() {
		return "\n\nTipo da vacina: " + tipo + "\nData: " + data + "\nTempo de revacina:" + tempoRevacina + " meses";
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