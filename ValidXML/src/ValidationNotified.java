import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;


public class ValidationNotified {

	public ValidationNotified() {
	}
		
	
	public void validateDocBuilder(){
		try {
			  DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			  factory.setNamespaceAware( true);
			  factory.setValidating(true);
			  
			  factory.setAttribute( "http://java.sun.com/xml/jaxp/properties/schemaLanguage", 
                      "http://www.w3.org/2001/XMLSchema");
			  factory.setAttribute( "http://java.sun.com/xml/jaxp/properties/schemaSource", 
                      "file:src/schema.xsd");

			  DocumentBuilder builder = factory.newDocumentBuilder();

			  Document document = builder.parse(new InputSource("src/valid.xml"));
			  NodeList list = document.getElementsByTagName("atlas-document");

	            for (int i = 0; i < list.getLength() ; i++)
	            {
	                Element listSize = (Element) list.item(i);
	                String pSize = listSize.getAttribute("xmlns:xsi");

	                System.out.println(pSize);
	            }

			} catch ( ParserConfigurationException e) {
			  e.printStackTrace();
			} catch ( SAXException e) {
			  e.printStackTrace();
			} catch ( IOException e) {
			  e.printStackTrace();
			}
	}
	
	public void validateJAPI() throws IOException, SAXException{
		
        SchemaFactory factory = 
            SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        
     
        File schemaLocation = new File("src/schema.xsd");
        Schema schema = factory.newSchema(schemaLocation);
    
        Validator validator = schema.newValidator();
        

        Source source = new StreamSource("src/valid.xml");
        
        try {
            validator.validate(source);
            System.out.println( "valid.xml"+ " is valid.");
        }
        catch (SAXException ex) {
            System.out.println("valid.xml" + " is not valid because ");
            System.out.println(ex.getMessage());
        }  
	}

}
