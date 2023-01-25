package modelo;

public class Ave extends Pet {

	private int mesCorte;
	private String especie;

	public Ave(String nome, String sexo, double peso, int idade, 
		   int mesCorte, String especie) {

		this.nome = nome;
		this.sexo = sexo;
		this.peso = peso;
		this.idade = idade;
		this.mesCorte = mesCorte;
		this.especie = especie;
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
	
	

	public String toString() {
		return "\n\nNome do passaro: " + nome + "\nSexo: " + sexo + "\nPeso: " + peso + "kg\nIdade: " + idade
		+ "\nEspécie: " + especie;
	}


	}


