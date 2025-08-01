package Day2;

public class BuilderExample {
	public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= 5; i++) {
            sb.append("Line ").append(i).append("\n");
        }

        System.out.println("Result:\n" + sb);
    }


}
