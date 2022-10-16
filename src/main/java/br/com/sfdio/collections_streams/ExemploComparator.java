package br.com.sfdio.collections_streams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ExemploComparator {

	public void bacico() {
		List<Estutante> estudantes = new ArrayList<>();
		estudantes.add(new Estutante("Pedro", 19));// 0
		estudantes.add(new Estutante("Carlos", 23));// 1
		estudantes.add(new Estutante("Mariana", 21));// 2
		estudantes.add(new Estutante("João", 18));// 3
		estudantes.add(new Estutante("Thiago", 20));// 4
		estudantes.add(new Estutante("George", 22));// 5
		estudantes.add(new Estutante("Larissa", 21));// 6

		System.out.println(String.format("Ordem de inserção: %s", estudantes));

		estudantes.sort((primeiro, proximo) -> primeiro.idade - proximo.idade);
		System.out.println(String.format("Ordenando por idade ascendente %s", estudantes));

		estudantes.sort((primeiro, proximo) -> proximo.idade - primeiro.idade);
		System.out.println(String.format("Ordenando por idade descedente %s", estudantes));

		estudantes.sort(Comparator.comparingInt(Estutante::getIdade));
		System.out.println(String.format("Ordenando por idade ascendente - Comparator: %s", estudantes));

		estudantes.sort(Comparator.comparingInt(Estutante::getIdade).reversed());
		System.out.println(String.format("Ordenando por idade descedente - Comparator: %s", estudantes));

		Collections.sort(estudantes, new EstudanteUtils());
		System.out.println(String.format("Ordenando por idade ascendente - Collections.sort: %s", estudantes));

	}

	class Estutante {
		private String nome;
		private int idade;

		public Estutante(String nome, int idade) {
			super();
			this.nome = nome;
			this.idade = idade;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public int getIdade() {
			return idade;
		}

		public void setIdade(int idade) {
			this.idade = idade;
		}

		@Override
		public String toString() {
			return "[nome=" + nome + ", idade=" + idade + "]";
		}

	}

	class EstudanteUtils implements Comparator<Estutante> {

		@Override
		public int compare(Estutante estutante1, Estutante estutante2) {
			return estutante1.idade - estutante2.idade;
		}
	}
}
