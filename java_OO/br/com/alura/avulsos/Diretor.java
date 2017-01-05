package br.com.alura.avulsos;

import br.com.alura.banco.conta.Autenticavel;

class Diretor extends Funcionario implements Autenticavel{
	
    private int senha;

	public boolean autentica(int senha) {
        if (this.senha == senha) {
            System.out.println("Acesso Permitido!");
            return true;
        } else {
            System.out.println("Acesso Negado!");
            return false;
        }
    }	

	@Override
	public double getBonificacao() {
		// TODO Auto-generated method stub
		return 0;
	}

}
