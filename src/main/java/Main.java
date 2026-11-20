import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter your age: ");
        int age = Integer.parseInt(myObj.nextLine());
        System.out.println("Enter your bpm: ");
        int bpm = Integer.parseInt(myObj.nextLine());
        int maxHR = HRCalculator.calculateMaxHR(age);
        String workoutZone = HRCalculator.getWorkoutZone(age, bpm);
        System.out.printf(
                "age = %d, BPM = %d -> maximum heart rate = %d, workout zone = %s%n",
                age, bpm, maxHR, workoutZone);
    }
}
