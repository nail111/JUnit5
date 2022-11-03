package Step5;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.condition.DisabledIf;
import org.junit.jupiter.api.condition.EnabledIf;

import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Step5 {

    @Test
    @Order(1)
    void test1() {
        assumeTrue("true".contains("u"), () -> "Nope");
    }

    @Test
    @Order(2)
    void test2() {
        assumingThat("Hey".length()==3, () -> {
            assumeTrue("Hey".equals("Hey"));
            System.out.println("da");
        });
    }

    @Test
    @EnabledIf("customCondition")
    @Order(3)
    void test3() {
        System.out.println("This method is enabled");
    }

    @Test
    @DisabledIf("customCondition")
    @Order(4)
    void test4() {
        System.out.println("This method is disabled");
    }
    boolean customCondition() {
        return true;
    }
}
