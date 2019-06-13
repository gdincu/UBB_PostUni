package Service;

import Domain.Entity;
import Repository.IRepository;

public class UpdateOperation <T extends Entity> extends UndoRedo<T> {

    private T addedEntity;
    private T previousEntity;

    public UpdateOperation(IRepository<T> repository, T addedEntity, T previousEntity) {
        super(repository);
        this.addedEntity = addedEntity;
        this.previousEntity = previousEntity;
    }

    @Override
    public void doUndo() {

        repository.remove(addedEntity.getId());
        repository.upsert(previousEntity);
    }

    @Override
    public void doRedo() {
        repository.remove(previousEntity.getId());
        repository.upsert(addedEntity);
    }
}
