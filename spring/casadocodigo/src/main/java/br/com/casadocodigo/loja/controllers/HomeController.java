package br.com.casadocodigo.loja.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.casadocodigo.loja.daos.ProdutoDAO;
import br.com.casadocodigo.loja.models.Produto;

@Controller
public class HomeController {
	
	@Autowired
	ProdutoDAO dao;
	
	@RequestMapping("/")
	@Cacheable(value="produtosHome") //habilita cache para o metodo, precisa habilitar o cache no AppWebConfiguration
	public ModelAndView index(){
		ModelAndView modelAndView = new ModelAndView("home"); //seta jsp home.jsp
		List<Produto> produtos = dao.listar(); 
		modelAndView.addObject("produtos", produtos);
	    return modelAndView;
	}
}
