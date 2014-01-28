
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class FileReader {
	
	private  File firstFile, secondFile, outPutFile  = null;
	private Scanner scaner1=null;
	private Scanner scaner2=null;

	
	public FileReader(String pathFirstFile, String pathSecondFile, String pathOutPutFile) {
		 firstFile = new File(pathFirstFile);
		 secondFile = new File(pathSecondFile);
		 outPutFile = new File(pathOutPutFile); 
	}
	
	public List<StringBuffer> readFiles() throws FileNotFoundException  {
		
		 scaner1= new Scanner(firstFile);
		 scaner2= new Scanner(secondFile);
		
		List<StringBuffer> filesStringBox = new ArrayList<StringBuffer>();
		StringBuffer strBuff1= new StringBuffer();
		StringBuffer strBuff2= new StringBuffer();
		while(scaner1.hasNext()){
			strBuff1.append(scaner1.next());
		}
		while(scaner2.hasNext()){
			strBuff2.append(scaner2.next());
		}
		filesStringBox.add(strBuff1);
		filesStringBox.add(strBuff2);
		
		return  filesStringBox;	
	}
	
	public String concatFiles( List<StringBuffer> filesStringBox){
		StringBuffer resultString= new StringBuffer();
		for(StringBuffer temp:filesStringBox){
			resultString.append(temp.toString());
		}
		return resultString.toString();
	}
	
	public void witeOutPutFile(String contents) throws IOException{
		FileWriter writer= new FileWriter(outPutFile);
		writer.append(contents);
		writer.close();
	}
	
	public void cleanFile(String path) throws IOException{
		File cleanfile= new File(path);
		FileWriter cleaner= new FileWriter(cleanfile);
		cleaner.write("");
	}

}
