package br.com.sfdio;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.sfdio.java_avancado.CriandoPrimeiraThread;

@SpringBootApplication
public class SfsdioApplication {

	public static void main(String[] args) {
		//SpringApplication.run(SfsdioApplication.class, args);
		//Java Avançado
		//String[] nomes = {"João", "Paula", "Maria", "Geverson","Geverson"};
		//IterandoFuncao.imprimindoNomesFiltradosAntigo(nomes);
		//IterandoFuncao.imprimindoNomesFiltradosNovo(nomes);
		new CriandoPrimeiraThread(false);
	}

}
