package model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import logging.Logger;

public class FachadaCadastramentoPessoas {
	
	Logger logger  = Logger.getInstancia();
	
	Set<Pessoa> pessoasCadastradas = new HashSet<Pessoa>();

	public void cadastrar(String nome, LocalDate dataNasc) {
		/* TODO SINGLETON.01
		 * 
		 * 1. Crie um objeto da classe Pessoa com os atributos passados como entrada deste metodo.
		 * 
		 * 2. Registre no objeto Logger a seguinte mensagem informativa:
		 * "PROCESSANDO CADASTRAMENTO DE PESSOA ---> nome: <nome>. idade: <idade>." 
		 * 
		 * 3. Verifique se a pessoa é maior de 18 anos. Se maior, adicione-a 
		 * na colecao this.pessoasCadastradas e registre no objeto Logger a seguinte mensagem de debug: 
		 * "CADASTRAMENTO DE PESSOA REALIZADO COM SUCESSO ---> nome: <nome>." 
		 * 
		 * 3. Se a pessoa for de menor, registre no objeto Logger a seguinte mensagem de erro: 
		 * "CADASTRAMENTO DE PESSOA INVALIDO ---> nome: <nome>. Eh menor de idade".
		 * 
		*/
		
		//1
		Pessoa pessoa = new Pessoa();
		pessoa.setNome(nome);
		pessoa.setDataNascimento(dataNasc);
		
		//2
		LocalDate localDate = LocalDate.now();
		int idade = localDate.getYear() - dataNasc.getYear();
		logger.registrarMensagemInformativa("PROCESSANDO CADASTRAMENTO DE PESSOA ---> nome: "+ nome + " idade: "+ idade);
		
		//3
		if (idade >= 18) {
			this.pessoasCadastradas.add(pessoa);
			logger.registrarMensagemDebug("CADASTRAMENTO DE PESSOA REALIZADO COM SUCESSO ---> nome: "+ nome);
		}else {
			logger.registrarMensagemErro("CADASTRAMENTO DE PESSOA INVALIDO ---> nome: "+ nome + " Eh menor de idade");
		}
		
	}
	
	public void remover(String nome) {
		/* TODO SINGLETON.02
		 * 
		 * 1. Remova em this.pessoasCadastradas aquela pessoa com o nome passada como parametro
		 * de entrada deste metodo e registre a seguinte mensagem informativa em caso de sucesso:
		 * "DESCADASTRAMENTO DE PESSOA REALIZADO COM SUCESSO ---> nome <nome>." 
		 * 
		 * 2. Caso nao seja possivel remover a pessoa por nao estar em this.pessoasCadastradas,
		 * registre a seguinte mensagem de erro:
		 * "DESCADASTRAMENTO DE PESSOA NAO ENCONTRADA ---> nome <nome>." 
		 * 
		 */
		
		//1
		for (Pessoa pessoa : pessoasCadastradas) {
			if(pessoa.getNome().equals(nome)) {
				this.pessoasCadastradas.remove(pessoa);
				logger.registrarMensagemInformativa("DESCADASTRAMENTO DE PESSOA REALIZADO COM SUCESSO ---> nome: "+ nome);
			}else {
				//2
				logger.registrarMensagemErro("DESCADASTRAMENTO DE PESSOA NAO ENCONTRADA ---> nome: "+ nome);
			}
		}
		
	}
	
}
