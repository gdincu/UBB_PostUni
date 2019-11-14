package ro.ubb.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by radu.
 */
public class StudentRepository {
    private String url;
    private String user;
    private String password;

    private StudentRepository() {
    }

    public StudentRepository(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        String sql = "select * from student";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Long id = rs.getLong("id");
                String serialNumber = rs.getString("serialnumber");
                String name = rs.getString("name");
                int groupNumber = rs.getInt("groupnumber");

                Student student = new Student(id, serialNumber, name, groupNumber);
                students.add(student);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    void save(Student student) {
        String sql = "insert into student (serialnumber, name, groupnumber) values (?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(url,user,password);
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, student.getSerialNumber());
            ps.setString(2, student.getName());
            ps.setInt(3, student.getGroupNumber());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        Connection connection = null;
//        PreparedStatement ps = null;
//        try {
//            connection = DriverManager.getConnection(url, user, password);
//            ps = connection.prepareStatement("insert into student (serialnumber, name, groupnumber) values (?, ?, ?)");
//            ps.setString(1, student.getSerialNumber());
//            ps.setString(2, student.getName());
//            ps.setInt(3, student.getGroupNumber());
//
//            ps.executeUpdate();
//
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        finally {
//            try {
//                ps.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//            try {
//                connection.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }

    }

    void update(Long id, Student student) {
        String sql = "update student set serialnumber=?, name=?, groupnumber=? where id=?";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, student.getSerialNumber());
            ps.setString(2, student.getName());
            ps.setInt(3, student.getGroupNumber());
            ps.setLong(4, id);

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void delete(Long id) {
        String sql = "delete from student where id=?";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setLong(1, id);

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
