package Day12;
import java.io.FileReader;
import java.io.IOException;
public class ReadFile {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileReader reader=new FileReader("/Users/ruchithareddy/readfile.txt");
		int ch;
		while((ch=reader.read())!=-1)
		{
			System.out.println((char) ch);
		}
		
		}	
	}
