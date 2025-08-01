package Day11;

import java.io.FileWriter;
import java.io.IOException;

public class WritetoSimplefile {
	public static void main(String[] args) {
		try {
			FileWriter writer = new FileWriter("/Users/ruchithareddy/Desktop/Ruchi.txt");
			
			writer.write("Hello, i am trying to testing tools for my project\n");
			writer.write("Tools like automation and performance tools\n");
			
			writer.close();
			
			System.out.println("Data written to file successfully.");
		}
		catch(IOException e){
			System.out.println("An error occured while writing to the file.");
			e.printStackTrace();
		}
	}
}
