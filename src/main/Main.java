package main;

import java.time.LocalDate;

import logging.Logger;
import model.FachadaCadastramentoPessoas;

public class Main {

	
	public static void main(String[] args) {
		/*
		 * TODO SINGLETON.03
		 * 
		 * 1.Execute este main().
		 * 
		 * 2. O logger exibiu na console as Todas as mensagens esperadas? 
		 * Tanto as registradas neste metodo, quanto em FachadaCadastramentoPessoas()?
		 * 
		 * [COLOQUE SUA RESPOSTA AQUI]
		 * 
		 * Não, ele mostrou apenas as mensagens registradas neste método.
		 */
		
		/*
		 * TODO SINGLETON.04.2
		 * 1. Altere este metodo para usar uma instancia de Logger sem dar new(),
		 * usando o singleton nela e no atributo logger da classe FachadaCadastramentoPessoas faca o mesmo, 
		 * para nao usar new() e sim o singleton. Mas antes, resolva o TODO SINGLETON.04.1. 
		 * 
		 * 2. Execute este main() novamente, agora com Logger sendo um singleton.
		 *  
		 * 3. O logger exibiu na console as todas as mensagens esperadas? 
		 * Tanto as registradas neste metodo, quanto em FachadaCadastramentoPessoas()? 
		 * Explique o porque e se foi diferente da execucao sem Logger como singleton.
		 * 
		 * [COLOQUE SUA RESPOSTA AQUI]
		 * 
		 * Sim, pois com a aplicação do Singleton, o objeto logger contido neste método e contido em
		 * FachadaCadastramentoPessoas se torna o mesmo, guardando todos os cadastros existentes dentro
		 * de si e sendo visto goblalmente com a mesma instância.
		 * 
		 */
		//1
		Logger logger = Logger.getInstancia();
		logger.registrarMensagemInformativa("VVV APLICACAO PRINCIPAL INICIADA!!!");			
		
		FachadaCadastramentoPessoas pessoaService = new FachadaCadastramentoPessoas();
		pessoaService.cadastrar("Fulano", LocalDate.of(1986, 5, 25));
		pessoaService.remover("Fulano");
		pessoaService.cadastrar("Cicrano", LocalDate.of(2015, 5, 25));
		pessoaService.remover("Cicrano");
		pessoaService.remover("Beltrano");
		
		logger.registrarMensagemInformativa("VVV APLICACAO PRINCIPAL ENCERRADA!!!");		
		
		logger.mostrarTodasMensagens();
		
	}
	
	
}
