package day15;
import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import jxl.Workbook;
import jxl.write.*;
import jxl.write.Number;
public class XMLtoXLSDemo {
	public static void main(String[] args) throws Exception {
		WritableWorkbook myFirstWbook = null; 
		try {		
		myFirstWbook=Workbook.createWorkbook(new File("myfile.xls"));
		WritableSheet excelSheet = myFirstWbook.createSheet("Sheet 1", 0);
		DocumentBuilderFactory dcf=DocumentBuilderFactory.newInstance();
		dcf.setIgnoringElementContentWhitespace(true);
		dcf.setValidating(true);
		DocumentBuilder db=dcf.newDocumentBuilder();
		Document doc=db.parse("invoices.xml");
		NodeList nodeList = doc.getElementsByTagName("customer");
		int r=0,c=0;
		for (int itr = 0; itr < nodeList.getLength(); itr++)   
		{  
			Node node = nodeList.item(itr);    
			if (node.getNodeType() == Node.ELEMENT_NODE)   	
			{  
				Element eElement = (Element) node;  
				for(int j=0;j<node.getChildNodes().getLength();j++) {
					System.out.println(node.getChildNodes().item(j).getTextContent());
					Label label = new Label(c, r, node.getChildNodes().item(j).getTextContent());
		            excelSheet.addCell(label);
					c++;
					}
					r++;
					c=0;
			}  
		}  		
		nodeList = doc.getElementsByTagName("invoice");  
		for (int itr = 0; itr < nodeList.getLength(); itr++)   
		{  
			Node node = nodeList.item(itr);  
			if (node.getNodeType() == Node.ELEMENT_NODE)   	
			{  
				for(int j=0;j<node.getChildNodes().getLength();j++) {
					System.out.println(node.getChildNodes().item(j).getTextContent());
					Label label = new Label(c, r, node.getChildNodes().item(j).getTextContent());
		            excelSheet.addCell(label);
					c++;
				}
				r++;
				c=0;
			}  
		}
		myFirstWbook.write();


        } catch (IOException e) {
            e.printStackTrace();
        } catch (WriteException e) {
            e.printStackTrace();
        } finally {

            if (myFirstWbook != null) {
                try {
                    myFirstWbook.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (WriteException e) {
                    e.printStackTrace();
                }
            }

        }
        }

}
