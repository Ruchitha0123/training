package Day6;

interface SmartDevice {
 void greet();

 default void welcomeMessage() {
     System.out.println("Welcome to EasySmart Device!");
 }

 static void brandInfo() {
     System.out.println("Brand: EasySmart - Simplifying Smart Tech.");
 }
}

public class EasySmartDevice implements SmartDevice {

 public void greet() {
     System.out.println("Hello! I’m your EasySmart Assistant.");
 }

  public void showFeatures() {
     System.out.println("I can Play Music, Navigate, Make Calls, and Assist you.");
 }

 public static void main(String[] args) {
     EasySmartDevice device = new EasySmartDevice();

     device.greet();              
     device.welcomeMessage();     
     SmartDevice.brandInfo();     
     device.showFeatures();       
 }
}
