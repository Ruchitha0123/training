package Day2;

public class CompareStrings {
	public static void main(String[] args) {
        String str = "Java";
        str.concat(" World");  
        System.out.println("String (immutable): " + str);  

        StringBuffer sb1 = new StringBuffer("Java");
        sb1.append(" World");
        System.out.println("StringBuffer (mutable): " + sb1);  

        StringBuilder sb2 = new StringBuilder("Java");
        sb2.append(" World");
    }


}
