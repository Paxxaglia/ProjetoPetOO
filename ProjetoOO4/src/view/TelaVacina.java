package view;

import java.awt.Color;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controle.ControleVacina;
import controle.ControleDados;

/**
 * Tela que mostra todas as vacinas cadastradas
 * 
 * @author Iago Passaglia
 * @version 1.0
 */
public class TelaVacina implements ActionListener, ListSelectionListener {
	private JFrame janela;
	private JLabel titulo;
	private JButton cadastroVacina;
	private JButton refreshVacina;


	private ControleDados dados;
	private JList<String> listaVacinasCadastradas;


	/**
	 * Método que cria a tela com a lista de vacinas
	 * 
	 * @param dados definicao do controle de dados
	 * 
	 */

	public void mostrarDados(ControleDados dados, int posicaoPet) {
		this.dados = dados;

		/*
		 * Definição dos atributos visuais da tela
		 */

		listaVacinasCadastradas = new JList<String>(dados.listaVacina(posicaoPet));

		janela = new JFrame("Vacinas");
		titulo = new JLabel("Vacinas Cadastradas");
		titulo.setForeground(Color.yellow);
		cadastroVacina = new JButton("Cadastrar");
		refreshVacina = new JButton("Refresh");
		janela.setBackground(Color.black);
		janela.getContentPane().setBackground(Color.darkGray);

		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(90, 10, 250, 30);
		listaVacinasCadastradas.setBounds(20, 50, 350, 120);
		listaVacinasCadastradas
				.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listaVacinasCadastradas.setVisibleRowCount(10);
		listaVacinasCadastradas.setBackground(Color.LIGHT_GRAY);

		cadastroVacina.setBounds(70, 177, 100, 30);
		refreshVacina.setBounds(200, 177, 100, 30);

		janela.setLayout(null);

		janela.add(titulo);
		janela.add(listaVacinasCadastradas);
		janela.add(cadastroVacina);
		janela.add(refreshVacina);

		janela.setSize(400, 250);
		janela.setVisible(true);
		janela.setLocationRelativeTo(null);

		cadastroVacina.addActionListener(this);
		refreshVacina.addActionListener(this);
		listaVacinasCadastradas.addListSelectionListener(this);

	}

	public void valueChanged(ListSelectionEvent e) {

		/*
		 * Reconhece qual vacina foi selecionada na lista e abre a tela de detalhe com os dados 
		 */
		 
		Object src = e.getSource();

		if (e.getValueIsAdjusting() && src == listaVacinasCadastradas) {
			new TelaDetalheVacina().inserirEditar(1, dados, this,
					listaVacinasCadastradas.getSelectedIndex());
		}
	}

	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();

		/*
		 *  Cria uma tela de detalhe de vacina vazia para cadastro de nova vacina
		 */
		if (src == cadastroVacina)
			new TelaDetalheVacina().inserirEditar(0, dados, this, 0);

		/*
		 *  Atualiza a lista de vacinas
		 */
		if (src == refreshVacina) {
			listaVacinasCadastradas
					.setListData(new ControleVacina(dados).getTipoVacina());
			listaVacinasCadastradas.updateUI();
		}
	}
}