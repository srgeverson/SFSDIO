package br.com.sfdio.java_avancado;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IterandoFuncao {

	public static void imprimindoNomesFiltradosAntigo(String... nomes) {
		String nomesParaImprimir = "";
		for (int i = 0; i < nomes.length; i++)
			if (nomes[i].equals("Geverson"))
				nomesParaImprimir += nomes[i];
		System.out.println(nomesParaImprimir);
	}

	public static void imprimindoNomesFiltradosNovo(String... nomes) {
		String nomesParaImprimir = Stream.of(nomes).filter(nome -> nome.equals("Geverson"))
				.collect(Collectors.joining());
		System.out.println(nomesParaImprimir);
	}
}
