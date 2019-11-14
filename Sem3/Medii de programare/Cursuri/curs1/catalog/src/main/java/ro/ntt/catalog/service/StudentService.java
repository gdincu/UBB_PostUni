package ro.ntt.catalog.service;

import ro.ntt.catalog.model.Student;
import ro.ntt.catalog.repository.StudentRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by radu.
 */
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public Set<Student> getAllStudents() {
        Set<Student> students = new HashSet<>();
        studentRepository.findAll().forEach(students::add);
        return students;
    }
}
