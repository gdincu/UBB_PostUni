package ro.ntt.catalog.ui;

import ro.ntt.catalog.model.Student;
import ro.ntt.catalog.service.StudentService;

import java.util.Scanner;
import java.util.Set;

/**
 * Created by radu.
 */
public class Console {
    private StudentService studentService;

    public Console(StudentService studentService) {
        this.studentService = studentService;
    }

    public void runMenu() {
        printMenu();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String option = scanner.next();
            if (option.equals("x")) {
                break;
            }
            switch (option) {
                case "1":
                    addStudent();
                    break;
                case "2":
                    printStudents();
                    break;
                default:
                    System.out.println("this option is not yet implemented");
            }
            printMenu();
        }
    }

    private void printStudents() {
        System.out.println("All students: \n");
        Set<Student> students = studentService.getAllStudents();
        students.forEach(System.out::println);
    }

    private void addStudent() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("id = ");
        Long id = scanner.nextLong();

        System.out.println("serial number = ");
        String serialNumber = scanner.next();

        System.out.println("name = ");
        String name = scanner.next();

        System.out.println("group number = ");
        int groupNumber = scanner.nextInt();

        Student student = new Student(id, serialNumber, name, groupNumber);
        studentService.addStudent(student);
    }

    private void printMenu() {
        System.out.println("1 - Add Student\n" +
                "2 - Print all students\n" +
                "x - Exit");
    }
}
