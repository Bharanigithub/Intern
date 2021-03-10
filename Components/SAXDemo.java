package Components;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXDemo {
	public ArrayList<ArrayList<String>> SaxParser() throws Exception  {
		SAXParserFactory spf=SAXParserFactory.newInstance();
		SAXParser sp=spf.newSAXParser();
		sp.parse("invoice.xml", new MyHandler());
		ArrayList<ArrayList<String>> str=new MyHandler().method();
		return str;
	}
}

class MyHandler extends DefaultHandler {
	static int start1=0;
	static int end=0,s1=0,s2=0;
	static boolean status=false;
	static ArrayList<ArrayList<String>> al=new ArrayList<ArrayList<String>>();
	static ArrayList<ArrayList<String>> finalList=new ArrayList<ArrayList<String>>();
	ArrayList<String> temp1=new ArrayList<>();
	ArrayList<String> temp2=new ArrayList<>();
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
		if(s1!=s2) {
			al.add(temp1);
			al.add(temp2);
			temp1=new ArrayList<>();
			temp2=new ArrayList<>();
			s1=s2;
		}
		String str=new String(ch,start,length);		
			status=true;
			temp2.add(str);
			start1=end;
			
	}
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		//String str=new String(ch, start, length);
		//System.out.print(qName);
		if(status==true) {
			temp1.add(qName);
			//System.out.println(temp1);
			status=false;
		}
		end++;
		if(end-start1>1) {
			al.add(temp1);
			al.add(temp2);
			temp1=new ArrayList<>();
			temp2=new ArrayList<>();
			start1=end;
		}
		
	}
	public static ArrayList<ArrayList<String>> method() {
		ArrayList<String> aa=new ArrayList<>();
		for(int i=0;i<al.size();i++) {
			aa=al.get(i);
			if(!finalList.contains(aa) && !aa.isEmpty()) {
				finalList.add(aa);
			}
		}
		for(int i=0;i<al.size();i++) {
			aa=al.get(i);
			System.out.println(aa);
		}
		return finalList;
	}
}
