package Day10;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.io.Writer;

class Student6 implements Serializable {

    private String name;
    private int age;

    public Student6(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student6() {
        // default constructor
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

public class Serialization {
    public static void main(String[] args) throws IOException {
        Student6 s6 = new Student6();
        s6.setName("Ruchi");
        s6.setAge(21);

        try (Writer writer = new OutputStreamWriter(
                new FileOutputStream("/Users/ruchithareddy/Desktop/Ruchi.txt"), "UTF-8")) {

            writer.write("Name: " + s6.getName() + "\nAge: " + s6.getAge());
            System.out.println("Text written successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
