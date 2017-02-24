package br.com.alura.xml.model;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class LeArquivoXMLDeOutraForma {
	public static void main(String[] args) throws SAXException, IOException {
		XMLReader leitor = XMLReaderFactory.createXMLReader();
		LeitorXML logica = new LeitorXML();
		leitor.setContentHandler(logica);
		InputStream inputStream = new FileInputStream("src/Vendas.xml");
		InputSource input = new InputSource(inputStream );
		leitor.parse(input);
	}

}
