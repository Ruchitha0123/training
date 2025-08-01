package Day5;

abstract class Vehicle1 {
		abstract void Speed();
		abstract void Brand();
	}
	class Car extends Vehicle1{
		void Speed() {
			System.out.println("speed of car =80km/hr");
		}
		void Brand(){
			System.out.println("Audi");
		}
	}
	class Bike extends Vehicle1{
		void Speed() {
			System.out.println("speed:5o km/hr");
		}
		void Brand() {
			System.out.println("bmw");
		}
		
}

