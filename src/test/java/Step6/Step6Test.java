package Step6;

import Step6.model.Student;
import Step6.repo.StudentRepo;
import Step6.service.StudentService;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import static org.mockito.Mockito.when;

@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class Step6Test {
    // --------------------------------------
    @Test
    @Order(2)
    void test1() {
        System.out.println("test1");
    }

    @Test
    @Order(1)
    void test2() {
        System.out.println("test2");
    }
    // --------------------------------------

    @Autowired
    private StudentService studentService;
    @MockBean
    private StudentRepo studentRepo;

    @Test
    public void getUserTest_v1() {
        when(studentRepo.findAll()).thenReturn(
                Stream.of(
                        new Student((long)1,"Mike")
                ).collect(Collectors.toList())
        );
        assertEquals(7,studentService.getAll().size());
    }

    @Test
    public void getUserTest_v2() {
      when(studentRepo.findAll()).thenReturn(
              Stream.of(
                      new Student((long)1,"Mike")
              ).collect(Collectors.toList())
      );
      assertEquals(1,studentService.getAll().size());
    }
}
