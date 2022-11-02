package Step4;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

public class Step4 {

    @Test
    void test1() {
        assertEquals(10, 2 * 5, () -> "It must be 10");
    }

    @Test
    void test2() {
        assertTrue(true, () -> "It must be true");
    }

    @Test
    void test3() {
        assertAll(
                () -> assertEquals(2, 1 + 1, () -> "Must be 2"),
                () -> assertTrue(true, "Must be true")
        );
    }

    @Test
    void test4() {
        assertNotNull(new String("Hello"));
    }

    @Test
    void test5() {
        assertTimeout(Duration.ofSeconds(5), () -> System.out.println("Oops..."));
    }

    @Test
    void test6() {
        assertThat(2 + 3, is(equalTo(5)));
    }
}
