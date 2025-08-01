package Day11;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;


public class listiterator {
	public static void main(String[] args) {
		List<String>list = new ArrayList<String>(List.of("A","B","C","D","E"));
		ListIterator<String>it = list.listIterator();
		
		System.out.println("Forward:");
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		System.out.println("Backward:");
		while(it.hasPrevious()) {
			System.out.println(it.previous());
		}
	}

}

