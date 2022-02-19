package Step3;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class Step3Test {

    Step3 step3;

    @BeforeEach
    void init() {
        step3 = new Step3();
    }

    @Test
    void test1() {
        // if one of them is not equal then this test fails
        assertAll(
                () -> assertEquals(5,step3.addition(1,4)),
                () -> assertEquals(3, step3.addition(1,1))
        );
    }

    @Nested
    class adding {
        @Test
        @DisplayName("Positive")
        void addPositive() {
            assertEquals(4,step3.addition(2,2));
            System.out.println("addPositive is cool");
        }

        @Test
        @DisplayName("Negative")
        void addNegative() {
            assertEquals(-2,step3.addition(-1,-1));
            System.out.println("addNegative is cool");
        }
    }

    @RepeatedTest(3)
    void repeated() {
        System.out.println("This test must be repeated 3 times");
    }
}
