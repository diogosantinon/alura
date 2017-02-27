package br.com.alura.xml.xml_com_java;


import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import br.com.alura.xml.model.Produto;
import br.com.alura.xml.model.Venda;

public class MapeaXMLToClass {

	public static void main(String[] args) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(Venda.class);
		
		xmlParaObjeto(jaxbContext);
		
		objetoParaXml(jaxbContext);
		
	}

	private static void objetoParaXml(JAXBContext jaxbContext) throws JAXBException {
		Marshaller marshaller =  jaxbContext.createMarshaller();
		Venda venda = new Venda();
		venda.setFormaPagamento("Crediario");
		venda.setMoeda("Dolar");
		List<Produto> lista = new ArrayList<Produto>();
		lista.add(new Produto("A", 1.2));
		lista.add(new Produto("B", 1.4));
		lista.add(new Produto("C", 1.6));
		venda.setProdutos(lista);
		StringWriter writer = new StringWriter();
		marshaller.marshal(venda, writer);
		System.out.println(writer.toString());
	}

	private static void xmlParaObjeto(JAXBContext jaxbContext) throws JAXBException {
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		Venda venda = (Venda) unmarshaller.unmarshal(new File("src/Vendas.xml"));
		
		System.out.println(venda);
		
	}
	
}
