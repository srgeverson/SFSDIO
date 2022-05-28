package br.com.sfdio;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.sfdio.java_avancado.OtimizacaoDeExecucaoDeListas;

@SpringBootApplication
public class SfsdioApplication {

	public static void main(String[] args) {
		//Java Avançado
		//String[] nomes = {"João", "Paula", "Maria", "Geverson","Geverson"};
		//IterandoFuncao.imprimindoNomesFiltradosAntigo(nomes);
		//IterandoFuncao.imprimindoNomesFiltradosNovo(nomes);
		//new CriandoPrimeiraThread(false);
		//new ExecutorExemplo();
		//new ServicoNotificacao(TipoCliente.PF);
		//new ServicoNotificacaoEAcompanhandoEnvio(null);
		//new ServicoNotificacaoEAcompanhandoEnvio(TipoCliente.PF);
		//new ServicoNotificacaoEAcompanhandoEnvio(TipoCliente.PJ);
		new OtimizacaoDeExecucaoDeListas(true);
		new OtimizacaoDeExecucaoDeListas(false);
	}

}
