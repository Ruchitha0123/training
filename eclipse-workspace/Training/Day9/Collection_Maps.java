package Day9;
import java.util.HashMap;
import java.util.Map;



public class Collection_Maps {
	public static void main(String[]args) {
		Map<String,Integer>mapData=new HashMap<String,Integer>();
		mapData.put("A",50);
		mapData.put("B",60);
		mapData.put("C",80);
		mapData.put("D",40);
		System.out.println(mapData.keySet());
		System.out.println(mapData.values());
		for (String key:mapData.keySet()) {
			System.out.println(key+":"+mapData.get(key));
		}
		
		
		
	
	}

}

