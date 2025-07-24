package Day5;
interface WiproSystems{
	void deviceType();
	void compileSpeed();
	
}
class Desktop implements WiproSystems{
	public void deviceType() {
		System.out.println("Wipro provides device:DESKTOP");
	}
	public void compileSpeed() {
		System.out.println("Code is compiled faster in Desktop");
	}
}
class laptop implements WiproSystems{
	public void deviceType() {
		System.out.println("Wipro provides device:LAPTOP");
	}
	public void compileSpeed() {
		System.out.println("Code is compiled slower in laptop");
	
}
}

public class WiproDevices{
	public static void main(String[] args) {
		WiproSystems laptop=new laptop();
		laptop.deviceType();
		laptop.compileSpeed();
		
		WiproSystems desktop=new Desktop();
		desktop.deviceType();
		desktop.compileSpeed();
	}
}






