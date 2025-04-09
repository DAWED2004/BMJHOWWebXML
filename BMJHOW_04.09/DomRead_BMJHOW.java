package DOM_BMJHOW;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3.dom.Document;
import org.xml.sax.SaxException;


public class DomRead_BMJHOW 
{
	public static void main(String argv[]) throws SAXException,
	IOException, ParserConfigurationException
	{
		
		File xmlFile = new File("hallgatok.xml");
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder.parse(xmlFile);
		BMJHOW.getDocumemtElement().normalize();
		System.out.println("Gyoker elem: " + neptunkod.getDocumentElement().getNodeName());
		NodeList nList = BMJHOW.getElementsByTagName("hallgato");
		
		for (int i = 0; i < nList.getLength(); i++) {
			Node nNode = nList.item(i);
			System.out 
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
