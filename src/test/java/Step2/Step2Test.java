package Step2;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

public class Step2Test {

    @Test
    @DisplayName("Just show method")
    void show() {
        System.out.println("Showing...");
    }

    @Test
    @DisplayName("Jumping...")
    @Disabled
    static void jump() {
        System.out.println("This method has been disabled");
    }

    @Test
    @EnabledOnOs(OS.LINUX)
    @DisplayName("Run only on Linux")
    void run() {
        System.out.println("Running...");
    }

    @Test
    @EnabledOnJre(JRE.JAVA_16)
    @DisplayName("Run only on Java 16")
    void watch() {
        System.out.println("Watching...");
    }
}
