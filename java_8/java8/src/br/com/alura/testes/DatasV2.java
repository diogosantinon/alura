package br.com.alura.testes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class DatasV2 {

	public static void main(String[] args) {
		
		hojeAmanhaOntem();
		
		calculaAnosOlimpiadasRio();
		
		calculaAnosOlimpiadasRioComPeriod();
		
		dataComTime();
		
	}

	private static void dataComTime() {
		DateTimeFormatter formatadorComHoras = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
		LocalDateTime agora = LocalDateTime.now();
		System.out.println(agora.format(formatadorComHoras));
		
	}

	private static void calculaAnosOlimpiadasRioComPeriod() {
		LocalDate hoje = LocalDate.now();
		LocalDate olimpiada = LocalDate.of(2016, Month.JUNE, 5);
		Period periodo = Period.between(olimpiada, hoje);
		System.out.println("Anos " + periodo.getYears() + ", meses " 
							+ periodo.getMonths() + ", dias " 
							+ periodo.getDays());
		
	}

	private static void calculaAnosOlimpiadasRio() {
		LocalDate hoje = LocalDate.now();
		LocalDate olimpiada = LocalDate.of(2016, Month.JUNE, 5);
		int anos = hoje.getYear() - olimpiada.getYear();
		
		System.out.println(anos);
	}

	private static void hojeAmanhaOntem() {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				
		
		LocalDate hoje = LocalDate.now();
		System.out.println(hoje.format(formato));
		System.out.println("amanha " + hoje.plusDays(1).format(formato));
		
		System.out.println(hoje.minusYears(1));
		System.out.println(hoje.minusMonths(4));
		System.out.println(hoje.minusDays(2));

		System.out.println(hoje.plusYears(1));
		System.out.println(hoje.plusMonths(4));
		System.out.println(hoje.plusDays(2));
	}
	
}
