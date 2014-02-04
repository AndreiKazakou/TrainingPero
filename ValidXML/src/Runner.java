import java.io.IOException;

import org.xml.sax.SAXException;


public class Runner {

	public Runner() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		ValidationNotified valid = new ValidationNotified();
		valid.validateDocBuilder();
		try {
			valid.validateJAPI();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
