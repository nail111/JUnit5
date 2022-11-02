package Step1;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    @Test
    @DisplayName("5 + 10 = 15")
    void test1() {
        int a = 5;
        int b = 10;
        assertEquals(15, a + b, "5 + 10 should equal 15");
    }

    @AfterAll
    static void afterAllMethod() {
        System.out.println("--------------------------------------------");
        System.out.println("This method runs after all methods");
        System.out.println("--------------------------------------------");
    }

    @BeforeAll
    static void beforeAllMethod() {
        System.out.println("--------------------------------------------");
        System.out.println("This method runs before all methods");
        System.out.println("--------------------------------------------");
    }

    @AfterEach
    void afterEachMethod() {
        System.out.println("--------------------------------------------");
        System.out.println("This method runs after each method");
        System.out.println("--------------------------------------------");
    }

    @BeforeEach
    void beforeEachMethod() {
        System.out.println("--------------------------------------------");
        System.out.println("This method runs before each method");
        System.out.println("--------------------------------------------");
    }

    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
            "0, 1, 1",
            "2, 3, 5",
            "100, 200, 300"
    })
    void test2(int a, int b, int c) {
        assertEquals(c, a + b, () -> a + " + " + b + " should equal " + c);
    }

    @RepeatedTest(2)
    void test3() {
        System.out.println("This test repeats 2 times");
    }
}
