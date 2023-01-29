package modelo;

import java.util.ArrayList;

/**
 * Classe Abstrata Mãe Pet contem os valores comuns entre seus herdeiros.
 * @author Polen
 * @version 1.0
 */

public abstract class Pet {

	
	protected String nome;
	protected String sexo;
	protected double peso;
	protected int idade;
	protected ArrayList <Vacina> vacinas = new ArrayList<Vacina>();
  
	// getters e setters

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Vacina> getVacinas() {
		return vacinas;
	}

	public void setVacinas(ArrayList<Vacina> vacinas) {
		this.vacinas = vacinas;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}
	 

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

}
