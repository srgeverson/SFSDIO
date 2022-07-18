package br.com.sfdio.collections_streams;

import java.util.LinkedList;
import java.util.Queue;

public class ExemploVector {

	public void bacico() {
		Queue<String> filaBancos = new LinkedList<>();
		filaBancos.add("Carlos");//0
		filaBancos.add("Pedro");//1
		filaBancos.add("Juliana");//2
		filaBancos.add("Anderson");//3
		filaBancos.add("Maria");//4
		filaBancos.add("João");//5
		filaBancos.add("João");//6
		
		System.out.println(filaBancos);
		
		System.out.println(String.format("Cliente a ser atendido é %s", filaBancos.poll()));
		
		System.out.println(String.format("Primeiro cliente é %s", filaBancos.peek()));
		
		System.out.println(filaBancos);
	}
}
