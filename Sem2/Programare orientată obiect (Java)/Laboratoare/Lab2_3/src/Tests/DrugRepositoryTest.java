package Tests;

import Domain.Drug;
import Domain.DrugValidator;
import Repository.*;

import static org.junit.jupiter.api.Assertions.*;

class DrugRepositoryTest {

    @org.junit.jupiter.api.Test
    void findByIdWithExistingIdShouldReturnCorrectDrug() {

        IRepository<Drug> repo = new InMemoryRepository<>(new DrugValidator());
        Drug added = new Drug(1, 1, "test", "Test",false);
        repo.upsert(added);
        Drug found = repo.findById(1);
        assertNotNull(found, "Returned null for existing id!");
        assertEquals(1, found.getId(), String.format("Returned id %s instead of correct id=1!", found.getId()));
        assertEquals("test", found.getName(), String.format("Returned name=%s instead of %s", found.getName(), added.getName()));
        // ... so on
    }

    @org.junit.jupiter.api.Test
    void upsert() {
    }

    @org.junit.jupiter.api.Test
    void remove() {
    }

    @org.junit.jupiter.api.Test
    void getAll() {
    }


}
