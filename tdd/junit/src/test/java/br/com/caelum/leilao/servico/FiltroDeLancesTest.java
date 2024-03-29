package br.com.caelum.leilao.servico;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Usuario;
import br.com.caelum.leilao.servico.FiltroDeLances;

public class FiltroDeLancesTest {
	

    @Test
    public void deveSelecionarLancesEntre1000E3000() {
        Usuario joao = new Usuario("Joao");

        FiltroDeLances filtro = new FiltroDeLances();
        List<Lance> resultado = filtro.filtra(Arrays.asList(
                new Lance(joao,2000), 
                new Lance(joao,1000), 
                new Lance(joao,3000), 
                new Lance(joao, 800)));

        assertEquals(1, resultado.size());
        assertEquals(2000, resultado.get(0).getValor(), 0.00001);
    }

    @Test
    public void deveSelecionarLancesEntre500E700() {
        Usuario joao = new Usuario("Joao");

        FiltroDeLances filtro = new FiltroDeLances();
        List<Lance> resultado = filtro.filtra(Arrays.asList(
                new Lance(joao,600), 
                new Lance(joao,500), 
                new Lance(joao,700), 
                new Lance(joao, 800)));

        assertEquals(1, resultado.size());
        assertEquals(600, resultado.get(0).getValor(), 0.00001);
    }
    
    @Test
    public void deveSelecionarLancesMaiores5000() {
        Usuario joao = new Usuario("Joao");

        FiltroDeLances filtro = new FiltroDeLances();
        List<Lance> resultado = filtro.filtra(Arrays.asList(
                new Lance(joao,200), 
                new Lance(joao,500), 
                new Lance(joao,7000), 
                new Lance(joao,5100)));

        assertEquals(2, resultado.size());
        assertEquals(7000, resultado.get(0).getValor(), 0.00001);
        assertEquals(5100, resultado.get(1).getValor(), 0.00001);
    }
    
    @Test
    public void deveSelecionarLancesEntreAsFaixas() {
        Usuario joao = new Usuario("Joao");

        FiltroDeLances filtro = new FiltroDeLances();
        List<Lance> resultado = filtro.filtra(Arrays.asList(
                new Lance(joao,2000), 
                new Lance(joao,600), 
                new Lance(joao,7000), 
                new Lance(joao,5100)));

        assertEquals(4, resultado.size());
        assertEquals(2000, resultado.get(0).getValor(), 0.00001);
        assertEquals(600, resultado.get(1).getValor(), 0.00001);
        assertEquals(7000, resultado.get(2).getValor(), 0.00001);
        assertEquals(5100, resultado.get(3).getValor(), 0.00001);
    }    
    
    @Test
    public void deveNaoSelecionarLances() {
        Usuario joao = new Usuario("Joao");

        FiltroDeLances filtro = new FiltroDeLances();
        List<Lance> resultado = filtro.filtra(Arrays.asList(
                new Lance(joao,150), 
                new Lance(joao,200), 
                new Lance(joao,200),
                new Lance(joao,4000),
                new Lance(joao,180)));

        assertEquals(0, resultado.size());
    }     

}
