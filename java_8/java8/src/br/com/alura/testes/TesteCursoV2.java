package br.com.alura.testes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class TesteCursoV2 {

	public static void main(String[] args) {
		compararCursosNumeroAlunos();
		
		filtraCursosNumeroAlunos();
		
		mapComQuantidadeAlunos();
		mapComSomaQtdeAlunosSemAutoBoxing();
		
		mapComNomesCursos();
		
		optionalCurso();
		
		streamToList();
		
		streamToMap();
		
		mediaAlunosPorCurso();
		
	}
	
	
	private static void mediaAlunosPorCurso() {
		List<Curso> cursos = criarListaCurso();
		
		OptionalDouble average = cursos.stream()
				.mapToInt(Curso::getAlunos)
				.average();
		
		System.out.println(average.getAsDouble());
		
	}


	private static void streamToMap() {
		List<Curso> cursos = criarListaCurso();
		
		Map map = cursos.stream()
				.filter(c -> c.getAlunos() > 100)
				.collect(Collectors.toMap(c -> c.getNome(), c -> c.getAlunos()));
		
		System.out.println(Arrays.toString(map.entrySet().toArray()));
		
		map.forEach((k,v)->System.out.println("Curso : " + k + " Numero Alunos : " + v));


	}


	private static void streamToList() {
		List<Curso> cursos = criarListaCurso();
		
		List<Curso> lista = cursos.stream()
				.filter(c -> c.getAlunos() > 100)
				.collect(Collectors.toList());
		
		imprimeCursos(lista);
		
	}


	private static void optionalCurso() {
		List<Curso> cursos = criarListaCurso();
		
		Optional<Curso> optionalCurso = cursos.stream()
				.filter(c -> c.getAlunos() > 100)
				.findAny();
		
		optionalCurso.ifPresent(c -> System.out.println(c));
	}


	private static void mapComNomesCursos() {
		List<Curso> cursos = criarListaCurso();

		cursos.stream()
				.map(Curso::getNome)
				.forEach(System.out::println);
	}


	private static void mapComSomaQtdeAlunosSemAutoBoxing() {
		List<Curso> cursos = criarListaCurso();
		System.out.println(cursos.stream()
		.filter(c -> c.getAlunos() > 100)
		.mapToInt(Curso::getAlunos)
		.sum());
		
	}


	private static void mapComQuantidadeAlunos() {
		List<Curso> cursos = criarListaCurso();
		cursos.stream()
				.filter(c -> c.getAlunos() > 100)
				.map(Curso::getAlunos)
				.forEach(System.out::println);
	}


	private static void filtraCursosNumeroAlunos() {
		List<Curso> cursos = criarListaCurso();
		
		cursos.stream()
				.filter(c -> c.getAlunos() > 100)
				.sorted(Comparator.comparingInt(Curso::getAlunos))
				.forEach(System.out::println);
		
	}


	private static void compararCursosNumeroAlunos() {
		List<Curso> cursos = criarListaCurso();
		
		cursos.sort(Comparator.comparingInt(Curso::getAlunos));
		
		imprimeCursos(cursos);
	}


	private static void imprimeCursos(List<Curso> cursos) {
		cursos.forEach(c -> {
			System.out.println(c.toString());
		});
	}


	private static List<Curso> criarListaCurso() {
		List<Curso> cursos = new ArrayList<>();
		
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));
		
		return cursos;
		
	}
}
