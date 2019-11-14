package ro.ntt.catalog;

import ro.ntt.catalog.repository.StudentRepository;
import ro.ntt.catalog.repository.StudentRepositoryImpl;
import ro.ntt.catalog.service.StudentService;
import ro.ntt.catalog.ui.Console;

/**
 * Created by radu.
 */
public class Main {
    public static void main(String[] args) {

        StudentRepository studentRepository=new StudentRepositoryImpl();
        StudentService studentService=new StudentService(studentRepository);
        Console console=new Console(studentService);

        console.runMenu();

        System.out.println("bye");
    }
}
