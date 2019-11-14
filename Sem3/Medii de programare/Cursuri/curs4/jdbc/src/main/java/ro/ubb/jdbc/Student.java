package ro.ubb.jdbc;

/**
 * Created by radu.
 */
public class Student {
    private Long id;
    private String serialNumber;
    private String name;
    private int groupNumber;

    public Student() {
    }

    public Student(Long id, String serialNumber, String name, int groupNumber) {
//        this(serialNumber,name,groupNumber);
        this.id = id;
        this.serialNumber = serialNumber;
        this.name = name;
        this.groupNumber = groupNumber;
    }

    public Student(String serialNumber, String name, int groupNumber) {
//        this.serialNumber = serialNumber;
//        this.name = name;
//        this.groupNumber = groupNumber;
        this(null,serialNumber,name,groupNumber);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
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
                "id=" + id +
                ", serialNumber='" + serialNumber + '\'' +
                ", name='" + name + '\'' +
                ", groupNumber=" + groupNumber +
                '}';
    }
}
