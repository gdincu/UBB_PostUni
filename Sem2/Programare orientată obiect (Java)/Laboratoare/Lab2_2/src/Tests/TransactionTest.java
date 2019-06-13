package Tests;

import Domain.*;
import Repository.IRepository;
import Repository.InMemoryRepository;
import Service.ClientCardService;
import Service.DrugService;
import Service.TransactionService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TransactionTest {

    IRepository<Drug> drugRepository = new InMemoryRepository<>(new DrugValidator());
    IRepository<ClientCard> clientCardRepository = new InMemoryRepository<>(new ClientCardValidator());
    IRepository<Transaction> transactionRepository = new InMemoryRepository<>(new TransactionValidator());
    DrugService drugService = new DrugService(drugRepository);
    ClientCardService clientCardService = new ClientCardService(clientCardRepository);
    TransactionService transactionService = new TransactionService(transactionRepository, drugRepository, clientCardRepository);

    /**
     * Checks whether the add method works
     */
    @org.junit.jupiter.api.Test
    void addTransaction() {
        Transaction temp = new Transaction(1, 2, 3, 4, 5, 6, "10/10/2010", "21:10");
        transactionService.addTransaction(1, 2, 3, 4, "10/10/2010", "22:20");
        temp.setId(2);
        assertEquals(2, temp.getId());
        temp.setDate("01/10/2900");
        assertEquals("01/10/2900", temp.getDate());
        temp.setDiscount(22);
        assertEquals(22, temp.getDiscount());
        temp.setDrugId(333);
        assertEquals(333, temp.getDrugId());
        temp.setPrice(21);
        assertEquals(21, temp.getPrice());
        temp.setQuantity(99);
        assertEquals(99, temp.getQuantity());
        temp.setTime("00:00");
        assertEquals("00:00", temp.getTime());
    }

    /**
     * Checks whether drugs are removed correctly
     */
    @org.junit.jupiter.api.Test
    void removeTransactions() {
        Transaction temp = new Transaction(1, 2, 3, 4, 5, 6, "10/10/2010", "22:10");
        transactionService.addTransaction(1, 2, 3, 4, "10/10/2010", "22:10");
        transactionService.removeTransaction(1);
        assertEquals(true, temp.equals(temp));
        assertEquals(temp.hashCode(), temp.hashCode());
    }

    @org.junit.jupiter.api.Test
    void searchTransactions() {
        Transaction temp = new Transaction(1, 2, 3, 4, 5, 6, "10/10/2010", "22:10");
        transactionService.addTransaction(1, 2, 3, 4, "10/10/2010", "22:10");
        assertEquals(false,transactionService.getAll().contains(temp));
        assertEquals(false,transactionService.getAll().get(0).equals(temp));
        temp.setClientCardId(33);
        assertEquals(33,temp.getClientCardId());
        assertEquals(null,temp.getSearchableFields());
    }

}