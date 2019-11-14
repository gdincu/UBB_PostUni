package ro.ubb.reflection;

/**
 * Created by radu.
 */
public class Employee extends Person {

    private int salary;

    @Override
    public String toString() {
        return "Employee{" +
                "salary=" + salary +
                "} " + super.toString();
    }
}
