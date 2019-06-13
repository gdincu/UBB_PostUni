package Repository;

import Domain.*;
import Service.DrugService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InMemoryRepositoryTest {
    IValidator<Transaction> transactionValidator = new TransactionValidator();
    IRepository<Transaction> transactionRepository = new InMemoryRepository<>(transactionValidator);
    IValidator<Drug> drugValidator = new DrugValidator();
    IRepository<Drug> drugRepository = new InMemoryRepository<>(drugValidator);
    DrugService drugService = new DrugService(drugRepository, transactionRepository);
    Drug A = new Drug(1,2,"A","A",true);


    @Test
    void findById() {
        drugRepository.upsert(A);
        assertEquals(true,drugRepository.findById(1).equals(A));
    }

    @Test
    void upsert() {
        drugRepository.upsert(A);
        assertEquals(true,drugRepository.findById(1).equals(A));
    }

    @Test
    void remove() {
        drugRepository.upsert(A);
        drugRepository.remove(1);
        assertEquals(true,drugRepository.getAll().isEmpty());
    }

    @Test
    void getAll() {
        assertEquals(true,drugRepository.getAll().isEmpty());
    }
}