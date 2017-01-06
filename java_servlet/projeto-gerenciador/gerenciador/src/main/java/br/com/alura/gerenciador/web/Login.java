package br.com.alura.gerenciador.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.Usuario;
import br.com.alura.gerenciador.dao.UsuarioDAO;

public class Login implements Tarefa {


    @Override
    public String executa(HttpServletRequest request,
            HttpServletResponse response) {

        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        Usuario usuario = new UsuarioDAO().buscaPorEmailESenha(email, senha);
        HttpSession session = request.getSession();
		if (usuario != null) {
			session.setAttribute("usuarioLogado", usuario);
		}       

        return "index.jsp";

    }
	
}
