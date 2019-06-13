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

class ClientCardTest {

    IRepository<Drug> drugRepository = new InMemoryRepository<>(new DrugValidator());
    IRepository<ClientCard> clientCardRepository = new InMemoryRepository<>(new ClientCardValidator());
    IRepository<Transaction> transactionRepository = new InMemoryRepository<>(new TransactionValidator());
    DrugService drugService = new DrugService(drugRepository);
    ClientCardService clientCardService = new ClientCardService(clientCardRepository);
    TransactionService transactionService = new TransactionService(transactionRepository,drugRepository,clientCardRepository);

    /**
     * Checks whether the add method works
     */
    @org.junit.jupiter.api.Test
    void addDrugs() {
    Drug temp = new Drug(1,1,"Nume","Prd",true);
    drugService.addDrug(1,1,"Nume","Prd",true);
    assertEquals(true,drugService.getAll().contains(temp));
    }

    /**
     * Checks whether drugs are removed correctly
     */
    @org.junit.jupiter.api.Test
    void removeDrugs() {
        Drug temp = new Drug(1,1,"Nume","Prd",true);
        drugService.addDrug(1,1,"Nume","Prd",true);
        drugService.removeDrug(1);
        assertEquals(0,drugService.getAll().size());
    }

    /**
     * Checks whether the full text Search works correctly
     */
    @org.junit.jupiter.api.Test
    void fullTextSearch() {
        Drug temp1 = new Drug(2,1,"Nume1","Prd1",true);
        List<Drug> temp = new ArrayList<>();
        temp.add(temp1);

        drugService.addDrug(2,1,"Nume1","Prd1",true);

        assertEquals(temp.get(0),drugService.fullTextSearch("Nume1").get(0));
    }

    /**
     * Checks whether getALL returns all results
     */

    void getAll() {
        Drug temp1 = new Drug(1,1,"Nume1","Prd1",true);
        Drug temp2 = new Drug(2,2,"Nume2","Prd2",true);
        drugService.addDrug(1,1,"Nume1","Prd1",true);
        drugService.addDrug(2,2,"Nume2","Prd2",true);

        ArrayList<Drug> temp = new ArrayList<>();
        temp.add(temp1);
        temp.add(temp2);

        assertEquals(temp,drugService.getAll());
    }

}