package br.com.sfdio.java_avancado;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ProxySelector;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.stream.Collectors;

public class ReleaseJava11Pratica1 {

	private static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(6, new ThreadFactory() {

		@Override
		public Thread newThread(Runnable r) {
			var thread = new Thread(r);
			System.out.println(String.format("Nova Thread Criada :: %s Deamon? :: %s Thread Group :: %s",
					thread.getName(), thread.isDaemon() ? "Sim" : "Não", thread.getThreadGroup()));
			return thread;
		}
	});

	public void atigo() {
		try {
			URL url = new URL("https://docs.oracle.com/javase/10/");
			URLConnection urlConnection = url.openConnection();
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
			System.out.println(bufferedReader.lines().collect(Collectors.joining()).replaceAll(">", ">\n"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void novo() {
		try {
			var httpRequest = HttpRequest.newBuilder().GET()
					.uri(URI.create("https://docs.oracle.com/en/java/javase/11/")).build();
			var httpClient = HttpClient.newHttpClient();
			var httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
			System.out.println("HTTP Status Code ::" + httpResponse.statusCode());
			System.out.println("HTTP Headers ::" + httpResponse.headers());
			System.out.println(httpResponse.body());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void connectAkamaiHttp11Client() {
		try {
			System.out.println("Runing HTTP/1.1 exemple...");
			var httpClient = HttpClient.newBuilder().version(Version.HTTP_1_1).proxy(ProxySelector.getDefault())
					.build();
			var start = System.currentTimeMillis();
			var httpRequest = HttpRequest.newBuilder()
					.uri(URI.create("https://http2.akamai.com/demo/h2_demo_frame.html")).build();
			var httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
			var responseBody = httpResponse.body();
			System.out.println("HTTP Status Code ::" + httpResponse.statusCode());
			System.out.println("HTTP Headers ::" + httpResponse.headers());
			System.out.println(responseBody);
			List<Future<?>> futures = new ArrayList<>();
			responseBody.lines().filter(line -> line.trim().startsWith("<img height"))
					.map(line -> line.substring(line.indexOf("src='") + 5, line.indexOf("'/>"))).forEach(image -> {
						var future = EXECUTOR_SERVICE.submit(() -> {
							try {
								var httpRequestImage = HttpRequest.newBuilder()
										.uri(URI.create("https://http2.akamai.com" + image)).build();
								var httpResponseImage = httpClient.send(httpRequestImage,
										HttpResponse.BodyHandlers.ofString());
								System.out.println(String.format("Imagem garregada :: %s Status Requisição :: ", image,
										httpResponseImage.statusCode()));
							} catch (Exception e) {
								e.printStackTrace();
							}
						});
						futures.add(future);
						System.out.println("Imagem submetida ::" + image);
					});
			futures.forEach(future -> {
				try {
					future.get();
				} catch (InterruptedException | ExecutionException e) {
					System.out.println("Erro ao capturar Future");
				}
			});
			System.out.println("Tempo de execução ::" + (System.currentTimeMillis() - start));
		} catch (IOException | InterruptedException e) {
			System.out.println("Imagem submetida erro ao connectAkamaiHttpClient");
		} finally {
			EXECUTOR_SERVICE.shutdown();
		}
	}
	
	public void connectAkamaiHttp2Client() {
		try {
			System.out.println("Runing HTTP/2 exemple...");
			var httpClient = HttpClient.newBuilder().version(Version.HTTP_2).proxy(ProxySelector.getDefault())
					.build();
			var start = System.currentTimeMillis();
			var httpRequest = HttpRequest.newBuilder()
					.uri(URI.create("https://http2.akamai.com/demo/h2_demo_frame.html")).build();
			var httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
			var responseBody = httpResponse.body();
			System.out.println("HTTP Status Code ::" + httpResponse.statusCode());
			System.out.println("HTTP Headers ::" + httpResponse.headers());
			System.out.println(responseBody);
			List<Future<?>> futures = new ArrayList<>();
			responseBody.lines().filter(line -> line.trim().startsWith("<img height"))
					.map(line -> line.substring(line.indexOf("src='") + 5, line.indexOf("'/>"))).forEach(image -> {
						var future = EXECUTOR_SERVICE.submit(() -> {
							try {
								var httpRequestImage = HttpRequest.newBuilder()
										.uri(URI.create("https://http2.akamai.com" + image)).build();
								var httpResponseImage = httpClient.send(httpRequestImage,
										HttpResponse.BodyHandlers.ofString());
								System.out.println(String.format("Imagem garregada :: %s Status Requisição :: ", image,
										httpResponseImage.statusCode()));
							} catch (Exception e) {
								e.printStackTrace();
							}
						});
						futures.add(future);
						System.out.println("Imagem submetida ::" + image);
					});
			futures.forEach(future -> {
				try {
					future.get();
				} catch (InterruptedException | ExecutionException e) {
					System.out.println("Erro ao capturar Future");
				}
			});
			System.out.println("Tempo de execução ::" + (System.currentTimeMillis() - start));
		} catch (IOException | InterruptedException e) {
			System.out.println("Imagem submetida erro ao connectAkamaiHttpClient");
		} finally {
			EXECUTOR_SERVICE.shutdown();
		}
	}
}
