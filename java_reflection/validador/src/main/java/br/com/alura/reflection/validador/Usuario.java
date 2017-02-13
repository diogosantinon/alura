package br.com.alura.reflection.validador;

public class Usuario {

	private Boolean ativo;
	private String email;
	private String papel;
	private String login;
	private String senha;
	
	public Boolean getAtivo() {
		return ativo;
	}
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPapel() {
		return papel;
	}
	public void setPapel(String papel) {
		this.papel = papel;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public boolean validarEmail() {
		return email.contains("@");
	}
	
	public boolean validarSenha() {
		return senha.length() > 8;
	}
	
	public boolean validarLogin() {
		return login.length() > 5 && login.length() < 30;
	}

	public void testEmail() {
		System.out.println("Teste Email" + this.getEmail());
	}
	
	public void testLogin() {
		System.out.println("Teste Login" + this.getLogin());
	}
	
}
