package br.com.sfdio.collections_streams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ExemploList {

	public void bacico() {
		List<String> nomes = new ArrayList<>();
		nomes.add("Carlos");//0
		nomes.add("Pedro");//1
		nomes.add("Juliana");//2
		nomes.add("Anderson");//3
		nomes.add("Maria");//4
		nomes.add("João");//5
		nomes.add("João");//6
		
		System.out.println(nomes);
		
		nomes.set(2, "Geverson");
		System.out.println(nomes);
		
		Collections.sort(nomes);
		
		System.out.println(nomes);
		
		nomes.set(2, "Geverson");
		
		System.out.println(nomes);
		
		nomes.remove(2);
		
		System.out.println(nomes);
		
		nomes.remove("João");
		
		System.out.println(nomes);
		
		System.out.println(String.format("Elemento da posição %d é %s", 0, nomes.get(0)));
		
		System.out.println(String.format("Tamanho da lista é %d ", nomes.size()));
		
		System.out.println(String.format("O indice do nome %s é %d", "Geverson", nomes.indexOf("João")));
		
		System.out.println(String.format("A lista está vazia? %b", nomes.isEmpty()));
		
		for(var nome: nomes)
			System.out.println(String.format("Estrutura for ---> %s", nome));
		
		Iterator<String> iterator = nomes.iterator();
		while (iterator.hasNext())
			System.out.println(String.format("Estrutura iterator ---> %s", iterator.next()));
		
		nomes.clear();
		System.out.println(String.format("Limpando a lista "));
		
	}
}
