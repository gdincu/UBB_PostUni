package Service;

import Domain.Entity;
import Repository.IRepository;

public abstract class UndoRedo<T extends Entity> {
    protected IRepository<T> repository;

    public UndoRedo(IRepository<T> repository) {
        this.repository = repository;
    }

    public abstract void doUndo();
    public abstract void doRedo();

}
