class Funcionario {
	private String nome;
	private Departamento departamento;
	private double salario;
	private Data dataEntrada ;
	private String Rg;
	private static int proximoFuncionario = 0;
    private int identificador;

	public funcionario() {

	}

	public funcionario(String nome) {
		this.nome = nome;
		this.identificador = ++ proximoFuncionario;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Departamento getDepartamento() {
		return this.departamento;
	}	

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public double getSalario() {
		return this.salario;
	}

	public void setDataEntrada(Data dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public Data getDataEntrada() {
		return this.dataEntrada;
	}

	public void setRg(String Rg) {
		this.Rg = Rg;
	}

	public String getRg() {
		return this.Rg;
	}

	public int getIdentificador() {
		return Funcionario.identificador;
	}

	public void mostra() {
		System.out.println("Nome: " + this.nome);
		System.out.println("Departamento: " + this.departamento.nome);
		System.out.println("Salario: " + this.salario);
		System.out.println("Data Entrada: " + this.dataEntrada.getFormatada());
		System.out.println("RG:" + this.Rg);
		System.out.println("Ganho anual: R$" + this.calculaGanhoAnual());

	}

	public void recebeAumento(double valorAumento) {
		this.salario += valorAumento;
	}

	public double calculaGanhoAnual () {
		return (this.salario * 12);
	}
}