package Repository;

import Domain.Entity;
import Service.ServiceException;

import java.util.ArrayList;

public class OtherTeamRepositoryAdapter<T extends Entity> implements IOtherTeamRepository<T> {

    private IRepository<T> adaptee;

    public OtherTeamRepositoryAdapter(IRepository<T> adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public T findById(int id) {
        return adaptee.findById(id);
    }

    @Override
    public void upsert(T drug) {
        if (findById(drug.getId()) != null)
            throw new ServiceException("The given id already exists!");

        if (findById(drug.getId()) == null)
            throw new ServiceException("The given id doesn't exists!");
        adaptee.upsert(drug);
    }

    @Override
    public void remove(int id) {
        adaptee.remove(id);
    }

    @Override
    public ArrayList<T> getAll() {
        return null;
    }
}
