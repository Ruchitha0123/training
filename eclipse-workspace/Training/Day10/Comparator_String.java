package Day10;



import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
class Student1 implements Comparable<Student1>
{
	public int age;
	 public String name;
	
	
	 public Student1(int age, String name) {
		this.age=age;
		this.name=name;
	}
	public String toString() {
		return "Student[age=" +age+ ",name=" +name+ "]";
	}
	@Override
	public int compareTo(Student1 o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
public class Comparator_String {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Comparator<Student1> com=new Comparator<Student1>() {
			public int compare(Student1 i, Student1 j) {
				if(i.age>j.age)
					return 1;
				else
					return -1;
			}
		};
        List<Student1> stud= new ArrayList<>();
        stud.add(new Student1(21,"Ruchii"));
        stud.add(new Student1(24,"harshi"));
        stud.add(new Student1(23,"Sujana"));
        Collections.sort(stud,com);
       
    for(Student1 s:stud) {
   	 System.out.println(s);
    }
   
   
       
	}
}
