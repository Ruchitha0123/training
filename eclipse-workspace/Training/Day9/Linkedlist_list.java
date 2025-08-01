package Day9;

import java.util.LinkedList;
import java.util.List;
import java.util.Collections;

public class Linkedlist_list {
    public static void main(String[] args) {
        List<Integer> data = new LinkedList<Integer>();
        data.add(10);
        data.add(14);
        data.add(12);
        data.add(13);

        System.out.println(data.get(3));          // prints element at index 3 → 13
        System.out.println(data.indexOf(13));     // prints index of value 13 → 3

        // Sort the list
        Collections.sort(data);

        // Print sorted list
        for(Object i : data) {
            int data1 = (Integer) i;
            System.out.println("Sorted list: " + data1);
        }
    }
}
	

