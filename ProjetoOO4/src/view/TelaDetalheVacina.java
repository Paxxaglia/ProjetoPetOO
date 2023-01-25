package view;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controle.*;
import javax.swing.*;

public class TelaDetalheVacina implements ActionListener {
 
	private JTextField tipoVacina = new JTextField(10);
	private JTextField dataVacina = new JTextField(10);
	private JTextField tempoRevacina = new JTextField(10);
	private JButton botaoSalvar = new JButton(" Salvar ");
	private JButton botaoExcluir = new JButton(" Excluir ");
	private JFrame telaCadastroVacina = new JFrame("Cadastro de vacina");
	private String[] novoDado = new String[8];
	private ControleDados dados;
	private JFrame cadastroVacina = new JFrame("Projeto Pet - Cadastro de Vacina");
	private JLabel instrucaoPet = new JLabel(" Selecione o animal vacinado ");
	private JLabel instrucaoTipo = new JLabel(" Digite o tipo da vacina: ");
	private JLabel instrucaoData = new JLabel(" Digite a data da vacina: ");
	private JLabel instrucaoRevacina = new JLabel(" Tempo de revacina (Ex: 6 meses):");
	private JLabel informativo = new JLabel(
			"<html>" + "Caso não seja necessário revacina," + "<br>"
					+ "informe que o tempo de revacina é 0" + "</html>");

	private int posicao;
	private int opcao;
	private String s;

	public void inserirEditar(int op, ControleDados d, TelaVacina a, int pos) {

		dados = new ControleDados();

		Font Arial = new Font("Arial Black", Font.BOLD, 30);

		opcao = op;
		dados = d;
		posicao = pos;

		// Definições dos estilos

		instrucaoTipo.setForeground(Color.yellow);
		instrucaoData.setForeground(Color.yellow);
		instrucaoRevacina.setForeground(Color.yellow);
		instrucaoPet.setForeground(Color.yellow);
		informativo.setForeground(Color.yellow);
		tempoRevacina.setBackground(Color.LIGHT_GRAY);
		dataVacina.setBackground(Color.LIGHT_GRAY);
		tipoVacina.setBackground(Color.LIGHT_GRAY);
//		animalVacinado.setBackground(Color.LIGHT_GRAY);

		// estilo do botao

		botaoExcluir.setForeground(Color.BLACK);
		botaoExcluir.setBackground(Color.YELLOW);
		botaoExcluir.setFont(Arial);
		botaoExcluir.setBorder(BorderFactory.createLineBorder(Color.orange, 2));
		botaoExcluir.setBounds(600, 200, 300, 200);

		botaoSalvar.setForeground(Color.BLACK);
		botaoSalvar.setBackground(Color.YELLOW);
		botaoSalvar.setFont(Arial);
		botaoSalvar.setBorder(BorderFactory.createLineBorder(Color.orange, 2));
		botaoSalvar.setBounds(600, 200, 300, 300);

		// alterações de design da tela

		cadastroVacina.setBackground(Color.black);
		cadastroVacina.setSize(350, 550);
		cadastroVacina.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 50));
		cadastroVacina.setVisible(true);
		cadastroVacina.getContentPane().setBackground(Color.darkGray);
		cadastroVacina.setLocationRelativeTo(null);

		// adicionando os objetos gráficos na tela

		cadastroVacina.add(instrucaoTipo);
		cadastroVacina.add(tipoVacina);
		cadastroVacina.add(instrucaoData);
		cadastroVacina.add(dataVacina);
		cadastroVacina.add(instrucaoRevacina);
		cadastroVacina.add(tempoRevacina);
		cadastroVacina.add(informativo);
		cadastroVacina.add(botaoSalvar);

		posicao = pos;
		dados = d;

		telaCadastroVacina = new JFrame(s);

		botaoExcluir.addActionListener(this);
		botaoSalvar.addActionListener(this);

		// Preenche dados com dados da vacina clicada
		if (op == 1) {

			cadastroVacina.add(botaoExcluir);
			tipoVacina.setText(dados.getVacinas()[pos].getTipo());
			dataVacina.setText(dados.getVacinas()[pos].getData());
			tempoRevacina
					.setText(String.valueOf(dados.getVacinas()[pos].getTempoRevacina()));
		}
	}

	public void actionPerformed(ActionEvent e) {

		Object src = e.getSource();

		if (src == botaoSalvar) {
			System.out.println("chegou aqui");
			boolean res = false;

			if (opcao == 0) // cadastrar nova vacina
				novoDado[0] = Integer.toString(dados.getQtdVacinas());
			else
				novoDado[0] = Integer.toString(posicao);

			if (opcao == 1 || opcao == 0) { // salvar os dados inseridos de vacinas

				novoDado[1] = tipoVacina.getText();
				novoDado[2] = dataVacina.getText();
				novoDado[3] = tempoRevacina.getText();

				res = dados.cadastrarVacina(novoDado);

			}
			if (res) {
				mensagemSucessoCadastro();
			}
		}
		
		if (src == botaoExcluir) {
			boolean res = false;

			// exclui ave

			if (opcao == 1) {
				res = dados.removerVacina(posicao);
				if (res)
					mensagemSucessoExclusao();
				else
					mensagemErroExclusao();
			}
		}
	}

	public void mensagemSucessoCadastro() {
		JOptionPane.showMessageDialog(null, "Os dados foram salvos com sucesso!", null,
				JOptionPane.INFORMATION_MESSAGE);
		cadastroVacina.dispose();
	}

	public void mensagemSucessoExclusao() {
		JOptionPane.showMessageDialog(null, "Os dados foram excluidos com sucesso!", null,
				JOptionPane.INFORMATION_MESSAGE);
		cadastroVacina.dispose();
	}
	public void mensagemErroExclusao() {
		JOptionPane.showMessageDialog(null,
				"Ocorreu um erro ao excluir o dado.\n "
						+ "Verifique se a Ave está cadastrada\n",
				null, JOptionPane.ERROR_MESSAGE);
	}
}
