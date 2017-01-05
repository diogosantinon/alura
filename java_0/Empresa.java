class Empresa {
	private String nome;
	private String cnpj;
	private Funcionario[] funcionarios;
	private int numeroMembros =0;

    public empresa (int tamanho) {
        this.funcionario = new Funcionario[tamanho];
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public Funcionario getFuncionario(int posicao) {
        return this.funcionarios[i];
    }

	void adicionar(Funcionario funcionario) {
		this.funcionarios[numeroMembros] = funcionario;a
		this.numeroMembros ++;
	}

    void mostraEmpregados() {
        for (int i = 0; i < this.numeroMembros; i++) {
            System.out.println("Funcionário : " + this.funcionarios[i].getNome());
            System.out.println("R$" + this.funcionarios[i].getSalario());
        }
    }

    void mostraTodasAsInformacoes() {
        for (int i = 0; i < this.numeroMembros; i++) {
        	this.funcionarios[i].mostra();
		}    	
    }

    boolean contem(Funcionario f) {
    	boolean existe = false;
    	for (int i = 0; i < this.funcionarios.length ; i++) {
    		if(f == this.funcionarios[i]) {
    			existe = true;
    		}
    	}
    	return existe;
    }    
}