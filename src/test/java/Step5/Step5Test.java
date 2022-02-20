package Step5;

import Step3.Step3;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

public class Step5Test {
    Step3 step3;

    @BeforeEach
    void init() {
    step3 = new Step3();
    }

    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
            "0,1,1",
            "2,1,3",
            "5,6,11"
    })
    void test1(int a, int b, int c) {
        assertEquals(c, step3.addition(a,b));
    }

    @Test
    void test2() {
        fail("This Test should be fails");
    }

    @Test
    void test3() {
        assumeTrue("abc".contains("X"));
        fail("test3 fails...");
    }
}
