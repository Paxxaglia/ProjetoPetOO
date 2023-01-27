package modelo;

/**
 * Classe Ave demonstra os atributos de uma ave, com atributos individuais e
 * atributos herdados da Classe Pet
 * 
 * @author Iago Passaglia
 * @version 1.0
 */

public class Ave extends Pet {

	private int mesCorte;
	private String especie;

	/**
	 * Metodo construtor da classe ave para instanciar um objeto
	 * 
	 * @param nome     nome do objeto ave a ser instanciado
	 * @param sexo     sexo do objeto ave a ser instanciado
	 * @param peso     peso do objeto ave a ser instanciado
	 * @param idade    idade do objeto ave a ser instanciado
	 * @param mesCorte mês de corte das asas da ave
	 * @param especie  especie da ave
	 */
	public Ave(String nome, String sexo, double peso, int idade, int mesCorte,
			String especie) {

		this.nome = nome;
		this.sexo = sexo;
		this.peso = peso;
		this.idade = idade;
		this.mesCorte = mesCorte;
		this.especie = especie;
	}

	/**
	 * Sobrescrita do metodo toString para que apresente os valores dos atributos.
	 * 
	 * @return Valores dos atributos da classe ave
	 */
	public String toString() {
		return "\n\nNome do passaro: " + nome + "\nSexo: " + sexo + "\nPeso: " + peso
				+ "kg\nIdade: " + idade + "\nEspécie: " + especie;
	}

	public int getMesCorte() {
		return mesCorte;
	}

	public void setMesCorte(int mesCorte) {
		this.mesCorte = mesCorte;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

}
