package br.com.sfdio.collections_streams;

import java.util.Optional;
import java.util.OptionalInt;

public class ExemploOptional {

	public void bacico() {
		Optional<String> optionalString = Optional.of("Valor presente");
		optionalString.ifPresentOrElse(System.out::println, () -> System.out.println("Não possui valor"));

		Optional<String> optionalNull = Optional.ofNullable(null);
		optionalNull.ifPresentOrElse(System.out::println, () -> System.out.println("Null -> Não possui valor"));

		Optional<String> optionalEmpty = Optional.empty();
		optionalEmpty.ifPresentOrElse(System.out::println, () -> System.out.println("Empty -> Não possui valor"));
		optionalEmpty.orElseThrow(IllegalStateException::new);

		OptionalInt.of(0).ifPresentOrElse(System.out::println, () -> System.out.println("Possui valor Int"));

		Optional<String> optionalStringNull = Optional.of(null);
		optionalStringNull.ifPresentOrElse(System.out::println, () -> System.out.println("Null -> Não possui valor"));
	}
}
