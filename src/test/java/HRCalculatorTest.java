import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HRCalculatorTest {
    @Test
    public void testValidMaxHR() {
        var result = HRCalculator.calculateMaxHR(25);
        assertEquals(195, result);
    }
    @Test
    public void testInvalidMaxHR_ageTooHigh() {
        assertThrows(IllegalArgumentException.class,
                () -> HRCalculator.calculateMaxHR(500));
    }
    @Test
    public void testInvalidMaxHR_ageTooLow() {
        assertThrows(IllegalArgumentException.class,
                () -> HRCalculator.calculateMaxHR(-1));
    }
    @Test
    public void testValidWorkoutZone() {
        var result = HRCalculator.getWorkoutZone(25, 190);
        assertEquals("V02 Max", result);
    }
    @Test
    public void testInvalidWorkoutZone_bpmTooHigh() {
        assertThrows(IllegalArgumentException.class,
                () -> HRCalculator.getWorkoutZone(25, 220));
    }
    @Test
    public void testInvalidWorkoutZone_bpmTooLow() {
        assertThrows(IllegalArgumentException.class,
                () -> HRCalculator.getWorkoutZone(25, 0));
    }
    // doesn't really need to be tested, since it depends on calculateMaxHR()
    @Test
    public void testInvalidWorkoutZone_invalidAge() {
        assertAll(
                () -> assertThrows(IllegalArgumentException.class,
                        () -> HRCalculator.getWorkoutZone(-1, 150)),
                () -> assertThrows(IllegalArgumentException.class,
                        () -> HRCalculator.getWorkoutZone(121, 150))
        );
    }
}