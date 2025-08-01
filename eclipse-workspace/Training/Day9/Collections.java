package Day9;
import java.util.ArrayList;
import java.util.Collection;

public class Collections {
	public static void main(String[] args) { 

    Collection<Integer> data=new ArrayList<Integer>();
    data.add(10);
    data .add(11);
    data.add(12);
    data.add(13);
    
    
    for (Object i:data) {
    	int data1=(Integer) i;
    	System.out.println(data1);
    }
    
    
}
}


