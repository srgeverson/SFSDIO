package br.com.sfdio.java_avancado;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.stream.Collectors;

public class ReleaseJava10Pratica3 {

	public ReleaseJava10Pratica3() {
		try {
			var url = new URL("https://docs.oracle.com/javase/10/lenguage/");
			var urlConnection = url.openConnection();
			try (var bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()))) {
				System.out.println(bufferedReader.lines().collect(Collectors.joining()).replaceAll(">", ">\n"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
