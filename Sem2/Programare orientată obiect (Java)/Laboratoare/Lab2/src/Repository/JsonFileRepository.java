package Repository;

import Domain.Entity;
import Domain.IValidator;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class JsonFileRepository<T extends Entity> implements IRepository<T> {

    private String filename;
    private IValidator<T> validator;
    private Map<Integer, T> storage = new HashMap<>();
    private Type type;

    public JsonFileRepository(IValidator<T> validator, String filename, Type type) {
        this.validator = validator;
        this.filename = filename;
        this.type = type;
    }

    private void loadFile() {
        Gson gson = new Gson();
        storage.clear();
        try (BufferedReader in = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = in.readLine()) != null) {
                T entity = gson.fromJson(line, type);
                storage.put(entity.getId(), entity);
            }
        } catch (Exception ex) {

        }
    }

    private void saveFile() {
        Gson gson = new Gson();
        try (BufferedWriter out = new BufferedWriter(new FileWriter(filename))) {
            for (T entity : storage.values()) {
                out.write(gson.toJson(entity));
                out.newLine();
            }
        } catch (Exception ex) {

        }
    }

    @Override
    public T findById(int id) {
        loadFile();
        return storage.get(id);
    }

    @Override
    public void upsert(T entity) {
        loadFile();
        validator.validate(entity);
        storage.put(entity.getId(), entity);
        saveFile();
    }

    @Override
    public void remove(int id) {
        loadFile();
        if (!storage.containsKey(id)) {
            throw new RuntimeException("There is no entity with the given id to remove.");
        }

        storage.remove(id);
        saveFile();
    }

    @Override
    public ArrayList<T> getAll() {
        loadFile();
        return new ArrayList<>(storage.values());
    }
}
