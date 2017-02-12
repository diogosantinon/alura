package br.com.alura.testes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

public class Datas {

	public static void main(String[] args) {
		LocalDate hoje = LocalDate.now();
		System.out.println(hoje);
		
		LocalDate dataFutura = LocalDate.of(2099, Month.JANUARY, 25);
		LocalDate dataParse = LocalDate.parse("2099-01-25");
		System.out.println(dataParse);
		
		Period exerc = Period.between(hoje, dataFutura);
		
		System.out.println(hoje.minusYears(1));
		System.out.println(hoje.minusMonths(4));
		System.out.println(hoje.minusDays(2));

		System.out.println(hoje.plusYears(1));
		System.out.println(hoje.plusMonths(4));
		System.out.println(hoje.plusDays(2));		
		
		LocalDate olimpiadas = LocalDate.of(2020, Month.JUNE, 20);
		
		int anos = olimpiadas.getYear() - hoje.getYear();
		System.out.println(anos);
		
		Period periodo = Period.between(olimpiadas, hoje);
		System.out.println(periodo.getYears());
		System.out.println(periodo.getMonths());
		System.out.println(periodo.getDays());
		
		LocalDate plusYears = olimpiadas.plusYears(4);
		System.out.println(plusYears.toString());
		
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String valorFormatado = plusYears.format(formatador);
		System.out.println(valorFormatado);
		
		DateTimeFormatter formatadorHoras = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
		LocalDateTime agora = LocalDateTime.now();
		System.out.println(agora.format(formatadorHoras));
		 
		LocalTime intervalo = LocalTime.of(15, 30);
		System.out.println(intervalo);
		
		ZonedDateTime zonedDateTime = ZonedDateTime.now();
		System.out.println(zonedDateTime);
		
	}
	

}
