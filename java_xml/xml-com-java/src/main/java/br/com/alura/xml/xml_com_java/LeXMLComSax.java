package br.com.alura.xml.xml_com_java;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import br.com.alura.xml.handlers.ProdutosHandler;

public class LeXMLComSax {
	public static void main(String[] args) throws SAXException, IOException {
		XMLReader leitor = XMLReaderFactory.createXMLReader();
		ProdutosHandler logica = new ProdutosHandler();
		leitor.setContentHandler(logica);
		InputStream inputStream = new FileInputStream("src/Vendas.xml");
		InputSource input = new InputSource(inputStream );
		leitor.parse(input);
		
		System.out.println(logica.getProdutos());
	}

}
