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

public class ExecutorExemplo {

	private static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(3);

	public ExecutorExemplo() {
		Casa casa = new Casa(new Quarto());
		List<? extends Future<String>> futures = new CopyOnWriteArrayList<>(
				casa.obterAFazerDaCasa().stream().map(atividade -> EXECUTOR_SERVICE.submit(() -> {
					return atividade.realizar();
				})).collect(Collectors.toList()));
		while (true) {
			int numeroDeAtividadesNaoFinalizada = 0;
			for (Future<?> future : futures) {
				if (future.isDone())
					try {
						System.out.println("Concluído..." + future.get());
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
	}

	public class Casa {
		private List<Comodo> comodos;

		public Casa(Comodo... comodos) {
			this.comodos = Arrays.asList(comodos);
		}

		public List<Atividade> obterAFazerDaCasa() {
			return this.comodos.stream().map(Comodo::obterAFazerDoComodo).reduce(new ArrayList<Atividade>(),
					(pivo, atividades) -> {
						pivo.addAll(atividades);
						return pivo;
					});
		}
	}

	public abstract class Comodo {
		abstract List<Atividade> obterAFazerDoComodo();
	}

	public class Quarto extends Comodo {

		private static final String ARRUMAR_PENTEADEIRA = "arrumarPenteadeira...";
		private static final String ARRUMAR_CAMA = "arrumarCama...";
		private static final String ARRUMAR_GRARDA_ROUPA = "arrumarGrardaRoupa...";
		private static final String VARRENDO = "Varrendo...";

		@Override
		List<Atividade> obterAFazerDoComodo() {
			return Arrays.asList(this::varrer, this::arrumarCama, this::arrumarGrardaRoupa, this::arrumarPenteadeira);
		}

		private String varrer() {
			try {
				Thread.sleep(gerarSegundosAleatorioDe100a5000());
				System.out.println(VARRENDO);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return VARRENDO;
		}

		private String arrumarGrardaRoupa() {
			try {
				Thread.sleep(gerarSegundosAleatorioDe100a5000());
				System.out.println(ARRUMAR_GRARDA_ROUPA);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return ARRUMAR_GRARDA_ROUPA;
		}

		private String arrumarCama() {
			try {
				Thread.sleep(gerarSegundosAleatorioDe100a5000());
				System.out.println(ARRUMAR_CAMA);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return ARRUMAR_CAMA;
		}

		private String arrumarPenteadeira() {
			try {
				Thread.sleep(gerarSegundosAleatorioDe100a5000());
				System.out.println(ARRUMAR_PENTEADEIRA);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return ARRUMAR_PENTEADEIRA;
		}

		private static int gerarSegundosAleatorioDe100a5000() {
			Random random = new Random();
			return random.nextInt((5000 - 100) + 1) + 100;
		}
	}

	public interface Atividade {
		String realizar();
	}
}