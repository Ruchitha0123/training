package Day3;
class Vehicle {
	   void start() {
	       System.out.println("Vehicle started");
	   }
	}
	class Car extends Vehicle {
	   void drive() {
	       System.out.println("Car is driving");
	   }
	}


public class Inheritance {
	 public static void main(String[] args) {
	       Car c = new Car();
	       c.start();  // from Vehicle
	       c.drive();  // from Car
	   }
}

