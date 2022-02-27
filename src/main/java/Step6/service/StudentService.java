package Step6.service;

import Step6.model.Student;
import Step6.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;

    public List<Student> getAll() {
        return studentRepo.findAll();
    }

    public Student getById(Long id) {
        return studentRepo.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public Student addStudent(Student student) {
        if (!checkIfExists(student)) {
           return studentRepo.save(student);
        }
        throw new IllegalAccessError("User is already exists");
    }

    public boolean checkIfExists(Student student) {
        return getAll().contains(student);
    }

    public void deleteStudent(Student student) {
        studentRepo.delete(student);
    }
}
