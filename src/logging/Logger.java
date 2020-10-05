package logging;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * TODO SINGLETON.04.1
 * 
 * 1. Esta classe serve como um objeto que registra informacoes na execucao de rotinas da aplicacao.
 * 2. Modifique esa classe para que se torne um singleton, com instanciacao tardia.
 * 
 */
public class Logger {

	private Set<String> mensagens = new LinkedHashSet<String>();

	private boolean interativo = false;
	
	//2
	private static Logger instancia;
	
	private Logger() {
		
	}
	
	public static synchronized Logger getInstancia() {
		if (instancia == null) {
			instancia =  new Logger();
		}
		return instancia;
	}


	public void registrarMensagemInformativa(String msg) {
		msg = "[INFO] ("+getDataHora()+") "+msg;
		this.mensagens.add(getDataHora()+" "+msg);
		if (interativo)
			System.out.println(msg);
	}

	public void registrarMensagemDebug(String msg) {
		msg = "[DEBUG] ("+getDataHora()+") "+msg;
		this.mensagens.add(getDataHora()+" "+msg);
		if (interativo)
			System.out.println(msg);
	}

	public void registrarMensagemErro(String msg) {
		msg = "[ERRO] ("+getDataHora()+") "+msg;
		this.mensagens.add(getDataHora()+" "+msg);
		if (interativo)
			System.out.println(msg);
	}

	public void mostrarMensagensInformativas() {
		for (String msg : this.mensagens) {
			if (msg.contains("[INFO]"))
				System.out.println(msg);
		}
	}

	public void mostrarMensagensDebug() {
		for (String msg : this.mensagens) {
			if (msg.contains("[DEBUG]"))
				System.out.println(msg);
		}
	}

	public void mostrarMensagensErro() {
		for (String msg : this.mensagens) {
			if (msg.contains("[ERRO]"))
				System.out.println(msg);
		}
	}

	public void mostrarTodasMensagens() {
		for (String msg : this.mensagens) {
			System.out.println(msg);
		}
	}

	public void setInterativo(boolean interativo) {
		this.interativo = interativo;
	}

	private String getDataHora() {
		LocalDateTime timestamp = LocalDateTime.now();
		return timestamp.format(DateTimeFormatter.ofPattern("dd/MM/YYYY HH:mm:ss"));
	}


}
