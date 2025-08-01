package Day10;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileComparator {
	public static void main(String[] args) throws IOException{
		BufferedReader file1 = new BufferedReader(new FileReader("/Users/ruchithareddy/Desktop/file1.txt"));
		BufferedReader file2 = new BufferedReader(new FileReader("/Users/ruchithareddy/Desktop/file2.txt"));
		
		String line1 = "", line2 = "";
		boolean areEqual = true;
		while ((line1 = file1.readLine()) != null & (line2 = file2.readLine()) != null) {
			if (!line1.equals(line2)) {
				areEqual = false;
				break;
			}
		}
	
		if(file1.readLine() != null || file2.readLine() != null) {
			areEqual = false;
		}
		if(areEqual)
			System.out.println("Files are same.");
		else
			System.out.println("Files are different.");
		
		file1.close();
		file2.close();
	
	}
}