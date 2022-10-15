package br.com.sfdio.collections_streams;

import java.util.HashSet;
import java.util.Set;

public class ExemploHashSet {

	public void bacico() {
		Set<Double> notas = new HashSet<>();
		notas.add(5.8);// 0
		notas.add(9.3);// 1
		notas.add(6.5);// 2
		notas.add(10.0);// 3
		notas.add(5.4);// 4
		notas.add(7.3);// 5
		notas.add(3.8);// 6
		notas.add(4.0);// 7

		System.out.println(String.format("Antes do atendimento: %s", notas));

		System.out.println(String.format("Removendo nota por valor %s", notas.remove(3.8)));

		System.out.println(String.format("Depois da remoção: %s", notas));

		System.out.println(String.format("Existe nota? %b", !notas.isEmpty()));

		System.out.println(String.format("Quantidades de notas: %s", notas.size()));

		var iterandoAsNotas = notas.iterator();
		while (iterandoAsNotas.hasNext())
			System.out.println(String.format("--> %s", iterandoAsNotas.next()));

	}
}
