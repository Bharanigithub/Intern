package Assignment_Components;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class MainProgram {
	public static void main(String[] args) throws Exception {
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the File Name to Parse:");
		String fileName=scan.next();
		System.out.println("Enter the Parser Type with Package Name:");
		String parserType=scan.next();
		Parser parser=ContainerClass.parserContainer(parserType,fileName);
		ArrayList<ArrayList<String>> st=parser.parse();
		System.out.println("Enter the File Name to Store the Content:");
		String outputFile=scan.next();
		PdfConverter pdfConverter=ContainerClass.pdfContainer().CreateObject();
		pdfConverter.convertToPdf(st, outputFile);
		CalculateDetails calculateDetails=ConsignmentDetails.getDetails();
		LocalDateTime localDateTime=calculateDetails.compute(calculateDetails);
		PrintDetails.printConsignmentDetails(localDateTime);
	}
}
