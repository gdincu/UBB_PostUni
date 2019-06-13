package Repository;

import Domain.Entity;

import java.util.ArrayList;

public interface IOtherTeamRepository<T extends Entity> {

    T findById(int id);

    void upsert(T drug);

    void remove(int id);

    ArrayList<T> getAll();
}