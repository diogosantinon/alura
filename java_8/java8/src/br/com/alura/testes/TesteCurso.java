package br.com.alura.testes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TesteCurso {

	public static void main(String[] args) {
		List<Curso> cursos = new ArrayList<>();
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));
		//lambda
		cursos.sort(Comparator.comparing(c -> c.getAlunos()));
		//method reference
		cursos.sort(Comparator.comparingInt(Curso::getAlunos));
		
		cursos.forEach(System.out::println);
		
		//Strean
		cursos.stream()
		   .filter(c -> c.getAlunos() > 100)
		   .map(c -> c.getAlunos())
		   .forEach(x -> System.out.println(x));
		//method reference
		cursos.stream()
		   .filter(c -> c.getAlunos() > 100)
		   .mapToInt(Curso::getAlunos)
		   .forEach(System.out::println);
		
		Stream<String> nomeCursos = cursos.stream().map(Curso::getNome);
		nomeCursos.forEach(System.out::println);
		
		int soma = cursos.stream()
				   .filter(c -> c.getAlunos() > 100)
				   .mapToInt(Curso::getAlunos)
				   .sum();
		System.out.println(soma);
		
		//optional evita nullpointer
		Optional<Curso> optionCurso = cursos.stream()
			.filter(c -> c.getAlunos() >= 100)
			.findAny();
		
		cursos.stream()
		   .filter(c -> c.getAlunos() > 50)
		   .findFirst();		
		
		Curso curso = optionCurso.orElse(null);
		System.out.println(curso);
		
		optionCurso.ifPresent(c -> System.out.println(c.getNome()));
		
		
		OptionalDouble average = cursos.stream()
		   .filter(c -> c.getAlunos() > 100)
		   .mapToInt(Curso::getAlunos)
		   .average();
		System.out.println(average.getAsDouble());
		
		List<Curso> listaCursosFiltrados = cursos.stream()
			.filter(c -> c.getAlunos() >= 100)
			.collect(Collectors.toList());
		listaCursosFiltrados.forEach(System.out::println);
		
		List<Curso> lista = cursos.stream()
				   .filter(c -> c.getAlunos() > 50)
				   .collect(Collectors.toList());

		
		cursos.stream()
			.filter(c -> c.getAlunos() >= 100)
			.collect(Collectors.toMap(
					c -> c.getNome(), 
					c -> c.getAlunos()))
			.forEach((nome, alunos) -> System.out.println(nome + " tem " + alunos + " alunos"));
		
		//varias threads
		cursos.parallelStream()
			.filter(c -> c.getAlunos() >= 100)
			.collect(Collectors.toMap(
				c -> c.getNome(), 
				c -> c.getAlunos()))
			.forEach((nome, alunos) -> System.out.println(nome + " tem " + alunos + " alunos"));
		

		
	}

}
