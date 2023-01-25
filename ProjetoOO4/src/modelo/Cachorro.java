package modelo;

public class Cachorro extends Pet {

	private String porte;
	private int tempoPasseio;
	private String raca;

	public Cachorro(String nome, String sexo, double peso, int idade, String porte, int tempoPasseio, String raca) {

		this.nome = nome;
		this.sexo = sexo;
		this.peso = peso;
		this.idade = idade;
		this.porte = porte;
		this.tempoPasseio = tempoPasseio;
		this.raca = raca;

	}

	public int getTempoPasseio() {
		return tempoPasseio;
	}

	public void setTempoPasseio(int tempoPasseio) {
		this.tempoPasseio = tempoPasseio;
	}

	// getters e setters

//

	public String getPorte() {
		return porte;
	}

	public void setPorte(String porte) {
		this.porte = porte;
	}

//

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}
	public String toString() {
		return "\n\nNome do cachorro: " + nome + "\nSexo: " + sexo + "\nPeso: " + peso + "kg\nIdade: " + idade
				+ "\nPorte: " + porte + "\nRaça: " + raca + "\nTempo de passeio (Em minutos): " + tempoPasseio;
	}
}
