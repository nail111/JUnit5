package Step2;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Step2 {

    @Disabled
    @Test
    void test1() {
        System.out.println("This method is disabled");
    }

    @EnabledOnOs(OS.LINUX)
    @Test
    void test2() {
        System.out.println("This method is only for Linux OS");
    }

    @EnabledOnJre(JRE.JAVA_11)
    @Test
    void test3() {
        System.out.println("This method is only for JRE 11");
    }

    @Test
    void test4() {
        assertAll(
                () -> assertEquals(5, 2 + 3),
                () -> assertEquals(6, 2 * 3));
    }

    @Nested
    class Test5 {

        @Test
        @DisplayName("First")
        void nestedMethod1() {
            System.out.println("Done - 1");
        }

        @Test
        @DisplayName("Second")
        void nestedMethod2() {
            System.out.println("Done - 2");
        }
    }
}
