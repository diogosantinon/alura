package br.com.alura.banco;

import br.com.alura.avulsos.Funcionario;
import br.com.alura.avulsos.Gerente;
import br.com.alura.banco.sistema.ControleDeBonificacoes;

public class TestaGerente {
        public static void main(String[] args) {
            Gerente gerente = new Gerente();

            // podemos chamar métodos do Funcionario:
            gerente.setNome("João da Silva");

            // e também métodos do Gerente!
            gerente.setSenha(4231);

		    gerente.setSalario(5000.0);
		    System.out.println(gerente.getBonificacao());   

		    ControleDeBonificacoes controle = new ControleDeBonificacoes();

		    Gerente funcionario1 = new Gerente();
		    funcionario1.setSalario(5000.0);
		    controle.registra(funcionario1);

		    Funcionario funcionario2 = new Gerente();
		    funcionario2.setSalario(1000.0);
		    controle.registra(funcionario2);

		    System.out.println(controle.getTotalDeBonificacoes());		             
        }
    }