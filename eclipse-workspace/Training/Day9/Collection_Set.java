package Day9;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;



public class Collection_Set {
	public static void main(String[]args) {
		Set<Integer>setData=new HashSet<Integer>();
		setData.add(50);
		setData.add(60);
		setData.add(80);
		setData.add(80);
		System.out.println(setData);
		Iterator<Integer> iterator=setData.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
   }


}
