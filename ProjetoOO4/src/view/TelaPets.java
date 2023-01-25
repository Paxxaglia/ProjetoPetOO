package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import controle.*;

public class TelaPets implements ActionListener, ListSelectionListener {
	private JFrame janela;
	private JLabel titulo;
	private JButton cadastroAve;
	private JButton cadastroCachorro;
	private JButton cadastroGato;
	private JButton refreshAve;
	private JButton refreshCachorro;
	private JButton refreshGato;

	private ControleDados dados;
	private JList<String> listaAvesCadastradas;
	private JList<String> listaCachorrosCadastrados;
	private JList<String> listaGatosCadastrados;

	private String[] listaNomes = new String[50];

	public void mostrarDados(ControleDados dados, int op) {
		this.dados = dados;

		switch (op) {
		case 1:// Mostrar Dados de Aves cadastradas

			listaNomes = new ControleAve(dados).getNomeAve();

			listaAvesCadastradas = new JList<String>(listaNomes);

			janela = new JFrame("Aves");
			titulo = new JLabel("Aves Cadastradas");
			titulo.setForeground(Color.yellow);
			cadastroAve = new JButton("Cadastrar");
			refreshAve = new JButton("Refresh");
			janela.setBackground(Color.black);
			janela.getContentPane().setBackground(Color.darkGray);

			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			titulo.setBounds(90, 10, 250, 30);
			listaAvesCadastradas.setBounds(20, 50, 350, 120);
			listaAvesCadastradas
					.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			listaAvesCadastradas.setVisibleRowCount(10);
			listaAvesCadastradas.setBackground(Color.LIGHT_GRAY);

			cadastroAve.setBounds(70, 177, 100, 30);
			refreshAve.setBounds(200, 177, 100, 30);

			janela.setLayout(null);

			janela.add(titulo);
			janela.add(listaAvesCadastradas);
			janela.add(cadastroAve);
			janela.add(refreshAve);

			janela.setSize(400, 250);
			janela.setVisible(true);
			janela.setLocationRelativeTo(null);

			cadastroAve.addActionListener(this);
			refreshAve.addActionListener(this);
			listaAvesCadastradas.addListSelectionListener(this);

			break;

		case 2:

			listaNomes = new ControleGato(dados).getNomeGato();

			listaGatosCadastrados = new JList<String>(listaNomes);

			janela = new JFrame("Gatos");
			titulo = new JLabel("Gatos Cadastradas");
			titulo.setForeground(Color.yellow);
			cadastroGato = new JButton("Cadastrar");
			refreshGato = new JButton("Refresh");
			janela.setBackground(Color.black);
			janela.getContentPane().setBackground(Color.darkGray);

			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			titulo.setBounds(90, 10, 250, 30);
			listaGatosCadastrados.setBounds(20, 50, 350, 120);
			listaGatosCadastrados
					.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			listaGatosCadastrados.setVisibleRowCount(10);
			listaGatosCadastrados.setBackground(Color.LIGHT_GRAY);

			cadastroGato.setBounds(70, 177, 100, 30);
			refreshGato.setBounds(200, 177, 100, 30);

			janela.setLayout(null);

			janela.add(titulo);
			janela.add(listaGatosCadastrados);
			janela.add(cadastroGato);
			janela.add(refreshGato);

			janela.setSize(400, 250);
			janela.setVisible(true);
			janela.setLocationRelativeTo(null);

			cadastroGato.addActionListener(this);
			refreshGato.addActionListener(this);
			listaGatosCadastrados.addListSelectionListener(this);

			break;

		case 3: // mostrar dados de cachorros cadastrados
			listaNomes = new ControleCachorro(dados).getNomeCachorro();
			listaCachorrosCadastrados = new JList<String>(listaNomes);
			janela = new JFrame("Cachorro");
			titulo = new JLabel("Cachorros Cadastrados");
			cadastroCachorro = new JButton("Cadastrar");
			refreshCachorro = new JButton("Refresh");
			janela.setBackground(Color.black);
			janela.getContentPane().setBackground(Color.darkGray);

			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			titulo.setBounds(90, 10, 250, 30);
			titulo.setForeground(Color.yellow);

			listaCachorrosCadastrados.setBounds(20, 50, 350, 120);
			listaCachorrosCadastrados
					.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			listaCachorrosCadastrados.setVisibleRowCount(10);
			listaCachorrosCadastrados.setBackground(Color.LIGHT_GRAY);
			cadastroCachorro.setBounds(70, 177, 100, 30);
			refreshCachorro.setBounds(200, 177, 100, 30);

			janela.setLayout(null);

			janela.add(titulo);
			janela.add(listaCachorrosCadastrados);
			janela.add(cadastroCachorro);
			janela.add(refreshCachorro);

			janela.setSize(400, 250);
			janela.setVisible(true);
			janela.setLocationRelativeTo(null);

			cadastroCachorro.addActionListener(this);
			refreshCachorro.addActionListener(this);
			listaCachorrosCadastrados.addListSelectionListener(this);

			break;

		default:
			JOptionPane.showMessageDialog(null, "Opção não encontrada!", null,
					JOptionPane.ERROR_MESSAGE);
		}
	}

	// Captura eventos relacionados ao JList

	public void valueChanged(ListSelectionEvent e) {

		Object src = e.getSource();

		if (e.getValueIsAdjusting() && src == listaAvesCadastradas) {
			new TelaDetalhePet().inserirEditar(5, dados, this,
					listaAvesCadastradas.getSelectedIndex());
		}

		if (e.getValueIsAdjusting() && src == listaCachorrosCadastrados) {
			new TelaDetalhePet().inserirEditar(6, dados, this,
					listaCachorrosCadastrados.getSelectedIndex());
		}

		if (e.getValueIsAdjusting() && src == listaGatosCadastrados) {
			new TelaDetalhePet().inserirEditar(7, dados, this,
					listaGatosCadastrados.getSelectedIndex());
		}

	}

	// Captura eventos relacionados aos botões da interface
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();

		// Cadastro de nova Ave
		if (src == cadastroAve)
			new TelaDetalhePet().inserirEditar(1, dados, this, 0);

		// Cadastro de novo cachorro
		if (src == cadastroCachorro)
			new TelaDetalhePet().inserirEditar(2, dados, this, 0);

		// Cadastro de novo gato
		if (src == cadastroGato)
			new TelaDetalhePet().inserirEditar(3, dados, this, 0);
		

		// Atualiza a lista de nome de aves
		if (src == refreshAve) {
			listaAvesCadastradas.setListData(new ControleAve(dados).getNomeAve());
			listaAvesCadastradas.updateUI();
		}
		// Atualiza a lista de nome de cachorros
		if (src == refreshCachorro) {
			listaCachorrosCadastrados
					.setListData(new ControleCachorro(dados).getNomeCachorro());
			listaCachorrosCadastrados.updateUI();
		}
		// Atualiza a lista de nome de gatos
		if (src == refreshGato) {
			listaGatosCadastrados.setListData(new ControleGato(dados).getNomeGato());
			listaGatosCadastrados.updateUI();
		}

	}

}
