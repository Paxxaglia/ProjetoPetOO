package view;
 
import java.awt.*; 


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import controle.ControleDados;


public class TelaMenu implements ActionListener{

	private JFrame menu = new JFrame("Projeto Pet - MENU");
	private JButton botaoPets = new JButton(" Pets ");
	private JButton botaoVacinas = new JButton(" Vacinas ");
	private ControleDados dados = new ControleDados();


	
	/**
	 * 
	 */ 
	
	TelaMenu() {


		Font Arial = new Font("Arial Black", Font.BOLD, 25);

		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu.add(botaoPets);
		menu.add(botaoVacinas);

		menu.setSize(800, 400);
		menu.setLayout(null);
		menu.setVisible(true);
		menu.getContentPane().setBackground(Color.darkGray);
		menu.setLocationRelativeTo(null);


		botaoPets.setBounds(150, 125, 200, 60);
		botaoPets.setForeground(Color.BLACK);
		botaoPets.setBackground(Color.yellow);
		botaoPets.setFont(Arial);
		botaoPets.setBorder(BorderFactory.createLineBorder(Color.orange, 2));

		botaoVacinas.setBounds(425, 125, 200, 60);
		botaoVacinas.setForeground(Color.BLACK);
		botaoVacinas.setBackground(Color.YELLOW);
		botaoVacinas.setFont(Arial);
		botaoVacinas.setBorder(BorderFactory.createLineBorder(Color.orange, 2));

		
		botaoVacinas.addActionListener(this);
		botaoPets.addActionListener(this);


	}
	
	public static void main(String[] args) {
		new TelaMenu();
	}
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == botaoPets) {
			new TelaMenuPets(dados);
		
		}
		
		if(src == botaoVacinas) {
			new TelaVacina().mostrarDados(dados, 1);
		}
		

	}

}
