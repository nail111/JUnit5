package Step6.service;

import Step6.model.Student;
import Step6.repo.StudentRepo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class StudentServiceTest {
    @InjectMocks
    private StudentService studentService;

    @MockBean
    private StudentRepo studentRepo;

    @Autowired
    private static List<Student> students;

    @BeforeAll
    static void setup() {
        students = List.of(
                new Student((long)1,"Mike"),
                new Student((long)2,"Kenny"),
                new Student((long)3,"Johny")
        );
    }

    @Test
    void getAllStudents() {
        when(studentRepo.findAll()).thenReturn(students);
        assertEquals(3,studentService.getAll().size());
        assertNotNull(studentService.getAll());
    }

    @Test
    void getStudentById() {
        long id = 1;
        when(studentRepo.findById(id))
                .thenReturn(Optional.ofNullable(students.stream().filter(i -> i.getId() == id).findAny().orElse(null)));
        assertThat(studentService.getById(id)).isNotNull();
        verify(studentRepo).findById(id);
    }

    @Test
    void addStudent() {
        Student student = students.get(1);
        when(studentRepo.save(student)).thenReturn(student);
        assertThat(studentService.addStudent(student)).isNotNull();
        verify(studentRepo).save(student);
    }

    @Test
    void deleteStudent() {
        Student student = new Student((long)1,"Mike");
        studentService.deleteStudent(student);
        verify(studentRepo,times(1)).delete(student);
    }
}
