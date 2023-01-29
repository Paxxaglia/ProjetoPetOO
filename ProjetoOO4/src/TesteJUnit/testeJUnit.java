package TesteJUnit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import controle.ControleDados;
import view.TelaDetalheVacina;

/**
 * Classe para testes unitarios dos metodos
 * 
 * @author Iago Passaglia
 *
 */
public class testeJUnit {

	ControleDados dados = new ControleDados();
	String[] dadosCertos = new String[9];
	String[] dadosErrados = new String[9];

	/**
	 * Teste para o metodo de cadastro de cachorros
	 */

	@Test
	public void testCadastrarCachorro() {

		/*
		 * Cadastra um cachorro com as infos corretas abaixo abaixo
		 */

		dadosCertos[0] = "0";
		dadosCertos[1] = "Joao"; // nome
		dadosCertos[2] = "Macho"; // sexo
		dadosCertos[3] = "12"; // peso
		dadosCertos[4] = "20"; // idade
		dadosCertos[5] = "Medio"; // porte
		dadosCertos[6] = "30"; // tempo de passeio
		dadosCertos[7] = "Border collie"; // raça

		/*
		 * Cadastra um cachorro com as infos incorretas abaixo abaixo
		 */
		dadosErrados[0] = "0";
		dadosErrados[1] = "Joao"; // nome
		dadosErrados[2] = "Macho"; // sexo
		dadosErrados[3] = "doze"; // peso
		dadosErrados[4] = "20"; // idade
		dadosErrados[5] = "Grande"; // porte
		dadosErrados[6] = "30"; // tempo de passeio
		dadosErrados[7] = "Border collie"; // raça

		/*
		 * verifica se o metodo retornou True como deveria(se foi cadastrado com
		 * sucesso)
		 */
		assertTrue(dados.cadastrarCachorro(dadosCertos));

		/*
		 * verifica se o metodo resultou em um NumberFormatException po conta do peso
		 * que foi inserido uma String no lugar de um double
		 */

		assertThrows(NumberFormatException.class,
				() -> dados.cadastrarCachorro(dadosErrados));

	}

	/**
	 * Teste que verifica se o validador de data está funcionando corretamente
	 */
	@Test
	public void testValidaData() {

		String dataCorreta = "12/08/2003";
		String dataErrada = "29/02/2023"; // nao é ano bissexto

		assertTrue(TelaDetalheVacina.validaData(dataCorreta));
		assertFalse(TelaDetalheVacina.validaData(dataErrada));
	}

	/**
	 * Teste que verifica a busca de aves
	 */
	@Test
	public void testRemoverCachorro() {

		/*
		 * cadastra um cachorro para que possamos removê-lo
		 */

		dadosCertos[0] = "0";
		dadosCertos[1] = "Joao"; // nome
		dadosCertos[2] = "Macho"; // sexo
		dadosCertos[3] = "12"; // peso
		dadosCertos[4] = "20"; // idade
		dadosCertos[5] = "Medio"; // porte
		dadosCertos[6] = "30"; // tempo de passeio
		dadosCertos[7] = "Border collie"; // raça

		dados.cadastrarCachorro(dadosCertos);

		/*
		 * testa se conseguimos remover corretamente o cachorro da posicao 4 (existe)
		 * 
		 */
		assertTrue(dados.removerCachorro(4));
		
		/*
		 * testa se nao conseguimos remover corretamente o cachorro da posicao 5 (nao existe)
		 * 
		 */
		assertThrows(NullPointerException.class, () -> dados.removerCachorro(5));
	}

}
