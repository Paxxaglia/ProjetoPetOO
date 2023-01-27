package modelo;

/**
 * Classe para teste dos construtores e toStrings d140as outras classes
 * @author Polen
 * 
 */

public class Teste {

	static Gato g;
	static Cachorro c;
	static Ave p;
	static Vacina v;


	public static void main(String[] args) {
  
		g = new Gato("tigrao", "macho", 3, 12, "Branco", "Azul", "curta");
		c = new Cachorro("Romeu", "Macho", 15, 2, "Medio", 33, "Bull-Terrier");
		p = new Ave("Chico", "Macho", 0.700, 1, 5, "Tucano");
		v = new Vacina("Parvovirose", "09/09/2022", 4);

		System.out.println(g.toString());

		System.out.println(c.toString());

		System.out.println(p.toString());

		System.out.println(v.toString());

	}

}
