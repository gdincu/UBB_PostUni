package Service;

import Domain.*;
import Repository.IRepository;
import Repository.InMemoryRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientCardServiceTest {
    IValidator<Transaction> transactionValidator = new TransactionValidator();
    IRepository<Transaction> transactionRepository = new InMemoryRepository<>(transactionValidator);
    IValidator<ClientCard> clientCardValidator = new ClientCardValidator();
    IRepository<ClientCard> clientCardRepository = new InMemoryRepository<>(clientCardValidator);
    ClientCardService clientCardService = new ClientCardService(clientCardRepository, transactionRepository);
    ClientCard A = new ClientCard(1,"9999999999999","A","A","12/12/2012","23/12/2012");

    @Test
    void addClientCard() {
        clientCardService.addClientCard(A.getId(),A.getCNP(),A.getSurname(),A.getForename(),A.getDOB(),A.getRegDate());
        assertEquals(false,clientCardService.getAll().isEmpty());
    }

    @Test
    void removeClientCard() {
        assertEquals(true,clientCardService.getAll().isEmpty());
    }

    @Test
    void getAll() {
        assertEquals(true,clientCardService.getAll().isEmpty());
    }

    @Test
    void fullTextSearch() {
        assertEquals(true,clientCardService.fullTextSearch("A").isEmpty());
    }
}