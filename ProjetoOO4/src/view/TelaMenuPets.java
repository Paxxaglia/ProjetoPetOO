package view;

import java.awt.*;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import controle.*;

/**
 * Tela de seleção de qual tipo de pet deseja gerenciar
 * 
 * @author Iago Passaglia
 *
 */

public class TelaMenuPets implements ActionListener {

	/*
	 * Criação dos botoes e definicao de controle de dados
	 */
	private JFrame menu = new JFrame("Gerenciamento de pets - MENU");
	private JButton botaoGerenciaGato = new JButton(" Gerenciar Gatos ");
	private JButton botaoGerenciaCachorro = new JButton(" Gerenciar Cachorros ");
	private JButton botaoGerenciaAve = new JButton(" Gerenciar Aves ");
	private ControleDados dados;

	/**
	 * Criação da tela
	 * 
	 * @param dados
	 */
	TelaMenuPets(ControleDados dados) {
		this.dados = dados;

		Font Arial = new Font("Arial Black", Font.BOLD, 25);

		menu.add(botaoGerenciaGato);
		menu.add(botaoGerenciaCachorro);
		menu.add(botaoGerenciaAve);

		menu.setSize(350, 400);
		menu.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 50));
		menu.setVisible(true);
		menu.getContentPane().setBackground(Color.darkGray);
		menu.setLocationRelativeTo(null);

		botaoGerenciaGato.setBounds(100, 350, 200, 60);
		botaoGerenciaGato.setForeground(Color.BLACK);
		botaoGerenciaGato.setBackground(Color.YELLOW);
		botaoGerenciaGato.setFont(Arial);
		botaoGerenciaGato.setBorder(BorderFactory.createLineBorder(Color.orange, 2));

		botaoGerenciaCachorro.setBounds(100, 350, 200, 60);
		botaoGerenciaCachorro.setForeground(Color.BLACK);
		botaoGerenciaCachorro.setBackground(Color.YELLOW);
		botaoGerenciaCachorro.setFont(Arial);
		botaoGerenciaCachorro.setBorder(BorderFactory.createLineBorder(Color.orange, 2));

		botaoGerenciaAve.setBounds(100, 350, 200, 60);
		botaoGerenciaAve.setForeground(Color.BLACK);
		botaoGerenciaAve.setBackground(Color.YELLOW);
		botaoGerenciaAve.setFont(Arial);
		botaoGerenciaAve.setBorder(BorderFactory.createLineBorder(Color.orange, 2));

		botaoGerenciaGato.setBounds(100, 350, 200, 60);
		botaoGerenciaGato.setForeground(Color.BLACK);
		botaoGerenciaGato.setBackground(Color.YELLOW);
		botaoGerenciaGato.setFont(Arial);
		botaoGerenciaGato.setBorder(BorderFactory.createLineBorder(Color.orange, 2));

		botaoGerenciaAve.addActionListener(this);
		botaoGerenciaCachorro.addActionListener(this);
		botaoGerenciaGato.addActionListener(this);
 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();

		/*
		 * Cria tela com os dados do pet selecionado a depender do botao clicado
		 */
		if (src == botaoGerenciaAve) {
			new TelaPets().mostrarDados(dados, 1);
		}

		if (src == botaoGerenciaGato) {
			new TelaPets().mostrarDados(dados, 2);
		}

		if (src == botaoGerenciaCachorro) {
			new TelaPets().mostrarDados(dados, 3);
		}

	}

}
