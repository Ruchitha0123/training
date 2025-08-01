package Day6;
interface StudyBuddy {
	
    void startSession();

    default void greetUser() {
        System.out.println(" Hi there, ready to conquer your study goals today?");
    }

    static void showPlatformInfo() {
        System.out.println(" Platform: BrainBloom - Smart Learning for Smart Women.");
    }
}

public class StudyBuddy_SD implements StudyBuddy {

    public void startSession() {
        System.out.println("Session Started: Today's Focus - Java Basics & Coding Practice.");
    }

    public static void main(String[] args) {
        StudyBuddy_SD buddy = new StudyBuddy_SD();
        buddy.greetUser();
        buddy.startSession();          
        StudyBuddy.showPlatformInfo(); 
    }
}
