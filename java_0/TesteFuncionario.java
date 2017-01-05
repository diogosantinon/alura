class TesteFuncionario {
	public static void main(String[] args) {
		Funcionario f1 = new Funcionario();
		Departamento dep = new Departamento();
		dep.nome = "TI";
		Data entrada = new Data();
		entrada.informarData(3, 10, 2000);
		f1.setNome("Hugo");
        f1.setSalario(100);
        f1.recebeAumento(50);
        f1.setDataEntrada(entrada);
        f1.setRg("546456446");
        f1.setDepartamento(dep);

        f1.mostra();

	}
}