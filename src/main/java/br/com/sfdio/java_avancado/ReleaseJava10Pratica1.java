package br.com.sfdio.java_avancado;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.stream.Collectors;

public class ReleaseJava10Pratica1 {

	public ReleaseJava10Pratica1() {
		try {
			URL url = new URL("https://docs.oracle.com/javase/10/lenguage/");
			URLConnection urlConnection = url.openConnection();
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
			System.out.println(bufferedReader.lines().collect(Collectors.joining()).replaceAll(">", ">\n"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
