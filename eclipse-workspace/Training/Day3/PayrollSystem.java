package Day3;
public class PayrollSystem {

public static void main(String[] args) {
    Employee e1 = new FullTimeEmployee("Ruchi", 101, 50000);
    Employee e2 = new PartTimeEmployee("Pandu", 102, 80, 300);

    e1.display();
    System.out.println("Salary: ₹" + e1.calculateSalary());

    System.out.println();

    e2.display();
    System.out.println("Salary: ₹" + e2.calculateSalary());
}
}

