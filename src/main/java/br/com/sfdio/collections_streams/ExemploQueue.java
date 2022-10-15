package br.com.sfdio.collections_streams;

import java.util.LinkedList;
import java.util.Queue;

public class ExemploQueue {

	public void bacico() {
		Queue<String> nomes = new LinkedList<>();
		nomes.add("Patrícia");// 0
		nomes.add("Roberto");// 1
		nomes.add("Flávio");// 2
		nomes.add("Pamela");// 3
		nomes.add("Andeson");// 4

		System.out.println(String.format("Antes do atendimento: %s", nomes));

		System.out.println(String.format("Cliente a ser atendido agora é %s", nomes.poll()));

		System.out.println(String.format("Depois do atendimento: %s", nomes));

		System.out.println(String.format("Primeiro cliente é %s", nomes.peek()));

		System.out.println(String.format("Depois de mostrar o primeiro cliente: %s", nomes));

		// nomes.clear();
		// System.out.println(String.format("Primeiro cliente é %s, se item na lista",
		// nomes.element()));

		System.out.println(String.format("Existe cliente? %b", !nomes.isEmpty()));
		
		System.out.println(String.format("Quantidades de clientes: %s", nomes.size()));

		var iterandoOsCliente = nomes.iterator();
		while (iterandoOsCliente.hasNext())
			System.out.println(String.format("--> %s", iterandoOsCliente.next()));
		
		nomes.forEach(nome -> System.out.println(String.format("%s", nome)));
	}
}
