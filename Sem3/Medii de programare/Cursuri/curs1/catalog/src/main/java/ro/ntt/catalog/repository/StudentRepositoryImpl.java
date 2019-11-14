package ro.ntt.catalog.repository;

import ro.ntt.catalog.model.Student;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by radu.
 */
public class StudentRepositoryImpl implements StudentRepository {
    private Map<Long, Student> entities;


    public StudentRepositoryImpl() {
        this.entities = new HashMap<>();
    }

    @Override
    public Student findOne(Long id) {
        throw new RuntimeException("not yet implemented");
    }

    @Override
    public Iterable<Student> findAll() {
        Set<Student> students = entities.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toSet());
        return students;
    }

    @Override
    public Student save(Student entity) {
        if (entity == null) {
            throw new IllegalArgumentException("entity must not be null");
        }
        return entities.putIfAbsent(entity.getId(), entity);
    }

    @Override
    public Student delete(Long id) {
        throw new RuntimeException("not yet implemented");
    }

    @Override
    public Student update(Student entity) {
        throw new RuntimeException("not yet implemented");
    }
}
