package br.com.sfdio.collections_streams;

import java.util.LinkedHashSet;

public class ExemploLinkedHashSet {

	public void bacico() {
		LinkedHashSet<Integer> numeros = new LinkedHashSet<>();
		numeros.add(16);// 0
		numeros.add(2);// 1
		numeros.add(8);// 2
		numeros.add(4);// 3
		numeros.add(1);// 4

		System.out.println(String.format("Antes: %s", numeros));

		System.out.println(String.format("Removendo por valor %s", numeros.remove(4)));

		System.out.println(String.format("Depois da remoção: %s", numeros));

		System.out.println(String.format("Existe nota? %b", !numeros.isEmpty()));

		System.out.println(String.format("Quantidades de notas: %s", numeros.size()));

		var iterandoOsNumeros = numeros.iterator();
		while (iterandoOsNumeros.hasNext())
			System.out.println(String.format("--> %s", iterandoOsNumeros.next()));

	}
}
