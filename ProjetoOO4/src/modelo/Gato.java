package modelo;

import java.util.ArrayList;

/**
 * Classe Gato demonstra os atributos de um Gato, com atributos individuais e
 * atributos herdados da Classe Pet
 * 
 * @author Iago Passaglia
 * @version 1.0
 */

public class Gato extends Pet {

	private String corPelo;
	private String corOlho;
	private String tamanhoPelagem;

	/**
	 * Metodo construtor da classe gato para instanciar um objeto
	 * 
	 * @param nome           nome do objeto gato a ser instanciado
	 * @param sexo           sexo do objeto gato a ser instanciado
	 * @param peso           peso do objeto gato a ser instanciado
	 * @param idade          idade do objeto gato a ser instanciado
	 * @param corPelo        cor do pelo do gato
	 * @param corOlho        cor do olho do gato
	 * @param tamanhoPelagem tamanho do pelo do gato
	 */

	public Gato(String nome, String sexo, double peso, int idade, ArrayList<Vacina> vacinas , String corPelo,
			String corOlho, String tamanhoPelagem) {

		this.nome = nome;
		this.sexo = sexo;
		this.peso = peso;
		this.idade = idade;
		this.corPelo = corPelo;
		this.corOlho = corOlho;
		this.tamanhoPelagem = tamanhoPelagem;
		this.vacinas = vacinas;
	}

	/**
	 * Sobrescrita do metodo toString.
	 * 
	 * @return Valores dos atributos da classe gato
	 */
	public String toString() {
		return "\n\nNome do gato: " + nome + "\nSexo: " + sexo + "\nPeso: " + peso
				+ "kg\nIdade: " + idade + "\nTamanho da pelagem: " + tamanhoPelagem;
	}
		
	
	public String getCorPelo() {
		return corPelo;
	}

	public void setCorPelo(String corPelo) {
		this.corPelo = corPelo;
	}

	public String getCorOlho() {
		return corOlho;
	}

	public void setCorOlho(String corOlho) {
		this.corOlho = corOlho;
	}

	public String getTamanhoPelagem() {
		return tamanhoPelagem;
	}

	public void setTamanhoPelagem(String tamanhoPelagem) {
		this.tamanhoPelagem = tamanhoPelagem;
	}



}
