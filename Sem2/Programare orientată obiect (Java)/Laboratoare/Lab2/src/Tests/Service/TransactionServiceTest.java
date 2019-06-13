package Service;

import Domain.IValidator;
import Domain.Transaction;
import Domain.ClientCard;
import Domain.Drug;
import Domain.TransactionValidator;
import Repository.IRepository;
import Repository.InMemoryRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransactionServiceTest {

    private IRepository<Drug> drugRepository;
    private IRepository<ClientCard> clientCardRepository;
    IValidator<Transaction> transactionValidator = new TransactionValidator();
    IRepository<Transaction> transactionRepository = new InMemoryRepository<>(transactionValidator);
    TransactionService transactionService = new TransactionService(transactionRepository,drugRepository,clientCardRepository);


    @Test
    void addTransaction() {
    }

    @Test
    void discountAndPrice() {
    }

    @Test
    void removeTransaction() {
    }

    @Test
    void getAll() {
    }

    @Test
    void sortedDrugBySales() {
    }

    @Test
    void sortClientCardsByDisccount() {
    }
}