package DOM_BMJHOW;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMQueryBMJHOW {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        File xmlFile = new File("XY_XML.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = factory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);
        doc.getDocumentElement().normalize();
        System.out.println("Gyökér elem: " + doc.getDocumentElement().getNodeName() + "\n");

        //Kérdezze le azokat a szakácsokat, akiknek a végzettségeik között van szakközépiskola
        System.out.println("Azok a szakácsok, akiknek a végzettségeik között van szakközépiskola:\n");

        NodeList nodeList = doc.getElementsByTagName("szakacs");

        for(int i = 0; i < nodeList.getLength(); i++) {
            Node nNode = nodeList.item(i);
            if(nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) nNode;
                Node node3;
                //Kérdezze le azokat a szakácsok végzettségeiket, amelyek között van szakközépiskola és hol dolgozik
                for(int j=0;j<elem.getElementsByTagName("vegzettseg").getLength();j++) {
                    node3 = elem.getElementsByTagName("vegzettseg").item(j);
                    String edul = node3.getTextContent();
                    //Ha igen, akkor kiíratom az adatait
                    if("Szakközépiskola".equals(edul)) {
                        String id = elem.getAttribute("szkod");
                        String eid = elem.getAttribute("e_sz");
                        String work = "Ez a szakács a(z) " + eid + " azonosítójú étteremben dolgozik.";
                        Node node1 = elem.getElementsByTagName("nev").item(0);
                        String name = node1.getTextContent();
                        Node node2 = elem.getElementsByTagName("reszleg").item(0);
                        String department = node2.getTextContent();

                        String edu2 = "";
                        for(int k=0;k<elem.getElementsByTagName("vegzettseg").getLength();k++) {
                            node3 = elem.getElementsByTagName("vegzettseg").item(k);
                            if(k == elem.getElementsByTagName("vegzettseg").getLength()-1) {
                                edu2 += node3.getTextContent();
                            }else {
                                edu2 += node3.getTextContent() + ", ";
                            }
                        }

                        System.out.println("Szakács ID: " + id);
                        System.out.println("Név: " + name);
                        System.out.println("Részleg: " + department);
                        System.out.println("Végzettségek: " + edu2);
                        System.out.println(work + "\n");
                    }
                }
            }
        }

       System.out.println("----------");
       
             

       
   
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       