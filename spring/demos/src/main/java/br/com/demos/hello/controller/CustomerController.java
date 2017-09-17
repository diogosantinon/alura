package br.com.demos.hello.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.demos.hello.dto.CustomerDTO;
import br.com.demos.hello.entity.Customer;
import br.com.demos.hello.service.CustomerService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@GetMapping
	public List<Customer> getCustomer(@RequestParam(value="firstName") final String firstName) {
		log.info("Buscando cliente ..{} ", firstName);
		return customerService.getCustomer(firstName);
	}
	
	@PostMapping("/save")
	public List<Customer> saveCustomer(@RequestBody final CustomerDTO customer) {
		log.info("salvando cliente ... {} ", customer);
		List<Customer> lista = customerService.saveCustomer(customer);
		return lista;
	}

}
