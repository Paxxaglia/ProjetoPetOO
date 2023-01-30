package modelo;

import java.util.ArrayList;

/**
 * Classe Cachorro demonstra os atributos de um cachorro, com atributos
 * individuais e atributos herdados da Classe Pet
 * 
 * @author Iago Passaglia
 * @version 1.0
 */

public class Cachorro extends Pet {

	private String porte;
	private int tempoPasseio;
	private String raca;

	/**
	 * Metodo construtor da classe ave para instanciar um objeto
	 * 
	 * @param nome         nome do objeto ave a ser instanciado
	 * @param sexo         sexo do objeto ave a ser instanciado
	 * @param peso         peso do objeto ave a ser instanciado
	 * @param idade        idade do objeto ave a ser instanciado
	 * @param porte        porte das asas da ave
	 * @param tempoPasseio especie da ave
	 */

	public Cachorro(String nome, String sexo, double peso, int idade, ArrayList<Vacina> vacinas ,String porte,
			int tempoPasseio, String raca) {

		this.nome = nome;
		this.sexo = sexo;
		this.peso = peso;
		this.idade = idade;
		this.porte = porte;
		this.tempoPasseio = tempoPasseio;
		this.raca = raca;

	}
	
	/**
	 * Sobrescrita do metodo toString.
	 * 
	 * @return Valores dos atributos da classe cachorro
	 */
	public String toString() {
		return "\n\nNome do cachorro: " + nome + "\nSexo: " + sexo + "\nPeso: " + peso
				+ "kg\nIdade: " + idade + "\nPorte: " + porte + "\nRaça: " + raca
				+ "\nTempo de passeio (Em minutos): " + tempoPasseio;
	}
	
//gets e sets
	
	public int getTempoPasseio() {
		return tempoPasseio;
	}

	public void setTempoPasseio(int tempoPasseio) {
		this.tempoPasseio = tempoPasseio;
	}

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


}
