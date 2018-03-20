package br.com.demos.jdbc.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import br.com.demos.jdbc.dto.CustomerDTO;
import br.com.demos.jdbc.entity.Customer;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CustomerService {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	public List<Customer> getCustomer(String firstName) {
		log.info("Consultando customer {}", firstName);
		List<Customer> customers = jdbcTemplate.query(
                "SELECT id, first_name, last_name FROM customers WHERE first_name = ?", new Object[] { firstName },
                (rs, rowNum) -> new Customer(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"))
        ).stream().collect(Collectors.toList());
		customers.forEach(customer -> log.info(customer.toString()));
		return customers;
	}


	public List<Customer> saveCustomer(CustomerDTO customer) {
		List<Object[]> lista = Arrays.asList(customer.getFirstName() + " " + customer.getLastName()).stream()
				.map(name -> name.split(" ")).collect(Collectors.toList());
		jdbcTemplate.batchUpdate("INSERT INTO customers(first_name, last_name) VALUES (?,?)", lista);
		return getCustomer(customer.getFirstName());
	}
	

}
