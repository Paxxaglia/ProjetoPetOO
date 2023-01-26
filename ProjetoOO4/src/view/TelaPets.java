package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import controle.ControleDados;
import controle.*;

public class TelaPets implements ActionListener, ListSelectionListener {
	private JFrame janela;
	private JLabel titulo;
	private JTextField pesquisaInfo;
	private JButton cadastroAve;
	private JButton cadastroCachorro;
	private JButton cadastroGato;
	private JButton buscaAve;
	private JButton buscaGato;
	private JButton buscaCachorro;
	private JButton refreshAve;
	private JButton refreshCachorro;
	private JButton refreshGato;
	private int posicao;
 
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

			pesquisaInfo = new JTextField("Digite o nome do pet");
			buscaAve = new JButton("Pesquisar");
			janela = new JFrame("Aves");
			titulo = new JLabel("Aves Cadastradas");

			cadastroAve = new JButton("Cadastrar");
			refreshAve = new JButton("Refresh");
			janela.setBackground(Color.black);
			janela.getContentPane().setBackground(Color.darkGray);

			buscaAve.setForeground(Color.BLACK);
			buscaAve.setBackground(Color.yellow);
			buscaAve.setFont(new Font("Arial", Font.BOLD, 15));
			buscaAve.setBorder(BorderFactory.createLineBorder(Color.orange, 2));

			cadastroAve.setBackground(Color.yellow);
			cadastroAve.setFont(new Font("Arial", Font.BOLD, 15));
			cadastroAve.setBorder(BorderFactory.createLineBorder(Color.orange, 2));

			refreshAve.setBackground(Color.yellow);
			refreshAve.setFont(new Font("Arial", Font.BOLD, 15));
			refreshAve.setBorder(BorderFactory.createLineBorder(Color.orange, 2));

			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			titulo.setBounds(90, 10, 250, 30);
			buscaAve.setBounds(70, 250, 90, 30);
			listaAvesCadastradas.setBounds(20, 50, 350, 120);
			listaAvesCadastradas
					.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			listaAvesCadastradas.setVisibleRowCount(10);
			listaAvesCadastradas.setBackground(Color.LIGHT_GRAY);

			pesquisaInfo.setBounds(200, 255, 115, 20);
			cadastroAve.setBounds(70, 177, 100, 30);
			refreshAve.setBounds(200, 177, 100, 30);
			titulo.setForeground(Color.yellow);
			janela.setLayout(null);

			janela.add(titulo);
			janela.add(listaAvesCadastradas);
			janela.add(cadastroAve);
			janela.add(refreshAve);
			janela.add(buscaAve);
			janela.add(pesquisaInfo);

			janela.setSize(400, 350);
			janela.setVisible(true);
			janela.setLocationRelativeTo(null);

			cadastroAve.addActionListener(this);
			refreshAve.addActionListener(this);
			listaAvesCadastradas.addListSelectionListener(this);
			buscaAve.addActionListener(this);

			break;

		case 2:

			listaNomes = new ControleGato(dados).getNomeGato();

			listaGatosCadastrados = new JList<String>(listaNomes);

			pesquisaInfo = new JTextField("Digite o nome do pet");
			buscaGato = new JButton("Pesquisar");
			janela = new JFrame("Gatos");
			titulo = new JLabel("Gatos Cadastradas");
			titulo.setForeground(Color.yellow);
			cadastroGato = new JButton("Cadastrar");
			refreshGato = new JButton("Refresh");
			janela.setBackground(Color.black);
			janela.getContentPane().setBackground(Color.darkGray);

			pesquisaInfo.setBounds(200, 255, 115, 20);

			buscaGato.setForeground(Color.BLACK);
			buscaGato.setBackground(Color.yellow);
			buscaGato.setFont(new Font("Arial", Font.BOLD, 15));
			buscaGato.setBorder(BorderFactory.createLineBorder(Color.orange, 2));
			buscaGato.setBounds(70, 250, 90, 30);

