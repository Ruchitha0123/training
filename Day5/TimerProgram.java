package Day5;
import java.util.ArrayList;
abstract class TaskReminder {
    abstract void remindTasks();
}
class DailyTaskReminder extends TaskReminder {
    public void remindTasks() {
        ArrayList<String> tasks = new ArrayList<>() {{
           add("Wake up");
           add("Breakfast");
            add("Join the meet");
            add("Involve in the meet");
            add("Practice Codes");
        }};

        double[] times = {8.00,8.30,8.50, 9.00, 12.00};

        System.out.println(" Daily Task Reminder \n");

        for (int i = 0; i < tasks.size(); i++) {
            String pmAm = (times[i] >= 1 && times[i] <= 9) || times[i] > 12 ? "AM" : "PM";
            System.out.printf("Time: %.2f %s\n", times[i], pmAm);
            System.out.println("Task: " + tasks.get(i));
        }
    }
}

public class TimerProgram {
    public static void main(String[] args) {
        new DailyTaskReminder().remindTasks();
    }
}