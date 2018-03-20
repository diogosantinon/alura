package br.com.demos.ldap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ldap")
public class LDAPController {

	@GetMapping("/welcome")
	public String welcome(Model model) {
		model.addAttribute("nome", "Teste");
		return "welcomeForm";
	}
}