			cadastroGato.setForeground(Color.BLACK);
			cadastroGato.setBackground(Color.yellow);
			cadastroGato.setFont(new Font("Arial", Font.BOLD, 15));
			cadastroGato.setBorder(BorderFactory.createLineBorder(Color.orange, 2));

			refreshGato.setForeground(Color.BLACK);
			refreshGato.setBackground(Color.yellow);
			refreshGato.setFont(new Font("Arial", Font.BOLD, 15));
			refreshGato.setBorder(BorderFactory.createLineBorder(Color.orange, 2));

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
			janela.add(buscaGato);
			janela.add(pesquisaInfo);

			janela.setSize(400, 350);
			janela.setVisible(true);
			janela.setLocationRelativeTo(null);

			cadastroGato.addActionListener(this);
			refreshGato.addActionListener(this);
			listaGatosCadastrados.addListSelectionListener(this);
			buscaGato.addActionListener(this);

			break;

		case 3: // mostrar dados de cachorros cadastrados

			buscaCachorro = new JButton("Pesquisar");
			pesquisaInfo = new JTextField("Digite o nome do pet");

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

			buscaCachorro.setForeground(Color.BLACK);
			buscaCachorro.setBackground(Color.yellow);
			buscaCachorro.setFont(new Font("Arial", Font.BOLD, 15));
			buscaCachorro.setBorder(BorderFactory.createLineBorder(Color.orange, 2));
			buscaCachorro.setBounds(70, 250, 90, 30);

			cadastroCachorro.setForeground(Color.BLACK);
			cadastroCachorro.setBackground(Color.yellow);
			cadastroCachorro.setFont(new Font("Arial", Font.BOLD, 15));
			cadastroCachorro.setBorder(BorderFactory.createLineBorder(Color.orange, 2));

			refreshCachorro.setForeground(Color.BLACK);
			refreshCachorro.setBackground(Color.yellow);
			refreshCachorro.setFont(new Font("Arial", Font.BOLD, 15));
			refreshCachorro.setBorder(BorderFactory.createLineBorder(Color.orange, 2));

			pesquisaInfo.setBounds(200, 255, 115, 20);

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
			janela.add(buscaCachorro);
			janela.add(pesquisaInfo);

			janela.setSize(400, 350);
			janela.setVisible(true);
			janela.setLocationRelativeTo(null);

			cadastroCachorro.addActionListener(this);
			refreshCachorro.addActionListener(this);
			listaCachorrosCadastrados.addListSelectionListener(this);
			buscaCachorro.addActionListener(this);

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

		if (e.getSource() == buscaAve) {

			// mostra tela para busca de uma ave

			// Atribui o valor escrito no JTextfield
			String nomeAve = pesquisaInfo.getText();

			// Atribui o retorno de buscar pet a variavel posição
			posicao = dados.buscarPet(nomeAve, 1);

			if (posicao < 100) {
				// cria a tela de edição com o pet da posição retornada

				new TelaDetalhePet().inserirEditar(5, dados, this, posicao);

			} else {
				mensagemErro();
			}
		}

		if (e.getSource() == buscaCachorro) {

			// mostra tela para busca de uma ave

			String nomeCachorro = pesquisaInfo.getText();
			posicao = dados.buscarPet(nomeCachorro, 3);
			if (posicao < 100) {
				new TelaDetalhePet().inserirEditar(6, dados, this, posicao);
			} else {
				mensagemErro();
			}
		}

		if (e.getSource() == buscaGato) {

			// mostra tela para busca de uma ave

			String nomeGato = pesquisaInfo.getText();
			posicao = dados.buscarPet(nomeGato, 2);
			if (posicao < 100) {
				new TelaDetalhePet().inserirEditar(7, dados, this, posicao);
			} else {
				mensagemErro();
			}
		}

	}

	public void mensagemErro() {
		JOptionPane.showMessageDialog(null, "O Pet digitado não foi cadastrado!", null,
				JOptionPane.INFORMATION_MESSAGE);

	}

}
