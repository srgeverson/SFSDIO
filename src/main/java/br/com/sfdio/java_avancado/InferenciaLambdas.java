package br.com.sfdio.java_avancado;

import java.util.Arrays;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class InferenciaLambdas {

	public void dividePor2() {
		Function<Integer, Double> numeroParaDividir = (var numero) -> numero / 2.0;
		System.out.println(numeroParaDividir.apply(15));
	}

	public void paravraEBranco() {
		var espaco = "                    ";
		System.out.println(espaco != null || espaco.length() == 0
				|| espaco.chars().allMatch(caractereEspaco -> caractereEspaco == ' '));
	}

	public void pagina() {
		var html = "<!DOCTYPE html>\n<html>\n<head></head>\n<body>\n<h1>My First Heading</h1>\n<p>My first paragraph.</p>\n</body>\n</html>";
		System.out.println(html.lines().filter(tag -> tag.contains("<head>")).collect(Collectors.joining()));
		System.out.println(html.lines().map(tag -> "[TAG] :: " + tag).collect(Collectors.joining()));
	}

	public void valoresLista() {
		String[] nomes = { "Geverson", "José", "De", "Souza" };
		System.out.println(Arrays.asList(nomes));// Ordena pela ordem de inclusão
		System.out.println(Set.of(nomes));// Não gruada a ordem
	}

	public void valoresRepete() {
		var nome = "Geverson";
		var auxiliar = "";
		for (int i = 0; i < nome.length(); i++)
			auxiliar += nome;
		System.out.println("Maneira anerior ao Java 11 :: " + auxiliar);
		System.out.println("Maneira com Java 11 :: " + nome.repeat(nome.length()));
	}
}
