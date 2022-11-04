package Step6;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class Step6 {

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"abb", "baa"})
    void test1(String str) {
        assertNull(str, () -> "" + str + " is not null");
    }

    @ParameterizedTest
    @EmptySource
    @ValueSource(strings = {" ", "a"})
    void test2(String str) {
        assumeTrue(str.isBlank(), () -> str + " is not blank");
    }

    @ParameterizedTest
    @NullAndEmptySource
    void test3(String str) {
        assertNull(str);
    }
}
