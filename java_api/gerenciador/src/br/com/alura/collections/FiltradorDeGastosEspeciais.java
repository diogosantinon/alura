package br.com.alura.collections;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.empresa.modelo.Gasto;

public class FiltradorDeGastosEspeciais {
    private double limite;

	public FiltradorDeGastosEspeciais(double limite) {
		super();
		this.limite = limite;
	}

	public List<Gasto> filtraGastosGrandes(List<Gasto> gastos) {
        List<Gasto> gastosAcimaDoLimite = new ArrayList<Gasto>();
        for (Gasto gasto : gastos) {
            if(gasto.getValor() > this.limite) 
                gastosAcimaDoLimite.add(gasto);
        }
        return gastosAcimaDoLimite;
    }	

}
