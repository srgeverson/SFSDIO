package br.com.sfdio.java_avancado;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class ServicoNotificacaoEAcompanhandoEnvio {

	private static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(3);

	public ServicoNotificacaoEAcompanhandoEnvio(TipoCliente tipoCliente) {
		Cliente cliente = null;
		if (tipoCliente == TipoCliente.PF)
			cliente = new Cliente(new ClientePF());
		else if (tipoCliente == TipoCliente.PJ)
			cliente = new Cliente(new ClientePJ());
		if (cliente != null) {
			List<? extends Future<String>> futures = new CopyOnWriteArrayList<>(
					cliente.obterAsNotificacosDoCliente().stream().map(processo -> EXECUTOR_SERVICE.submit(() -> {
						return processo.notificar();
					})).collect(Collectors.toList()));
			while (true) {
				int numeroDeAtividadesNaoFinalizada = 0;
				for (Future<?> future : futures) {
					if (future.isDone())
						try {
							System.out.println("Concluído :: " + future.get());
							futures.remove(future);
						} catch (InterruptedException | ExecutionException e) {
							e.printStackTrace();
						}
					else
						numeroDeAtividadesNaoFinalizada++;
				}
				if (futures.stream().allMatch(Future::isDone))
					break;
				try {
					Thread.sleep(1000);
					System.out.println("Número de ativiades não finalizadas = " + numeroDeAtividadesNaoFinalizada);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
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
		String format = "";

		private String celular() {
			format = String.format(NOME_NOTIFICACAO, "celular...");
			try {
				Thread.sleep(ServicoUltil.gerarSegundosAleatorioDe100a5000());
				System.out.println(format);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return format;
		}

		private String email() {
			format = String.format(NOME_NOTIFICACAO, "email...");
			try {
				Thread.sleep(ServicoUltil.gerarSegundosAleatorioDe100a5000());
				System.out.println(format);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return format;
		}

		private String sms() {
			format = String.format(NOME_NOTIFICACAO, "sms...");
			try {
				Thread.sleep(ServicoUltil.gerarSegundosAleatorioDe100a5000());
				System.out.println(format);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return format;
		}

		private String whatsapp() {
			format = String.format(NOME_NOTIFICACAO, "whatsapp...");
			try {
				Thread.sleep(ServicoUltil.gerarSegundosAleatorioDe100a5000());
				System.out.println(format);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return format;
		}
	}

	public class ServicoUltil {

		public static int gerarSegundosAleatorioDe100a5000() {
			Random random = new Random();
			return random.nextInt((5000 - 100) + 1) + 100;
		}
	}

	public class ClientePJ extends Notificacao {

		@Override
		List<Processo> obterNotificacoes() {
			return Arrays.asList(this::email, this::telefone, this::whatsapp);
		}

		private static String NOME_NOTIFICACAO = ClientePJ.class.getName() + " notificando por %s";
		String format = "";

		private String email() {
			format = String.format(NOME_NOTIFICACAO, "email...");
			try {
				Thread.sleep(ServicoUltil.gerarSegundosAleatorioDe100a5000());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(format);
			return format;
		}

		private String telefone() {
			format = String.format(NOME_NOTIFICACAO, "telefone...");
			try {
				Thread.sleep(ServicoUltil.gerarSegundosAleatorioDe100a5000());
				System.out.println(format);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return format;
		}

		private String whatsapp() {
			format = String.format(NOME_NOTIFICACAO, "whatsapp...");
			try {
				Thread.sleep(ServicoUltil.gerarSegundosAleatorioDe100a5000());
				System.out.println(format);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return format;
		}
	}

	public interface Processo {
		String notificar();
	}
}