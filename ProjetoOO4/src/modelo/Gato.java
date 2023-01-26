package modelo;

import java.util.*;

public class Gato extends Pet {

	private String corPelo;
	private String corOlho;
	private String tamanhoPelagem;
	private boolean surdez;

	public Gato(String nome, String sexo, double peso, int idade, String corPelo, String corOlho,String tamanhoPelagem) {
 
		this.nome = nome;
		this.sexo = sexo;
		this.peso = peso;
		this.idade = idade;
		this.corPelo = corPelo;
		this.corOlho = corOlho;
		this.tamanhoPelagem = tamanhoPelagem;
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


	public boolean isSurdez() {
		return surdez;
	}


	public void setSurdez(boolean surdez) {
		this.surdez = surdez;
	}


	public String toString() {
		return "\n\nNome do gato: " + nome + "\nSexo: " + sexo + "\nPeso: " + peso + "kg\nIdade: " + idade
				+ "\nTamanho da pelagem: " + tamanhoPelagem;
	}

//getters e setters

	public String isPeloBranco() {
		return corPelo;
	}

//

	public String getTamanhoPelagem() {
		return tamanhoPelagem;
	}

	public void setTamanhoPelagem(String tamanhoPelagem) {
		this.tamanhoPelagem = tamanhoPelagem;
	}
	

}
