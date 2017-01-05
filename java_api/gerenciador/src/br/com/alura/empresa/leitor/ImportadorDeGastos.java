package br.com.alura.empresa.leitor;

import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Scanner;

import br.com.alura.collections.Funcionario;
import br.com.alura.empresa.modelo.Gasto;

public class ImportadorDeGastos {
	private SimpleDateFormat df = new SimpleDateFormat("ddMMyyyy");

	public Collection<Gasto> importa(InputStream entrada) throws ParseException {
		Scanner leitor = new Scanner(entrada);
		Collection<Gasto> gastos = new LinkedHashSet<Gasto>();

		while (leitor.hasNextLine()) {
			String line = leitor.nextLine();
			String tipoGasto = line.substring(0, 6);
			String dataGastoTxt = line.substring(6, 14);
			String valorTxt = line.substring(14, 23);
			String matriculaTxt = line.substring(23, 26);
			String nome = line.substring(26, 56);

			double valor = Double.parseDouble(valorTxt);
			int matricula = Integer.parseInt(matriculaTxt);

			Calendar dataDespesa = converteDataTxtParaCalendar(dataGastoTxt);

			Funcionario funcionario = new Funcionario(nome, matricula);
			gastos.add(new Gasto(valor, tipoGasto, funcionario, dataDespesa));
		}

		leitor.close();
		return gastos;
	}

	private Calendar converteDataTxtParaCalendar(String dataNascTxt) throws ParseException {
		Calendar data = Calendar.getInstance();
		data.setTime(df.parse(dataNascTxt));
		return data;
	}

}
