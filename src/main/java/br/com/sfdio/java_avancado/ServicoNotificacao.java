package br.com.sfdio.java_avancado;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServicoNotificacao {

	private static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(3);

	public ServicoNotificacao(TipoCliente tipoCliente) {
		Cliente cliente = null;
		if (tipoCliente == TipoCliente.PF)
			cliente = new Cliente(new ClientePF());
		else if (tipoCliente == TipoCliente.PJ)
			cliente = new Cliente(new ClientePJ());
		if (cliente != null) {
			cliente.obterAsNotificacosDoCliente()
					.forEach(processo -> EXECUTOR_SERVICE.execute(() -> processo.notificar()));
			EXECUTOR_SERVICE.shutdown();
		} else
			System.out.println("Não foi informado um tipo de cliente para realizar o processo de notificação!");
	}

	public enum TipoCliente {
		PF, PJ
	}

	public class Cliente {
		private List<Notificacao> notificacaos;

		public Cliente(Notificacao... notificacaos) {
			this.notificacaos = Arrays.asList(notificacaos);
		}

		public List<Processo> obterAsNotificacosDoCliente() {
			return this.notificacaos.stream().map(Notificacao::obterNotificacoes).reduce(new ArrayList<Processo>(),
					(pivo, processos) -> {
						pivo.addAll(processos);
						return pivo;
					});
		}
	}

	public abstract class Notificacao {
		abstract List<Processo> obterNotificacoes();
	}

	public class ClientePF extends Notificacao {

		@Override
		List<Processo> obterNotificacoes() {
			return Arrays.asList(this::celular, this::email, this::sms, this::whatsapp);
		}

		private static String NOME_NOTIFICACAO = ClientePF.class.getName() + " notificando por %s";

		private void celular() {
			System.out.println(String.format(NOME_NOTIFICACAO, "celular..."));
		}

		private void email() {
			System.out.println(String.format(NOME_NOTIFICACAO, "email..."));
		}

		private void sms() {
			System.out.println(String.format(NOME_NOTIFICACAO, "sms..."));
		}

		private void whatsapp() {
			System.out.println(String.format(NOME_NOTIFICACAO, "whatsapp..."));
		}
	}

	public class ClientePJ extends Notificacao {

		@Override
		List<Processo> obterNotificacoes() {
			return Arrays.asList(this::email, this::telefone, this::whatsapp);
		}

		private static String NOME_NOTIFICACAO = ClientePJ.class.getName() + " notificando por %s";

		private void email() {
			System.out.println(String.format(NOME_NOTIFICACAO, "email..."));
		}

		private void telefone() {
			System.out.println(String.format(NOME_NOTIFICACAO, "telefone..."));
		}

		private void whatsapp() {
			System.out.println(String.format(NOME_NOTIFICACAO, "whatsapp..."));
		}
	}

	public interface Processo {
		void notificar();
	}
}