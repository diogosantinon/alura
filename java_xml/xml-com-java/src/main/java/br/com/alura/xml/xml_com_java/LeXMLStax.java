package br.com.alura.xml.xml_com_java;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;

import br.com.alura.xml.model.Produto;

public class LeXMLStax {

	public static void main(String[] args) throws FileNotFoundException, XMLStreamException {
		InputStream is = new FileInputStream("src/Vendas.xml");
		XMLInputFactory factory = XMLInputFactory.newInstance(); 
		XMLEventReader eventos =  factory.createXMLEventReader(is);
		List<Produto> produtos  = new ArrayList<Produto>();
		while (eventos.hasNext()) { 
		
			XMLEvent evento = eventos.nextEvent();
			if(evento.isStartElement() && evento.asStartElement().getName().getLocalPart().equals("produto")) {
				Produto produto = criaProduto(eventos);
				produtos.add(produto);
			} 
			
		}
		System.out.println(produtos);
	}

	private static Produto criaProduto(XMLEventReader eventos) throws XMLStreamException {
		Produto produto = new Produto();
		while(eventos.hasNext()) {
			XMLEvent evento = eventos.nextEvent();
			if(evento.isStartElement() && evento.asStartElement().getName().getLocalPart().equals("nome")) {
				evento = eventos.nextEvent();
				String nome = evento.asCharacters().getData();
				produto.setNome(nome);
			} else if(evento.isStartElement() && evento.asStartElement().getName().getLocalPart().equals("preco")) {
				evento = eventos.nextEvent();
				double valor = Double.parseDouble(evento.asCharacters().getData());
				produto.setPreco(valor);
			} else if(evento.isEndElement() && evento.asEndElement().getName().getLocalPart().equals("produto")) {
				break;
			}
		}
		
		return produto;
	}

}
