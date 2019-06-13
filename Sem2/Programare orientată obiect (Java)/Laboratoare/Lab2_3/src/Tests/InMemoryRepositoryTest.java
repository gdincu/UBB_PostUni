package Tests;

import Domain.*;
import Repository.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryRepositoryTest {

    /**
     * Checks whether findByIdWithExistingId returns the correct drug
     */
    @org.junit.jupiter.api.Test
    void findByIdDrugs() {
        IRepository<Drug> repo = new InMemoryRepository<>(new DrugValidator());
        Drug added = new Drug(1, 1, "Test", "Test",false);
        repo.upsert(added);
        Drug found = repo.findById(1);
        assertNotNull(found, "Returned null for existing id!");
        assertEquals(1, found.getId(), String.format("Returned id %s instead of correct id=1!", found.getId()));
        assertEquals("Test", found.getName(), String.format("Returned name=%s instead of %s", found.getName(), added.getName()));
    }

    /**
     * Checks whether findByIdWithExistingId returns the correct transaction
     */
    @org.junit.jupiter.api.Test
    void findByIdTransactions() {
        IRepository<Transaction> repoT = new InMemoryRepository<>(new TransactionValidator());
        Transaction added = new Transaction(1,100,101,22,10,156,"22/12/2012","22:21");
        repoT.upsert(added);
        Transaction found = repoT.findById(1);
        assertNotNull(found, "Returned null for existing id!");
        assertEquals(1, found.getId(), String.format("Returned id %s instead of correct id=1!", found.getId()));
        assertEquals("22/12/2012", found.getDate());
    }

    /**
     * Checks whether findByIdWithExistingId returns the correct client card
     */
    @org.junit.jupiter.api.Test
    void findByIdClientCard() {
        IRepository<ClientCard> repoT = new InMemoryRepository<>(new ClientCardValidator());
        ClientCard added = new ClientCard(1,"1920223111111","DD","AA","12/12/2012","13/12/2012");
        repoT.upsert(added);
        ClientCard found = repoT.findById(1);
        assertNotNull(found, "Returned null for existing id!");
        assertEquals(1, found.getId(), String.format("Returned id %s instead of correct id=1!", found.getId()));
        assertEquals("12/12/2012", found.getDOB());
    }

    /**
     * Checks whether upsert adds drugs correctly
     */
    @org.junit.jupiter.api.Test
    void upsertDrugs() {
        IRepository<Drug> repo = new InMemoryRepository<>(new DrugValidator());
        Drug temp = new Drug(1, 1, "Test", "Test",false);
        repo.upsert(temp);
        ArrayList<Drug> temps = repo.getAll();
        assertEquals(1,temps.size());
        assertEquals(temp,temps.get(0));
    }

    /**
     * Checks whether upsert adds client cards correctly
     */
    @org.junit.jupiter.api.Test
    void upsertClientCards() {
        IRepository<ClientCard> repo = new InMemoryRepository<>(new ClientCardValidator());
        ClientCard temp = new ClientCard(1,"1111111111111","DD","AA","12/12/2012","13/12/2012");
        repo.upsert(temp);
        ArrayList<ClientCard> temps = repo.getAll();
        assertEquals(1,temps.size());
        assertEquals(temp,temps.get(0));
    }

    /**
     * Checks whether upsert adds transactions correctly
     */
    @org.junit.jupiter.api.Test
    void upsertTransactions() {
        IRepository<Transaction> repo = new InMemoryRepository<>(new TransactionValidator());
        Transaction temp = new Transaction(1,2,3,4,5,6,"12/12/2012","22:21");
        repo.upsert(temp);
        ArrayList<Transaction> temps = repo.getAll();
        assertEquals(1,temps.size());
        assertEquals(temp,temps.get(0));
    }

    /**
     * Checks whether remove deletes the correct element
     */
    @org.junit.jupiter.api.Test
    void removeDrugs() {
        IRepository<Drug> repo = new InMemoryRepository<>(new DrugValidator());
        Drug temp = new Drug(1, 1, "Test", "Test",false);
        Drug temp2 = new Drug(2, 2, "Test2", "Test2",false);
        repo.upsert(temp); repo.upsert(temp2);
        repo.remove(1);
        ArrayList<Drug> temps = repo.getAll();
        assertEquals(temp2,temps.get(0));
        assertThrows(RuntimeException.class, () -> {
            repo.remove(12);
        });
    }

    @org.junit.jupiter.api.Test
    void getAllDrugs() {
        IRepository<Drug> repo = new InMemoryRepository<>(new DrugValidator());
        Drug temp = new Drug(1, 1, "Test", "Test",false);
        Drug temp2 = new Drug(2, 2, "Test2", "Test2",false);
        repo.upsert(temp); repo.upsert(temp2);
        ArrayList<Drug> temps = repo.getAll();
        assertEquals(2,temps.size());
        assertEquals(temps.get(0),temp);
        assertEquals(temps.get(1),temp2);
    }


}
