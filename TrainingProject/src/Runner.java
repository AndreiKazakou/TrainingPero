import java.io.FileNotFoundException;
import java.io.IOException;


public class Runner{

	public Runner() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		FileReader fileReader= new FileReader(args[0], args[1], args[2] , args[3]);
		try {
				System.out.println("------------------------------------------------------");
				fileReader.witeOutPutFile(fileReader.concatFiles(fileReader.readFiles()));
				System.out.println("results of concatination:");
				System.out.println(fileReader.concatFiles(fileReader.readFiles()));
				System.out.println("------------------------------------------------------");
				System.out.println("results of reg exp:");
				System.out.println(fileReader.regXpFile(fileReader.concatFiles(fileReader.readFiles())));
				
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
