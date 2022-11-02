package Step3;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class Step3 {
    TestInfo testInfo;
    TestReporter testReporter;

    @BeforeEach
    void init(TestInfo testInfo, TestReporter testReporter) {
        this.testInfo = testInfo;
        this.testReporter = testReporter;
    }

    @Test
    @Tag("Nail") // Only Intellij Idea Ultimate can use tags
    void test1() {
        testReporter.publishEntry(testInfo.getTags() + " || " + testInfo.getTestMethod());
    }

    @Test
    void test2() {
        fail("This method must fail");
    }

    @Test
    void test3() {
        assumeTrue("abc".contains("c"));
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void test4(int a) {
        System.out.println(a);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Hello", "World"})
    void test5(String str) {
        System.out.println(str);
    }
}
