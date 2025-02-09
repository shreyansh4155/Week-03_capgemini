package stringconcatenationperformance;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class StringConcatenationTest {

    @Test
    public void testStringConcatenation() {
        int[] operationCounts = {1000, 10000, 1000000};

        for (int count : operationCounts) {
            long timeString = StringConcatenation.stringConcatenation(count);
            long timeStringBuilder = StringConcatenation.stringBuilder(count);
            long timeStringBuffer = StringConcatenation.stringBuffer(count);

            System.out.println("\n===== For operation count: " + count + " =====");
            System.out.println("Time taken by String: " + timeString / 100000.0 + "ms");
            System.out.println("Time taken by StringBuilder: " + timeStringBuilder / 100000.0 + "ms");
            System.out.println("Time taken by StringBuffer: " + timeStringBuffer / 100000.0 + "ms");

            // Verify that StringBuilder and StringBuffer are faster than String concatenation
            assertTrue(timeStringBuilder < timeString, "StringBuilder should be faster than String for count: " + count);
            assertTrue(timeStringBuffer < timeString, "StringBuffer should be faster than String for count: " + count);
        }
    }
}
