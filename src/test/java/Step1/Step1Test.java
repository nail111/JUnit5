package Step1;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class Step1Test {

    Step1 step1;

    @BeforeAll
    // BeforeAll method needs to be STATIC
   static void beforeAllInit() {
        System.out.println("This method should be run before all all");
    }

    @AfterAll
    static void afterAllMethods() {
        System.out.println("This method should be run before all all");
    }

    @BeforeEach
    void init() {
        step1 = new Step1();
    }

    @AfterEach
    void cleanUp() {
        System.out.println("Cleaning up...");
    }

    @Test
    void test1() {
        System.out.println("test1 has been successfully passed");
    }

    @Test
    void test2() {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1,2));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(1,2));
        assertEquals(list1,list2);
        // list1 - expected
        // list2 - actual
        System.out.println("test2 has been successfully passed");
    }

    @Test
    void test3() {
        assertThrows(NullPointerException.class,() -> step1.divide(2,0),"Should throw ArithmeticException");
        System.out.println("test3 has been successfully passed");
    }

}
