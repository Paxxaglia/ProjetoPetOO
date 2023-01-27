package view;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

import javax.swing.*;

import controle.ControleDados;

/**
 * Tela que permite cadastrar/editar as vacinas
 * 
 * @author Iago Passaglia
 * @version 1.0
 */
public class TelaDetalheVacina implements ActionListener {

	/*
	 * Criando os artigos visuais da tela
	 */

	private boolean validacaoData;
	private JTextField tipoVacina = new JTextField(10);
	private JTextField dataVacina = new JTextField(10);
	private JTextField tempoRevacina = new JTextField(10);
	private JButton botaoSalvar = new JButton(" Salvar ");
	private JButton botaoExcluir = new JButton(" Excluir ");
	private String[] novoDado = new String[8];
	private ControleDados dados;
	private JFrame cadastroVacina = new JFrame("Projeto Pet - Cadastro de Vacina");
	private JLabel instrucaoPet = new JLabel(" Selecione o animal vacinado ");
	private JLabel instrucaoTipo = new JLabel(" Digite o tipo da vacina: ");
	private JLabel instrucaoData = new JLabel(" Digite a data da vacina: ");
	private JLabel instrucaoRevacina = new JLabel(" Tempo de revacina (Em meses):");
	private JLabel informativo = new JLabel(
			"<html>" + "Caso não seja necessário revacina," + "<br>"
					+ "informe que o tempo de revacina é 0" + "</html>");

	private int posicao;
	private int opcao;

	/**
	 * Metodo que valida se a data inserida é valida ou nao
	 * @param data data que deseja validar
	 * @return true para data valida e false para invalida
	 */
	public static boolean validaData(String data) {
		String dateFormat = "dd/MM/uuuu";

		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(dateFormat)
				.withResolverStyle(ResolverStyle.STRICT);
		try {
			LocalDate date = LocalDate.parse(data, dateTimeFormatter);
			return true;
		} catch (DateTimeParseException e) {
			return false;
		}
	}

	/**
	 * Método que cria a tela de detalhe da vacina para edição/cadastro
	 * 
	 * @param op  Cadastro ou edição de vacina( 1 para edicao e 0 para cadastro)
	 * @param d   definição do controleDados
	 * @param a   ligacao com a telaVacina
	 * @param pos posicao da vacina que será editada
	 */
	public void inserirEditar(int op, ControleDados d, TelaVacina a, int pos) {

		dados = new ControleDados();

		Font Arial = new Font("Arial Black", Font.BOLD, 30);

		opcao = op;
		dados = d;
		posicao = pos;

		/*
		 * Definições dos estilos
		 */

		instrucaoTipo.setForeground(Color.yellow);
		instrucaoData.setForeground(Color.yellow);
		instrucaoRevacina.setForeground(Color.yellow);
		instrucaoPet.setForeground(Color.yellow);
		informativo.setForeground(Color.yellow);
		tempoRevacina.setBackground(Color.LIGHT_GRAY);
		dataVacina.setBackground(Color.LIGHT_GRAY);
		tipoVacina.setBackground(Color.LIGHT_GRAY);

		/*
		 * estilo dos botoes
		 */

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

		/*
		 * alterações de design da tela
		 */

		cadastroVacina.setBackground(Color.black);
		cadastroVacina.setSize(350, 550);
		cadastroVacina.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 50));
		cadastroVacina.setVisible(true);
		cadastroVacina.getContentPane().setBackground(Color.darkGray);
		cadastroVacina.setLocationRelativeTo(null);

		/*
		 * adicionando os objetos gráficos na tela
		 */

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

		botaoExcluir.addActionListener(this);
		botaoSalvar.addActionListener(this);

		/*
		 * Preenche a tela com dados da vacina clicada
		 */
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

			try {
				boolean res = false;

				/*
				 * cadastrar nova vacina
				 * 
				 */

				if (opcao == 0)
					novoDado[0] = Integer.toString(dados.getQtdVacinas());
				else
					novoDado[0] = Integer.toString(posicao);

				/*
				 * salvar os dados inseridos na vacina cadastrada ou editada
				 * 
				 */

				novoDado[1] = tipoVacina.getText();
				novoDado[2] = dataVacina.getText();
				novoDado[3] = tempoRevacina.getText();

				validacaoData = validaData(dataVacina.getText());
				
				if (validacaoData == true) {
				res = dados.cadastrarVacina(novoDado);
				}else {
					mensagemErroData();
				}

				if(res) {
					mensagemSucessoCadastro();
				}
				/*
				 * insere mensagem de sucesso caso os dados tenham sido inseridos de
				 * acordo e mensagem de erro caso falte algum dado ou esteja diferente do
				 * previsto
				 */

			} catch (NumberFormatException exc2) {
				mensagemErroCadastro();
			}
		}

		if (src == botaoExcluir) {
			boolean res = false;

			/*
			 * exclui vacina
			 */

			if (opcao == 1) {
				res = dados.removerVacina(posicao);

				try {
					if (res)
						mensagemSucessoExclusao();
				} catch (NumberFormatException e2) {
					mensagemErroCadastro();
				}

			}
		}
	}

	public void mensagemErroData() {
		JOptionPane.showMessageDialog(null, "A data inserida não é válida", null,
				JOptionPane.INFORMATION_MESSAGE);
	}

	public void mensagemSucessoCadastro() {
		JOptionPane.showMessageDialog(null, "Os dados foram salvos com sucesso!", null,
				JOptionPane.INFORMATION_MESSAGE);
		cadastroVacina.dispose();
	}

	public void mensagemErroCadastro() {
		JOptionPane.showMessageDialog(null,
				"Não foi possivel cadastrar, verifique se os dados estão preenchidos corretamente!",
				null, JOptionPane.INFORMATION_MESSAGE);
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
