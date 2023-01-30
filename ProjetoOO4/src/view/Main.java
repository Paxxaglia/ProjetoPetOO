package view;

import controle.ControleDados;

public class Main {
	private static ControleDados dados = new ControleDados();
	
	public static void main(String[] args) {
		new TelaMenu(dados);
	}

}
