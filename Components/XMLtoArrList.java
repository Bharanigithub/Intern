package Components;

import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;



public class XMLtoArrList {
	String file;
	public XMLtoArrList() {
		// TODO Auto-generated constructor stub
	}
	public void putFile(String fileName) {
		this.file=fileName;
	}
	public ArrayList<ArrayList<String>> getFileAsArrList() throws Exception {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setIgnoringElementContentWhitespace(true);
		dbf.setValidating(true);

		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(this.file);
		ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
		ArrayList<String> title = new ArrayList<String>();
		Node n = doc.getDocumentElement().getFirstChild();
		int count = 0;
		while (n != null) {
			NodeList nl = n.getChildNodes();
			if (nl.getLength() != count) {
				count = nl.getLength();
				for (int i = 0; i < nl.getLength(); i++) {
					title.add(nl.item(i).getNodeName());
				}
				data.add(title);
				title = new ArrayList<String>();
			}
			for (int i = 0; i < nl.getLength(); i++) {
				//if(nl.item(i).getFirstChild().getNodeValue()!=null)
					title.add(nl.item(i).getFirstChild().getNodeValue());
			}
			data.add(title);
			title = new ArrayList<String>();
			n = n.getNextSibling();
		}
		return data;
	}
}
