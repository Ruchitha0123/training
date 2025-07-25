package Day6;
interface Printer {
 void print();
}

interface Scanner {
 void scan();
}

interface Fax {
 void fax();
}

interface Copier {
 void copy();
}

interface Machine {
 void showDeviceType();     
 default void greet() {     
	 System.out.println("Welcome to the Smart Office Machine!");
 }
}

public class SmartOfficeMachineVoid implements Printer, Scanner, Fax, Copier, Machine {

 public void print() {
     System.out.println("Printing document using SmartOfficeMachine...");
 }

 public void scan() {
     System.out.println("Scanning document using SmartOfficeMachine...");
 }
 
 public void fax() {
     System.out.println("Sending fax using SmartOfficeMachine...");
 }

 public void copy() {
     System.out.println("Copying document using SmartOfficeMachine...");
 }

 public void showDeviceType() {
     System.out.println("Device Type: All-in-One Smart Office Machine.");
 }


 public void greet() {
     System.out.println("Hello! I’m your digital assistant for printing, scanning, faxing, and copying.");
 }

 public static void main(String[] args) {
     SmartOfficeMachineVoid device = new SmartOfficeMachineVoid();

     device.greet();
     device.showDeviceType();
     device.print();
     device.scan();
     device.fax();
     device.copy();
 }
}
