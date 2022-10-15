package br.com.sfdio.collections_streams;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ExemploMap {

	public void bacico() {
		Map<String, Integer> copasDoMundo = new HashMap<>();
		copasDoMundo.put("Brasil", 5);// 0
		copasDoMundo.put("Alemanha", 4);// 1
		copasDoMundo.put("Itália", 4);// 2
		copasDoMundo.put("Uruguai", 2);// 3
		copasDoMundo.put("Argentina", 2);// 4
		copasDoMundo.put("França", 2);// 5
		copasDoMundo.put("Inglaterra", 1);// 6
		copasDoMundo.put("Espanha", 1);// 7

		System.out.println(String.format("Antes do atendimento: %s", copasDoMundo));

		System.out.println(String.format("Retorna Argentina %s", copasDoMundo.get("Argentina")));

		System.out.println(String.format("Retorna se contém ou não França: %s", copasDoMundo.containsKey("França")));

	}

	public void bacico2() {
		TreeMap<String, String> ufs = new TreeMap<>();
		ufs.put("RS", "Porto Alegre");// 0
		ufs.put("SC", "Florianópolis");// 1
		ufs.put("PR", "Curitiba");// 2
		ufs.put("SP", "São Paulo");// 3
		ufs.put("RJ", "Rio de Janeiro");// 4
		ufs.put("MG", "Belo Horizonte");// 5

		System.out.println(String.format("Antes do atendimento: %s", ufs));

		System.out.println(String.format("Retorna primeira UF do topo da arvore %s", ufs.firstKey()));

		System.out.println(String.format("Retorna ultima UF do final da arvore %s", ufs.lastEntry()));

		System.out
				.println(String.format("Retorna primeira UF do abaixo da arvore parametrizada %s", ufs.lowerKey("SC")));

		System.out
				.println(String.format("Retorna primeira UF do acima da arvore parametrizada %s", ufs.lowerKey("SC")));

		System.out.println(String.format("Antes do atendimento: %s", ufs));

		System.out.println(String.format("Retorna primeira UF do topo da arvore: %s - %s", ufs.firstEntry().getKey(),
				ufs.firstEntry().getValue()));

		System.out.println(String.format("Retorna ultima UF do final da arvore: %s - %s", ufs.lastEntry().getKey(),
				ufs.lastEntry().getValue()));
	}
}
