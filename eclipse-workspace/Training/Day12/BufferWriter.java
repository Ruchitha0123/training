package Day12;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class BufferWriter {
	public static void main(String[] args) throws IOException {
		BufferedWriter br=new BufferedWriter(new FileWriter("/Users/ruchithareddy/buffer.txt",true));
		{
			br.write("This is written using FileWriter");
			//br.newLine();
			br.close();
			System.out.println("Written Successfully");
		}
		
	}
}


