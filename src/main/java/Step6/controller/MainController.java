package Step6.controller;

import Step6.model.Student;
import Step6.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getAll() {
        return studentService.getAll();
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable Long id) {
        return studentService.getById(id);
    }

    @PostMapping
    public String addStudent(Student student) {
        studentService.addStudent(student);
        return "Added successfully";
    }

    @DeleteMapping
    public String deleteStudent(@RequestBody Student student) {
        studentService.deleteStudent(student);
        return "Deleted successfully";
    }
}