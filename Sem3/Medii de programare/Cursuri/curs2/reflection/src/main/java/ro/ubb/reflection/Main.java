package ro.ubb.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by radu.
 * <p>
 * * 1.
 * * - create a new "ro.ubb.reflection.Student" instance (reflection).
 * * - initialize the student's private attributes ("name", "groupNumber") with the values ("john", 123).
 * * - print the student instance.
 * * <p>
 * * 2.
 * * - create a new "ro.ubb.reflection.Student" instance (reflection)
 * * - invoke setName("john") and setGroupNumber(123)
 * * - print the student instance.
 * * <p>
 * * 3.
 * * - create a new "ro.ubb.reflection.Student" instance ("john",123) by invoking the constructor
 * * - print the student instance.
 * * <p>
 * * 4.
 * * - create a new "ro.ubb.reflection.Employee". ("ro.ubb.reflection.e04.Employee" extends "ro.ubb.reflection.Person", Person has a
 * * name, Employee has a salary) (reflection)
 * * - set the "name" to "Mary" and the "salary" to 1000;
 * * - print the employee
 * * <p>
 * * 5.
 * * - given a Student instance ("John",123), print all attribute names, types, and values.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("hello");


        try {
         problem1();
            problem2();
            problem3();
                problem4();
            problem5();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    //* * - given a Student instance ("John",123),
    // print all attribute names, types, and values.
    private static void problem5() throws Exception {
        Class studentClass = Class.forName("ro.ubb.reflection.Student");
        Constructor constructor = studentClass.getDeclaredConstructor(String.class, int.class);

        Student student = (Student) constructor.newInstance("John", 123);
        System.out.println(student);


        Field[] studentFields = studentClass.getDeclaredFields();
        for (Field field : studentFields) {
            System.out.println("Field name: " + field.getName());
            System.out.println("Field type: " + field.getType());
            System.out.println("Field value: " + field.get(student) + "\n");
        }


    }

    private static void problem4() throws Exception {
        Class employeeClass = Class.forName("ro.ubb.reflection.Employee");
        Employee employee = (Employee) employeeClass.newInstance();

        Field employeeSalaryField = employeeClass.getDeclaredField("salary");
        employeeSalaryField.setAccessible(true);
        employeeSalaryField.setInt(employee, 1000);

        Field employeeNameField = employeeClass.getSuperclass().getDeclaredField("name");
        employeeNameField.setAccessible(true);
        employeeNameField.set(employee, "Mary");

        System.out.println(employee);
    }

    private static void problem3() throws Exception {
        Class studentClass = Class.forName("ro.ubb.reflection.Student");
        Constructor constructor = studentClass.getDeclaredConstructor(String.class, int.class);

        Student student = (Student) constructor.newInstance("John", 123);
        System.out.println(student);
    }

    private static void problem2() throws Exception {
        Class studentClass = Class.forName("ro.ubb.reflection.Student");
        Student student = (Student) studentClass.newInstance();

        Method studentSetNameMethod = studentClass.getDeclaredMethod("setName", String.class);
        studentSetNameMethod.invoke(student, "John");

        Method studentSetGroupNumberMethod = studentClass.getDeclaredMethod("setGroupNumber", int.class);
        studentSetGroupNumberMethod.invoke(student, 123);

        System.out.println(student);
    }

    private static void problem1() {
        try {
            Class studentClass = Class.forName("ro.ubb.reflection.Student");
            Student student = (Student) studentClass.newInstance();

            Field studentNameField = studentClass.getDeclaredField("name");
            //studentNameField.setAccessible(true);
            studentNameField.set(student, "John");

            Field studentGroupNumberField = studentClass.getDeclaredField("groupNumber");
            //studentGroupNumberField.setAccessible(true);
            studentGroupNumberField.setInt(student, 123);

            System.out.println(student);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
