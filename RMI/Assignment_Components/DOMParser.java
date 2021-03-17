package Assignment_Components;

import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMParser extends Parser {
	String file;
	public DOMParser() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void getFile(String fileName) {
		this.file=fileName;
		
	}
	@Override
	public ArrayList<ArrayList<String>> parse(){
		ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
		ArrayList<String> title = new ArrayList<String>();
		try {
			
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setIgnoringElementContentWhitespace(true);
		dbf.setValidating(true);

		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(this.file);
		data = new ArrayList<ArrayList<String>>();
		title = new ArrayList<String>();
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
		}catch(Exception e) {}
		return data;
	}
	
	private static DOMParser domParser;

	public static DOMParser createObject() throws Exception {
		if(domParser==null) {
			domParser=new DOMParser();
			DOMParser obj=(domParser).clone();
			return obj;
		}
		else
			return domParser.clone();
	}
	@Override
	protected DOMParser clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return (DOMParser)super.clone();
	}
}
