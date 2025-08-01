package Day6;
interface A {
    void show();
}

interface B {
    void show();
}

interface C {
    void show();
}

class Java implements A, B, C {
    public void show() {
        System.out.println("Hello from Interface ");
    }
}

public class Interface {
    public static void main(String[] args) { 
    	A obj =new  Java();
    	obj.show();
    }
    
}
