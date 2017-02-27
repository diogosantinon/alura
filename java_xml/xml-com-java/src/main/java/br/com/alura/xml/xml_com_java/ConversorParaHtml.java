package br.com.alura.xml.xml_com_java;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class ConversorParaHtml {
	public static void main(String[] args) throws FileNotFoundException, TransformerFactoryConfigurationError, TransformerException {
		InputStream is = new FileInputStream("src/xmlParaHtml.xsl");
		StreamSource xslSource = new StreamSource(is);
	
		InputStream dados = new FileInputStream("src/Vendas.xml");
		StreamSource xmlSource = new StreamSource(dados);
		
		Transformer transformer = TransformerFactory.newInstance().newTransformer(xslSource);
		StreamResult saida = new StreamResult("src/Vendas.html");
		transformer.transform(xmlSource, saida);
		
		System.out.println("Conversao Concluida");
	}
	
}
