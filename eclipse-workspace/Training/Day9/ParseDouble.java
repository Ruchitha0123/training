package Day9;

public class ParseDouble {
    public static void main(String[] args) {
        String str = "45.67";                   // Step 1: String representing a decimal number
        double d = Double.parseDouble(str);     // Step 2: Convert String to double using parseDouble
        System.out.println("Parsed double: " + d); // Step 3: Print the double value
    }
}



