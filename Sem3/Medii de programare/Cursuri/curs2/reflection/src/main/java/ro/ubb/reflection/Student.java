package ro.ubb.reflection;

/**
 * Created by radu.
 */
public class Student {
    public String name;
    public int groupNumber;

    public Student() {
    }

    public Student(String name, int groupNumber) {
        this.name = name;
        this.groupNumber = groupNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", groupNumber=" + groupNumber +
                '}';
    }
}
