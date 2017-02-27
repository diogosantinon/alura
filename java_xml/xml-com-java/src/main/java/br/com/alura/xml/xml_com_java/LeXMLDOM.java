package br.com.alura.xml.xml_com_java;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import br.com.alura.xml.model.Produto;

public class LeXMLDOM {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		//usar validacao xsd
		factory.setValidating(true);
		factory.setNamespaceAware(true);
		factory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://www.w3.org/2001/XMLSchema");
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/Vendas.xml");
		
		Element venda = document.getDocumentElement();
		String moeda = venda.getAttribute("moeda");
		System.out.println(moeda);
		
		NodeList formasPagamento = document.getElementsByTagName("formaPagamento");
		Element forma = (Element) formasPagamento.item(0);
		
		String formaPagamento = forma.getTextContent();
		
		System.out.println(formaPagamento);
		
		NodeList produtos = document.getElementsByTagName("produto");
		for(int i=0; i < produtos.getLength(); i++) {
			Element produto = (Element) produtos.item(i);
			String nome = produto.getElementsByTagName("nome").item(0).getTextContent();
			Double preco = Double.parseDouble(produto.getElementsByTagName("preco").item(0).getTextContent());
			Produto prod = new Produto(nome, preco);
			System.out.println(prod);
		}
		
		//xpath
		String exp = "/venda/produtos/produto[2]";
		XPath xpath = XPathFactory.newInstance().newXPath();
		XPathExpression expression = xpath.compile(exp);
		
		NodeList result = (NodeList) expression.evaluate(document, XPathConstants.NODESET);
		for(int i=0; i < result.getLength(); i++) {
			Element produto = (Element) result.item(i);
			String nome = produto.getElementsByTagName("nome").item(0).getTextContent();
			Double preco = Double.parseDouble(produto.getElementsByTagName("preco").item(0).getTextContent());
			Produto prod = new Produto(nome, preco);
			System.out.println(prod);
		}
		
		
	}

}
