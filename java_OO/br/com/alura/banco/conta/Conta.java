package br.com.alura.banco.conta;

public abstract class Conta {
	protected double saldo;
	protected int numero;
	private String nome;

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public double getSaldo() {
		return this.saldo;
	}


	public void deposita(double valor) throws ValorInvalidoException {
		if(valor < 0) {
			throw new ValorInvalidoException(valor);
		}
		this.saldo += valor;
	}

	public void saca(double valor) throws SaldoInsuficienteException {
		if (this.saldo < valor) {
			throw new SaldoInsuficienteException("Saldo Insuficiente," +  
                    "tente um valor menor");
		} else {
			this.saldo -= valor;
		}
	}

	public abstract void atualiza(double taxaSelic); 
	
	public String toString() {
			return "essa conta "+ this.numero +" é uma conta com saldo R$" + this.saldo;
	}
	
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numero;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		if (numero != other.numero)
			return false;
		return true;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	
	
}