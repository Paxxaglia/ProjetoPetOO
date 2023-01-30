package modelo;
import java.util.ArrayList;

/**
 * Classe para teste dos construtores e toStrings d140as outras classes
 * @author Polen
 * 
 */

public class Teste {

	public static Gato g;
	public static Cachorro c;
	public static Ave p;
	public static Vacina v;

	static ArrayList <Vacina> vacinas = new ArrayList<Vacina>();

	public static void main(String[] args) {
  
		g = new Gato("tigrao", "macho", 3, 12, vacinas ,"Branco", "Azul", "curta");
		c = new Cachorro("Romeu", "Macho", 15, 2, vacinas, "Medio" , 33, "Bull-Terrier");
		p = new Ave("Chico", "Macho", 0.700, 1, vacinas, 5, "Tucano");
		v = new Vacina("Parvovirose", "09/09/2022", 4);
		Vacina v2 = new Vacina("tuberculose", "09/10/2022", 4);
		
		vacinas.add(v);
		vacinas.add(v2);

		System.out.println(g.toString());

		System.out.println(c.toString());

		System.out.println(p.toString());

//		System.out.println(vacinas);
		
		

	}

}
