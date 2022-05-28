package br.com.sfdio.java_avancado;

public class ReleaseJava10Pratica2 {

	public ReleaseJava10Pratica2(String nome, String sobreNome) {
		var nomeCompleto = nome + " " + sobreNome;
		System.out.println(nomeCompleto);
		var soma = 10 + 20;
		System.out.println(soma);
		System.out.println(somaLista(10, 20, 30, 43));
	}

	private int somaLista(int... numeros) {
		var soma = 0;
		for (var i : numeros) {
			soma += i;
		}
		return soma;
	}

}
