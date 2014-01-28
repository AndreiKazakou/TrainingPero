import java.io.FileNotFoundException;
import java.io.IOException;


public class Runner{

	public Runner() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		System.out.println("Please enter the path of three files in the strict order:");
		System.out.println("1) Origing file;\n2) Concating file;\n3) Output file;\n");
		
		FileReader fileReader= new FileReader(args[0], args[1], args[2]);
		try {
				fileReader.witeOutPutFile(fileReader.concatFiles(fileReader.readFiles()));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
