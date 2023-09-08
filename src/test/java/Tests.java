import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class Tests {
    ArrayList<Integer> testFibonacciArray;

    public void buildFibonacciArray() {
        testFibonacciArray = new ArrayList<>();
        testFibonacciArray.add(1);
        testFibonacciArray.add(1);
        testFibonacciArray.add(2);
        testFibonacciArray.add(3);
        testFibonacciArray.add(5);
        testFibonacciArray.add(8);
    }

    @Test
    public void testConvertNumberToZeckendorf() {
        buildFibonacciArray();

        String result = Main.convertNumberToZeckendorf(10, testFibonacciArray);
        assertEquals("10010 Zeck", result);
        assertNotEquals("100100 Zeck", result);

        result = Main.convertNumberToZeckendorf(6, testFibonacciArray);
        assertEquals("1001 Zeck", result);
        assertNotEquals("10010 Zeck", result);
    }

    @Test
    public void testGetFibonacciArray() {
        buildFibonacciArray();

        ArrayList<Integer> fibonacciArray = Main.getFibonacciArray(6);
        assertEquals(testFibonacciArray, fibonacciArray);
    }
}
