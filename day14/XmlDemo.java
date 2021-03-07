package day14;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XmlDemo {
	public static void main(String[] args) throws Exception {
		DocumentBuilderFactory dcf=DocumentBuilderFactory.newInstance();
		dcf.setIgnoringElementContentWhitespace(true);
		dcf.setValidating(true);
		DocumentBuilder db=dcf.newDocumentBuilder();
		Document doc=db.parse("books.xml");
		System.out.println(doc.getDocumentElement().getNodeName());
		System.out.println(doc.getDocumentElement().getChildNodes().getLength());
		System.out.println(doc.getDocumentElement().getFirstChild().getNodeName());
		System.out.println(doc.getDocumentElement().getLastChild().getNodeName());
		Element RootElement=doc.getDocumentElement();
		for(int i=0;i<RootElement.getChildNodes().getLength();i++) {
			for(int j=0;j<RootElement.getChildNodes().item(i).getChildNodes().getLength();j++) {
				System.out.println(RootElement.getChildNodes().item(i).getChildNodes().item(j).getNodeName());
			}
		}
		System.out.println(RootElement.getNodeType());
	}
}
