package Step4;

import org.junit.jupiter.api.*;


public class Step4Test {
    TestInfo testInfo;
    TestReporter testReporter;

    @BeforeEach
    void init(TestInfo testInfo, TestReporter testReporter) {
        this.testInfo = testInfo;
        this.testReporter = testReporter;
    }

    @Test
    @Tag("Nail") // Intellij Idea Ultimate can run only tags
    @DisplayName("Just test1")
    void test1() {
        System.out.println("Display name: "+ testInfo.getDisplayName()+ " || Tag name: " + testInfo.getTags());

    }

    @Test
    @Tag("Admin")
    @DisplayName("Just test2")
    void test2() {
        testReporter.publishEntry("Display name: "+ testInfo.getDisplayName()+ " || Tag name: " + testInfo.getTags());
    }
}
