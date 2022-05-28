package br.com.sfdio.java_avancado;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorExemplo {

	private static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(3);

	public ExecutorExemplo() {
		Casa casa = new Casa(new Quarto());
		casa.obterAFazerDaCasa().forEach(atividade -> EXECUTOR_SERVICE.execute(() -> atividade.realizar()));
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

		@Override
		List<Atividade> obterAFazerDoComodo() {
			return Arrays.asList(this::varrer, this::arrumarCama, this::arrumarGrardaRoupa, this::arrumarPenteadeira);
		}

		private void varrer() {
			System.out.println("Varrendo...");
		}

		private void arrumarGrardaRoupa() {
			System.out.println("arrumarGrardaRoupa...");
		}

		private void arrumarCama() {
			System.out.println("arrumarCama...");
		}
		
		private void arrumarPenteadeira() {
			System.out.println("arrumarPenteadeira...");
		}
	}

	public interface Atividade {
		void realizar();
	}
}