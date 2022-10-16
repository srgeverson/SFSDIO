package br.com.sfdio.collections_streams;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class ExemploStream {

	public void bacico() {
		Queue<String> estudantes = new LinkedList<>();
		estudantes.add("Patrícia");// 0
		estudantes.add("Roberto");// 1
		estudantes.add("Flávio");// 2
		estudantes.add("Pamela");// 3
		estudantes.add("Andeson");// 4
		estudantes.add("Roberto");// 5
		estudantes.add("Geverson");// 6

		System.out.println(String.format("Count: %s", estudantes.stream().count()));

		System.out.println(String.format("Nome de estudande com quantidade de letras  menor é %s",
				estudantes.stream().min(Comparator.comparingInt(String::length))));

		System.out.println(String.format("Nome de estudande com quantidade de letras  maior é %s",
				estudantes.stream().max(Comparator.comparingInt(String::length))));

		System.out.println(String.format("Nomes de estudande que contem a letra R é %s", estudantes.stream()
				.filter((estudante) -> estudante.toLowerCase().contains("r")).collect(Collectors.toList())));

		System.out.println(String.format("Os 3 primeiros estudantes ão %s",
				estudantes.stream().limit(3).collect(Collectors.toList())));

		System.out.println(String.format("Exibe cada elemento no console e em seguida retorna a mesma coleção %s",
				estudantes.stream().peek(System.out::println).collect(Collectors.toList())));

		estudantes.stream().forEach(System.out::println);

		System.out.println(String.format("Existe algum nome com a letra W %s",
				estudantes.stream().allMatch((estudante) -> estudante.contains("W"))));

		System.out.println(String.format("Existe algum nome com a letra á %s",
				estudantes.stream().anyMatch((estudante) -> estudante.contains("á"))));

		System.out.print(String.format("O primeiro elemento é "));
		estudantes.stream().findFirst().ifPresent(System.out::println);

		System.out.println(String.format("Operação encadeada %s", //
				estudantes // Original
						.stream().peek(System.out::println)// imprime cada elemento da lista
						.map((estudante) -> estudante.concat(" - ").concat(String.valueOf(estudante.length())))// nova
																												// Lista
																												// tratada
						.peek(System.out::println)// imprime cada elemento da lista
						.filter((estudante) -> estudante.toLowerCase().contains("r"))// Filtrando
//						.collect(Collectors.toList())));//Mostrando resultado por lista
//						.collect(Collectors.joining(", "))));// Mostrando resultado por join
//						.collect(Collectors.toSet())));// Mostrando resultado por valores únicos

						.collect(Collectors
								.groupingBy((estudante) -> estudante.substring(estudante.indexOf("-") + 1)))));// Mostrando
																													// resultado
																													// por
																													// agrupament
						
	}
}
