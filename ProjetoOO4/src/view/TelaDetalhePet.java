package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controle.ControleDados;

/**
 * Tela para edição/cadastro de um pet
 * 
 * @author Iago Passaglia Pereira
 * @version 1.0
 */
public class TelaDetalhePet implements ActionListener {

	/*
	 * criação dos atributos da tela de detalhe
	 */

	private String sexoOpcoes[] = { "Macho", "Fêmea" };
	private String porteOpcoes[] = { "Pequeno", "Medio", "Grande" };
	private String CoresDePelo[] = { "Amarelo", "Branco", "Preto", "Cinza", "Rajado" };
	private String CoresDeOlho[] = { "Azul", "Amarelo", "Verde", "2" };
	private String tamanhoPelagens[] = { "Curto", "Longo" };
	private String[] novoDado = new String[8];
	private ControleDados dados = new ControleDados();
	private int posicao;
	private int opcao;
	private String s;

	private JTextField nome = new JTextField(10);
	private JTextField peso = new JTextField(10);
	private JTextField idade = new JTextField(10);
	private JTextField especieAve = new JTextField(10);// particularidade ave
	private JTextField mesCorte = new JTextField(10);// particularidade ave
	private JComboBox<String> sexo = new JComboBox<String>(sexoOpcoes);
	private JComboBox<String> porte = new JComboBox<String>(porteOpcoes); // particularidade
																			// cachorro
	private JComboBox<String> corPelo = new JComboBox<String>(CoresDePelo);// particularidade
																			// gato
	private JComboBox<String> corOlho = new JComboBox<String>(CoresDeOlho);// particularidade
																			// gato
	private JComboBox<String> tamanhoPelagem = new JComboBox<String>(tamanhoPelagens); // particularidade
																						// gato

	private JTextField tempoPasseio = new JTextField(10); // particularidade cachorro
	private JTextField raca = new JTextField(10); // particularidade cachorro

	private JButton botaoSalvar = new JButton(" Salvar ");
	private JButton botaoExcluir = new JButton(" Excluir ");
	private JButton botaoVacinas = new JButton("Vacinas");

	private JFrame telaCadastro = new JFrame("Projeto Pet - Cadastro de Pet");
	private JLabel intrucaoNome = new JLabel("Digite o nome do pet: ");
	private JLabel intrucaoSexo = new JLabel("Digite o sexo do pet: ");
	private JLabel intrucaoPeso = new JLabel("Digite o peso do pet (em KG): ");
	private JLabel intrucaoIdade = new JLabel("Digite a idade do pet (em meses): ");
	private JLabel instrucaoEspecie = new JLabel("Digite a espécie da ave : ");
	private JLabel instrucaoTempoPasseio = new JLabel("Digite o tempo de passeio: ");
	private JLabel instrucaoMesCorte = new JLabel("Digite o Mês de corte das asas: ");

	private JLabel instrucaoPelagem = new JLabel(
			"Digite o tamanho da pelagem (curta/longa): ");
	private JLabel instrucaoCorPelo = new JLabel("Selecione a cor da pelagem: ");
	private JLabel instrucaoCorOlho = new JLabel("Selecione a cor do olho:     ");

	private JLabel instrucaoPorte = new JLabel("Selecione o porte do cachorro: ");
	private JLabel instrucaoRaca = new JLabel("Digite a raca do cachorro:     ");
	private JLabel informativo = new JLabel(
			" Caso as asas nao sejam cortadas, " + "informe que o mes de corte é 0  ");

