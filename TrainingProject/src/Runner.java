import java.io.FileNotFoundException;
import java.io.IOException;


public class Runner{

	public Runner() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		FileReader fileReader= new FileReader(args[0], args[1], args[2]);
		try {
				fileReader.witeOutPutFile(fileReader.concatFiles(fileReader.readFiles()));
				System.out.println(fileReader.concatFiles(fileReader.readFiles()));
				
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
