package br.com.sfdio;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.sfdio.java_avancado.InferenciaLambdas;

@SpringBootApplication
public class SfsdioApplication {

	public static void main(String[] args) {
		// Java Avançado
//		String[] nomes = {"João", "Paula", "Maria", "Geverson","Geverson"};
//		IterandoFuncao.imprimindoNomesFiltradosAntigo(nomes);
//		IterandoFuncao.imprimindoNomesFiltradosNovo(nomes);
//		new CriandoPrimeiraThread(false);
//		new ExecutorExemplo();
//		new ServicoNotificacao(TipoCliente.PF);
//		new ServicoNotificacaoEAcompanhandoEnvio(null);
//		new ServicoNotificacaoEAcompanhandoEnvio(TipoCliente.PF);
//		new ServicoNotificacaoEAcompanhandoEnvio(TipoCliente.PJ);
//		new OtimizacaoDeExecucaoDeListas(true);
//		new OtimizacaoDeExecucaoDeListas(false);
//		new ReleaseJava10Pratica1();
//		new ReleaseJava10Pratica2("Geverson", "Souza");
//		var releaseJava11Pratica1 =new ReleaseJava11Pratica1();
//		//releaseJava11Pratica1.atigo();
//		//releaseJava11Pratica1.novo();
//		//Tempo de execução ::15818
//		//releaseJava11Pratica1.connectAkamaiHttp11Client();
//		//Tempo de execução ::5241
//		releaseJava11Pratica1.connectAkamaiHttp2Client();
		var inferenciaLambdas= new InferenciaLambdas();
//		inferenciaLambdas.dividePor2();
//		inferenciaLambdas.paravraEBranco();
//		inferenciaLambdas.pagina();
//		inferenciaLambdas.valoresLista();
		inferenciaLambdas.valoresRepete();
	}

}
