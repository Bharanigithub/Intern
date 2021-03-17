package Assignment_Components;

import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxParser extends Parser {
	public SaxParser() {
		// TODO Auto-generated constructor stub
	}
	private static SaxParser saxParser;

	public static SaxParser createObject() throws Exception {
		if(saxParser==null) {
			saxParser=new SaxParser();
			SaxParser obj=(saxParser).clone();
			return obj;
		}
		else
			return saxParser.clone();
	}
	@Override
	protected SaxParser clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return (SaxParser)super.clone();
	}

	public ArrayList<ArrayList<String>> arrayList = new ArrayList<ArrayList<String>>();
	public String fileName;

	@Override
	public ArrayList<ArrayList<String>> parse() {
		ArrayList<ArrayList<String>> str;
		try {
			// TODO Auto-generated method stub
			MyHandler myHandler=MyHandler.createObject();
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sp = spf.newSAXParser();
			sp.parse(fileName, myHandler);
			str = myHandler.method();
			this.arrayList=str;
		} catch (Exception e) {
		}
		return arrayList;
	}

	@Override
	public void getFile(String fileName) {
		// TODO Auto-generated method stub
		this.fileName = fileName;
	}
}

class MyHandler extends DefaultHandler implements Cloneable {
	private static MyHandler myHandle;
	@Override
	protected MyHandler clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return (MyHandler)super.clone();
	}
	public static MyHandler createObject() throws Exception {
		if(myHandle==null) {
			myHandle=new MyHandler();
			MyHandler obj=myHandle.clone();
			return obj;
		}
		else {
			return myHandle.clone();
		}
	}
	int start1 = 0;
	int end = 0, s1 = 0, s2 = 0;
	boolean status = false;
	ArrayList<ArrayList<String>> al = new ArrayList<ArrayList<String>>();
	ArrayList<ArrayList<String>> finalList = new ArrayList<ArrayList<String>>();
	ArrayList<String> temp1 = new ArrayList<>();
	ArrayList<String> temp2 = new ArrayList<>();

	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
	}

	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		s1++;
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		s2++;
		if (s1 != s2) {
			al.add(temp1);
			al.add(temp2);
			temp1 = new ArrayList<>();
			temp2 = new ArrayList<>();
			s1 = s2;
		}
		String str = new String(ch, start, length);
		status = true;
		temp2.add(str);
		start1 = end;

	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		// String str=new String(ch, start, length);
		// System.out.print(qName);
		if (status == true) {
			temp1.add(qName);
			// System.out.println(temp1);
			status = false;
		}
		end++;
		if (end - start1 > 1) {
			al.add(temp1);
			al.add(temp2);
			temp1 = new ArrayList<>();
			temp2 = new ArrayList<>();
			start1 = end;
		}
	}

	public ArrayList<ArrayList<String>> method() {
		ArrayList<String> aa = new ArrayList<>();
		for (int i = 0; i < al.size(); i++) {
			aa = al.get(i);
			if (!finalList.contains(aa) && !aa.isEmpty()) {
				finalList.add(aa);
			}
		}
		return finalList;
	}
}
