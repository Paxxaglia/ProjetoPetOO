 	package modelo;

public class Dados {

	private Ave[] ave = new Ave[50];
	private int qtdAves = 0;
	private Cachorro[] cachorro = new Cachorro[50];
	private int qtdCachorros = 0;
	private Gato[] gato = new Gato[50];
	private int qtdGatos = 0;
	private Vacina[] vacina = new Vacina[50];
	private int qtdVacinas = 0;
	  
	
	public void fillWithSomeData() {

		for(int i = 0; i < 5; i++) {

			gato[i] = new Gato("Gato"+i, "Sexo"+i, 12, (i+1)*2, "Azul"+i, "Cor"+i, 
					"Pelagem"+i);

			ave[i] = new Ave("Ave"+i, "Sexo"+i, 12, (i+1)*2 , 4, "Especie"+i);
			
			cachorro[i] = new Cachorro("Cachorro"+i, "Sexo"+i, 12, (i+1)*2, "Medio",20+i*2, "Raça"+i);
			
			vacina[i] = new Vacina("Vacina"+i, "data"+i, i);
			
		}
		
		
		qtdGatos = 5;
		qtdAves = 5;
		qtdCachorros = 5;
		qtdVacinas = 5;

	}
	
	public Gato[] getGatos() {
		return gato;
	}


	public void setGatos(Gato[] gato) {
		this.gato = gato;
	}
	


	public int getQtdGatos() {
		return qtdGatos;
	}


	public void setQtdGatos(int qtdGatos) {
		this.qtdGatos = qtdGatos;
	}


	public Cachorro[] getCachorros() {
		return cachorro;
	}


	public void setCachorros(Cachorro[] cachorro) {
		this.cachorro = cachorro;
	}
	


	public int getQtdCachorros() {
		return qtdCachorros;
	}


	public void setQtdCachorros(int qtdCachorros) {
		this.qtdCachorros = qtdCachorros;
	}


	public Ave[] getAves() {
		return ave;
	}


	public void setAves(Ave[] ave) {
		this.ave = ave;
	}
	


	public int getQtdAves() {
		return qtdAves;
	}


	public void setQtdAves(int qtdAves) {
		this.qtdAves = qtdAves;
	}


	public Vacina[] getVacinas() {
		return vacina;
	}


	public void setVacinas(Vacina[] vacina) {
		this.vacina = vacina;
	}


	public int getQtdVacinas() {
		return qtdVacinas;
	}


	public void setQtdVacinas(int qtdVacinas) {
		this.qtdVacinas = qtdVacinas;
	}
	
	public void cadastrarAve(Ave ave, int pos) {
		this.ave[pos] = ave;
		if(pos == qtdAves) qtdAves++;
	}
	
	public void cadastrarGato(Gato gato, int pos) {
		this.gato[pos] = gato;
		if(pos == qtdGatos) qtdGatos++;
	}
	
	public void cadastrarCachorro(Cachorro cachorro, int pos) {
		this.cachorro[pos] = cachorro;
		if(pos == qtdCachorros) qtdCachorros++;
	}
	public void cadastrarVacina(Vacina vacina, int pos) {
		this.vacina[pos] = vacina;
		if(pos == qtdVacinas) qtdVacinas++;
	}
	
}