package Day5;

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class AttendanceSystem {
	public static void main(String[] args) {
		Map<String, Boolean> attendanceMap = new HashMap<>();
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("\n-------Choose an Option------");
			System.out.println("1. Mark Attendance.");
			System.out.println("2. View Attendance.");
			System.out.println("3. Exit");
			
			int choice = scanner.nextInt();
			scanner.nextLine();
			switch (choice) {
			case 1:
				System.out.println("Enter the student Name: ");
				String name = scanner.nextLine();
				System.out.println("IS the student present (yes/no): ");
				String response = scanner.nextLine().toLowerCase();
				boolean isPresent = response.equals("yes");
				attendanceMap.put(name, isPresent);
				System.out.println("Attendance was marked for "+name+" Successfully.");
				break;
			case 2:
				System.out.println("\n -------Attendance List------");
				if (attendanceMap.isEmpty()) {
					System.out.println("No Attendance data available...!");
				} else {
					for (Map.Entry<String, Boolean> entry : attendanceMap.entrySet()) {
						String status = entry.getValue() ? "Present" : "Absent";
						System.out.println(entry.getKey()+ " - " + status);
					}
				}
				break;
			case 3:
				System.out.println("Exiting attendance System....!!!!");
				scanner.close();
				System.exit(0);
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}
	}

}