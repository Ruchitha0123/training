package wipro_keyword;
class Utils {
    public static int add(int x, int y) {
        return x + y;
    }
}

public class Staticmethodexample {
	public static void main(String[] args) {
        int sum = Utils.add(5, 7); 
        System.out.println(sum);
	}

}
