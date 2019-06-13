package Service;

import Domain.*;
import Repository.IRepository;
import Repository.InMemoryRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DrugServiceTest {
    IValidator<Transaction> transactionValidator = new TransactionValidator();
    IRepository<Transaction> transactionRepository = new InMemoryRepository<>(transactionValidator);
    IValidator<Drug> drugValidator = new DrugValidator();
    IRepository<Drug> drugRepository = new InMemoryRepository<>(drugValidator);
    DrugService drugService = new DrugService(drugRepository, transactionRepository);
    Drug A = new Drug(1,2,"A","A",true);

    @Test
    void addDrug() {
        drugService.addDrug(A.getId(),A.getPrice(),A.getName(),A.getProducer(),A.isReceiptNeeded());
        assertEquals(false,drugService.getAll().isEmpty());
    }

    @Test
    void removeDrug() {
        drugService.addDrug(A.getId(),A.getPrice(),A.getName(),A.getProducer(),A.isReceiptNeeded());
        drugService.removeDrug(1);
        assertEquals(true,drugService.getAll().isEmpty());
    }

    @Test
    void getAll() {
        assertEquals(true,drugService.getAll().isEmpty());
    }

    @Test
    void fullTextSearch() {
        assertEquals(true,drugService.fullTextSearch("A").isEmpty());
    }
}