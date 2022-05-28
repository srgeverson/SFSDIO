package br.com.sfdio.java_avancado;

import java.util.stream.IntStream;

public class OtimizacaoDeExecucaoDeListas {

	private long tempoDeInicio;
	private long tempoDeFim;

	public OtimizacaoDeExecucaoDeListas(Boolean utilizandoOtimizacao) {
		if (utilizandoOtimizacao) {
			tempoDeInicio = System.currentTimeMillis();
			IntStream.range(1, 100000).parallel().forEach(numero -> calculaFatorial(numero));
			tempoDeFim = System.currentTimeMillis();
			System.out.println(
					"Tempo de excução do Parallel Stream :: " + calculaTempoDeExecucao(tempoDeInicio, tempoDeFim));
		} else {
			tempoDeInicio = System.currentTimeMillis();
			IntStream.range(1, 100000).forEach(numero -> calculaFatorial(numero));
			tempoDeFim = System.currentTimeMillis();
			System.out.println("Tempo de excução do Serial :: " + calculaTempoDeExecucao(tempoDeInicio, tempoDeFim));
		}
	}

	private long calculaFatorial(long numero) {
		long fatorial = 1;
		for (int i = 2; i <= numero; i++)
			fatorial *= i;
		return fatorial;
	}

	private long calculaTempoDeExecucao(long inicio, long fim) {
		return fim - inicio;
	}
}
