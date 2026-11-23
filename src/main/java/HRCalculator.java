public class HRCalculator {
    public static int calculateMaxHR(int age) {
        if (age > 120 || age < 0) {
            throw new IllegalArgumentException("Age out of bounds");
        }
        return 220 - age;
    }
    public static String getWorkoutZone(int age, int bpm) {
        if (age > 120 || age < 0){
            throw new IllegalArgumentException("Age out of bounds");
        }
        int maxHR = calculateMaxHR(age);
        if (bpm > 220 || bpm <= 0 || bpm > maxHR){
            throw new IllegalArgumentException("BPM out of bounds");
        }
        double percentageOfMaxHR = (double) (100 * bpm) /maxHR;
        if (percentageOfMaxHR < 50) return "Resting";
        if (percentageOfMaxHR < 60) return "Recovery";
        if (percentageOfMaxHR < 70) return "Fat Burn";
        if (percentageOfMaxHR < 80) return "Aerobic";
        if (percentageOfMaxHR < 90) return "Anaerobic";
        else return "V02 Max";
    }
}