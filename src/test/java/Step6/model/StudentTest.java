package Step6.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentTest {

    static List<Student> students;

    @BeforeAll
    static void setupStudent() {
        students = List.of(
                new Student((long)1,"Mike"),
                new Student((long)2,"Johny")
        );
    }

    @Test
    void getId() {
        long expected = students.get(0).getId();
        long actual = 1;
        assertEquals(expected, actual);
    }

    @Test
   void getName() {
        String expected = students.get(0).getName();
        String actual = "Mike";
        assertEquals(expected,actual);
    }
}
