package Day7;
import java.io.BufferedReader;
import java.io.FileReader;
public class TCF_CSV {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("/Users/ruchithareddy/Desktop/Employees.csv"));
			String line;
			while((line=br.readLine())!=null) {
				System.out.println("Line: " + line);
			}
			br.close();
		} catch (Exception e) {
			System.out.println("Error reading CSV: " + e.getMessage());
		}
		finally {
			System.out.println("Code Executed......");
		}
}

}
