package ro.ubb.jdbc;
import java.util.List;

/**
 * Created by radu.
 */
public class Main {
    private static final String URL = "jdbc:postgresql://localhost:5432/catalog";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Craiova1";

    public static void main(String[] args) {

        StudentRepository studentRepository = new StudentRepository(URL,USER,PASSWORD);

        //Creaza
        /*
        Student student = new Student("sn1", "n1", 12);
        studentRepository.save(student);
        */

        //Select

        List<Student> all = studentRepository.findAll();
        all.forEach(System.out::println);


        //Update
        /*
        Student update = new Student("sn-u", "n-u", 199);
        System.out.println("update:  " + all.get(0));
        studentRepository.update(all.get(0).getId(), update);
         */

        //Delete + Count distinct
        /*
        System.out.println("delete: " + all.get(0));
        System.out.println("count: " + all.size());
        studentRepository.delete(all.get(0).getId());
        */
    }
}