	/**
	 * Metodo que implementa os estilos dos artigos visuais da tela
	 */
	public void defineEstilos() {
		Font Arial = new Font("Arial Black", Font.BOLD, 25);
		intrucaoNome.setForeground(Color.yellow);
		intrucaoSexo.setForeground(Color.yellow);
		intrucaoPeso.setForeground(Color.yellow);
		intrucaoIdade.setForeground(Color.yellow);
		instrucaoTempoPasseio.setForeground(Color.yellow);
		instrucaoPorte.setForeground(Color.yellow);
		instrucaoRaca.setForeground(Color.yellow);
		instrucaoEspecie.setForeground(Color.yellow);
		instrucaoMesCorte.setForeground(Color.yellow);
		instrucaoPelagem.setForeground(Color.yellow);
		instrucaoCorOlho.setForeground(Color.yellow);
		instrucaoCorPelo.setForeground(Color.yellow);
		informativo.setForeground(Color.yellow);

		especieAve.setBackground(Color.LIGHT_GRAY);
		mesCorte.setBackground(Color.LIGHT_GRAY);
		idade.setBackground(Color.LIGHT_GRAY);
		peso.setBackground(Color.LIGHT_GRAY);
		sexo.setBackground(Color.LIGHT_GRAY);
		nome.setBackground(Color.LIGHT_GRAY);
		raca.setBackground(Color.LIGHT_GRAY);
		porte.setBackground(Color.LIGHT_GRAY);
		tempoPasseio.setBackground(Color.LIGHT_GRAY);
		tamanhoPelagem.setBackground(Color.LIGHT_GRAY);

		/*
		 * estilo do botao
		 */
		botaoExcluir.setForeground(Color.BLACK);
		botaoExcluir.setBackground(Color.YELLOW);
		botaoExcluir.setFont(Arial);
		botaoExcluir.setBorder(BorderFactory.createLineBorder(Color.orange, 2));
		botaoExcluir.setBounds(600, 200, 200, 200);

		botaoSalvar.setForeground(Color.BLACK);
		botaoSalvar.setBackground(Color.YELLOW);
		botaoSalvar.setFont(Arial);
		botaoSalvar.setBorder(BorderFactory.createLineBorder(Color.orange, 2));
		botaoSalvar.setBounds(600, 200, 200, 200);

		botaoVacinas.setForeground(Color.BLACK);
		botaoVacinas.setBackground(Color.YELLOW);
		botaoVacinas.setFont(Arial);
		botaoVacinas.setBorder(BorderFactory.createLineBorder(Color.orange, 2));
		botaoVacinas.setBounds(600, 200, 200, 200);

		/*
		 * alteracoes de design da tela
		 */

		telaCadastro.setBackground(Color.black);
		telaCadastro.setSize(400, 750);
		telaCadastro.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 50));
		telaCadastro.setVisible(true);
		telaCadastro.getContentPane().setBackground(Color.darkGray);
		telaCadastro.setLocationRelativeTo(null);
	}

	/*
	 * Metodo que cria a tela de acordo com a opcao selecionada
	 */
	public void inserirEditar(int op, ControleDados d, TelaPets a, int pos) {

		/*
		 * Definicao dos estilos
		 */

		opcao = op;
		posicao = pos;
		dados = d;

		if (op == 1)
			s = "Cadastro de Ave";
		if (op == 2)
			s = "Cadastro de Cachorro";
		if (op == 3)
			s = "Cadastro de Gato";
		if (op == 4)
			s = "Cadastro de Vacina";
		if (op == 5)
			s = "Detalhe de Ave";
		if (op == 6)
			s = "Detalhe de Cachorro";
		if (op == 7)
			s = "Detalhe de Gato";
		if (op == 8)
			s = "Detalhe de Vacina";

		telaCadastro = new JFrame(s);

		/*
		 * Preenche dados com dados da ave clicada
		 */
		if (op == 5) {

			defineEstilos();
			nome.setText(dados.getAves()[pos].getNome());
			sexo.setSelectedItem(dados.getAves()[pos].getSexo());
			peso.setText(String.valueOf(dados.getAves()[pos].getPeso()));
			idade.setText(String.valueOf(dados.getAves()[pos].getIdade()));
			mesCorte.setText(String.valueOf(dados.getAves()[pos].getMesCorte()));
			especieAve.setText(dados.getAves()[pos].getEspecie());

		}

		/*
		 * adiciona a tela de cadastro de ave
		 */
		if (op == 1 || op == 5) {

			// adicionando os artigos visuais

			defineEstilos();
			telaCadastro.add(intrucaoNome);
			telaCadastro.add(nome);
			telaCadastro.add(intrucaoSexo);
			telaCadastro.add(sexo);
			telaCadastro.add(intrucaoPeso);
			telaCadastro.add(peso);
			telaCadastro.add(intrucaoIdade);
			telaCadastro.add(idade);
			telaCadastro.add(instrucaoEspecie);
			telaCadastro.add(especieAve);
			telaCadastro.add(instrucaoMesCorte);
			telaCadastro.add(mesCorte);
			telaCadastro.add(informativo);
			telaCadastro.add(botaoSalvar);
			botaoSalvar.addActionListener(this);

		}
		/*
		 * editar ave
		 */
		if (op == 5) {
			defineEstilos();
			telaCadastro.add(botaoExcluir);
			telaCadastro.add(botaoVacinas);
			botaoVacinas.addActionListener(this);
			botaoExcluir.addActionListener(this);

		}

		/*
		 * preenche a lista com os dados do cachorro clicado
		 */
		if (op == 6) {

			defineEstilos();

			nome.setText(dados.getCachorros()[pos].getNome());
			sexo.setSelectedItem(dados.getCachorros()[pos].getSexo());
			peso.setText(String.valueOf(dados.getCachorros()[pos].getPeso()));
			idade.setText(String.valueOf(dados.getCachorros()[pos].getIdade()));
			porte.setSelectedItem(dados.getCachorros()[pos].getPorte());
			tempoPasseio
					.setText(String.valueOf(dados.getCachorros()[pos].getTempoPasseio()));
			raca.setText(dados.getCachorros()[pos].getRaca());

		}

		/*
		 * preenche a lista com os dados do gato clicado
		 */

		if (op == 7) {

			defineEstilos();
			nome.setText(dados.getGatos()[pos].getNome());
			sexo.setSelectedItem(dados.getGatos()[pos].getSexo());
			peso.setText(String.valueOf(dados.getGatos()[pos].getPeso()));
			idade.setText(String.valueOf(dados.getGatos()[pos].getIdade()));
			corPelo.setSelectedItem(dados.getGatos()[pos].getCorPelo());
			corOlho.setSelectedItem(dados.getGatos()[pos].getCorOlho());

			tamanhoPelagem.setSelectedItem(dados.getGatos()[pos].getTamanhoPelagem());
		}

		/*
		 * adiciona a tela de cadastro de Cachorro
		 */
		if (op == 2 || op == 6) {

			/*
			 * editar ou cadastrar cachorro
			 */

			/*
			 * adicionando os atributos visuais na tela
			 */

			defineEstilos();
			telaCadastro.add(intrucaoNome);
			telaCadastro.add(nome);
			telaCadastro.add(intrucaoSexo);
			telaCadastro.add(sexo);
			telaCadastro.add(intrucaoPeso);
			telaCadastro.add(peso);
			telaCadastro.add(intrucaoIdade);
			telaCadastro.add(idade);
			telaCadastro.add(instrucaoPorte);
			telaCadastro.add(porte);
			telaCadastro.add(instrucaoTempoPasseio);
			telaCadastro.add(tempoPasseio);
			telaCadastro.add(instrucaoRaca);
			telaCadastro.add(raca);

			telaCadastro.add(botaoSalvar);
			botaoSalvar.addActionListener(this);

		}

		/*
		 * editar cachorro
		 */
		if (op == 6) {
			defineEstilos();
			telaCadastro.add(botaoExcluir);
			botaoExcluir.addActionListener(this);
			telaCadastro.add(botaoVacinas);
			botaoVacinas.addActionListener(this);
		}

		/*
		 * adiciona a tela de cadastro de Gato
		 */
		if (op == 3 || op == 7) {
			/*
			 * editar ou cadastrar Gato
			 */

			/*
			 * adicionando os artigos visuais na tela
			 */

			defineEstilos();
			telaCadastro.add(intrucaoNome);
			telaCadastro.add(nome);
			telaCadastro.add(intrucaoSexo);
			telaCadastro.add(sexo);
			telaCadastro.add(intrucaoPeso);
			telaCadastro.add(peso);
			telaCadastro.add(intrucaoIdade);
			telaCadastro.add(idade);
			telaCadastro.add(instrucaoCorPelo);
			telaCadastro.add(corPelo);
			telaCadastro.add(instrucaoCorOlho);
			telaCadastro.add(corOlho);
			telaCadastro.add(instrucaoPelagem);
			telaCadastro.add(tamanhoPelagem);

			telaCadastro.add(botaoSalvar);
			botaoSalvar.addActionListener(this);

		}
		if (op == 7) {

			/*
			 * editar gato
			 */
			defineEstilos();
			telaCadastro.add(botaoExcluir);
			botaoExcluir.addActionListener(this);
			telaCadastro.add(botaoVacinas);
			botaoVacinas.addActionListener(this);
			
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object src = e.getSource();
		try {
			if (src == botaoSalvar) {

				boolean res = false;

				if (opcao == 1) // cadastrar nova ave
					novoDado[0] = Integer.toString(dados.getQtdAves());
				else if (opcao == 2) // cadastrar novo cachorro
					novoDado[0] = Integer.toString(dados.getQtdCachorros());
				else if (opcao == 3)// cadastrar novo gato
					novoDado[0] = Integer.toString(dados.getQtdGatos());
				else // editar dado existente
					novoDado[0] = Integer.toString(posicao);

				if (opcao == 1 || opcao == 5) { // salvar os dados inseridos de aves

					novoDado[1] = nome.getText();
					novoDado[2] = sexo.getSelectedItem().toString();
					novoDado[3] = peso.getText();
					novoDado[4] = idade.getText();
					novoDado[5] = mesCorte.getText();
					novoDado[6] = especieAve.getText();

					res = dados.cadastrarAve(novoDado);

				} else if (opcao == 2 || opcao == 6) { // salva os dados inseridos de
														// cachorros
					novoDado[1] = nome.getText();
					novoDado[2] = (String) sexo.getSelectedItem();
					novoDado[3] = peso.getText();
					novoDado[4] = idade.getText();
					novoDado[5] = (String) porte.getSelectedItem();
					novoDado[6] = tempoPasseio.getText();
					novoDado[7] = raca.getText();

					res = dados.cadastrarCachorro(novoDado);

				} else if (opcao == 3 || opcao == 7) { // salva os dados inseridos de gato
					novoDado[1] = nome.getText();
					novoDado[2] = (String) sexo.getSelectedItem();
					novoDado[3] = peso.getText();
					novoDado[4] = idade.getText();
					novoDado[5] = (String) corPelo.getSelectedItem();
					novoDado[6] = (String) corOlho.getSelectedItem();
					novoDado[7] = (String) tamanhoPelagem.getSelectedItem();

					res = dados.cadastrarGato(novoDado);

				}

				if (res) {
					mensagemSucessoCadastro();
				} else
					mensagemErroCadastro();
			}
		} catch (NullPointerException exc1) {
			mensagemErroCadastro();
		} catch (NumberFormatException exc2) {
			mensagemErroCadastro();
		}

		if (src == botaoExcluir) {
			boolean res = false;

			// exclui ave

			if (opcao == 5) {
				res = dados.removerAve(posicao);
				if (res)
					mensagemSucessoExclusao();
				else
					mensagemErroExclusao();

			} else if (opcao == 6) {

				// exclui cachorro
				res = dados.removerCachorro(posicao);
				if (res)
					mensagemSucessoExclusao();
				else
					mensagemErroExclusao();
			} else if (opcao == 7) {

				// exclui gato
				res = dados.removerGato(posicao);
				if (res)
					mensagemSucessoExclusao();
				else
					mensagemErroExclusao();
			}
		}

		if (src == botaoVacinas) {

			// Mostra vacinas do pet

			if (opcao == 5) {

				new TelaVacina().mostrarDados(dados, posicao);

			}
			if (opcao == 6) {
				new TelaVacina().mostrarDados(dados, posicao);
			}
			if (opcao == 7) {
				new TelaVacina().mostrarDados(dados, posicao);
			}
		}
	}

	public void mensagemSucessoCadastro() {
		JOptionPane.showMessageDialog(null, "Os dados foram salvos com sucesso!", null,
				JOptionPane.INFORMATION_MESSAGE);
		telaCadastro.dispose();
	}

	public void mensagemErroCadastro() {
		JOptionPane.showMessageDialog(null,
				"Os dados nao foram salvos, verifique se está tudo correto", null,
				JOptionPane.INFORMATION_MESSAGE);
	}

	public void mensagemSucessoExclusao() {
		JOptionPane.showMessageDialog(null, "Os dados foram excluidos com sucesso!", null,
				JOptionPane.INFORMATION_MESSAGE);
		telaCadastro.dispose();
	}

	public void mensagemErroExclusao() {
		JOptionPane.showMessageDialog(null,
				"Ocorreu um erro ao excluir o dado.\n "
						+ "Verifique se a Ave está cadastrada\n",
				null, JOptionPane.ERROR_MESSAGE);
	}
}
