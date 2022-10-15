package br.com.sfdio.collections_streams;

import java.util.TreeSet;

public class ExemploTreeSet {

	public void bacico() {
		TreeSet<String> capitais = new TreeSet<>();
		capitais.add("Porto Alegre");// 0
		capitais.add("Florianópolis");// 1
		capitais.add("Curitiba");// 2
		capitais.add("São Paulo");// 3
		capitais.add("Belo Horizonte");// 4

		System.out.println(String.format("Antes do atendimento: %s", capitais));

		System.out.println(String.format("Removendo nota por valor %s", capitais.remove("Florianópolis")));

		System.out.println(String.format("Depois da remoção: %s", capitais));

		System.out.println(String.format("Primeira cidade da árvore é %s", capitais.first()));

		System.out.println(String.format("Primeira cidade da árvore é %s", capitais.last()));

		System.out.println(String.format("Primeira cidade abaixo da árvore da cidade informada é %s",
				capitais.lower("Florianópolis")));

		System.out.println(String.format("Primeira cidade acima da árvore da cidade informada é %s",
				capitais.higher("Florianópolis")));

		System.out.println(
				String.format("Retorna a primeira cidade do topo da árvore removendo do set %s", capitais.pollFirst()));

		System.out.println(
				String.format("Retorna a primeira cidade do final da árvore removendo do set %s", capitais.pollLast()));

		System.out.println(String.format("Existe nota? %b", !capitais.isEmpty()));

		System.out.println(String.format("Quantidades de notas: %s", capitais.size()));

		var iterandoAsCapitais = capitais.iterator();
		while (iterandoAsCapitais.hasNext())
			System.out.println(String.format("--> %s", iterandoAsCapitais.next()));
	}
}
