package Day3;
class Shape {
    void draw() {
        System.out.println("Drawing a shape");
    }
}

class Circle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing a circle");
    }
}

class Rectangle extends Shape {
	@Override
    void draw() {
        System.out.println("Drawing a rectangle");
    }
}


public class PolymorphismExample {
	 public static void main(String[] args) {
	        Shape s1 = new Circle();
	        Shape s2 = new Rectangle();
	        s1.draw();
	        s2.draw();
	    }
}
