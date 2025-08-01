package Day8;
class Mul3 implements Runnable{
	public  void run() {
		for(int i=1;i<=200;i++) {
			System.out.println("this is ruchi");
			try {
				Thread.sleep(10);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
class Mul4 implements Runnable  {
	public  void run() {
		for(int i=1;i<=200;i++) {
			System.out.println("This is multithreading");
			try {
				Thread.sleep(10);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
				
			}
		}
	}
}
public class MultiThreading2 {
public static void main(String[] args) {
	Runnable m1=new Mul3();
	Runnable m2=new Mul4();
	//System.out.println(m2.getPriority());
	//m2.setPriority(Thread.MAX_PRIORITY);
	Thread t1=new Thread(m1);
	Thread t2=new Thread(m2);
	t1.start();
	t2.start();
}
}
