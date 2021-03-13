package Assignment_Components;

public class ContainerClass {
	public static Parser parserContainer(String parserName,String fileName) throws Exception {
		Parser parser=(Parser)Class.forName(parserName).getConstructor().newInstance();
		parser.getFile(fileName);
		return parser;
	}
	public static PdfConverter pdfContainer() throws Exception {
		PdfConverter pdfConverter=PdfConverter.CreateObject();
		return pdfConverter;
	}
	public static XlsConverter xlsContainer() throws Exception {
		XlsConverter xlsConverter=XlsConverter.CreateObject();
		return xlsConverter;
	}
}
