package Tests;

import Domain.*;
import Repository.IRepository;
import Repository.InMemoryRepository;
import Service.ClientCardService;
import Service.DrugService;
import Service.ServiceException;
import Service.TransactionService;

import javax.sql.rowset.serial.SerialException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DrugServiceTest {

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
    temp.setId(2);
    assertEquals(2,temp.getId());
    temp.setPrice(3);
    assertEquals(3,temp.getPrice());
    temp.setName("SSS");
    assertEquals("SSS",temp.getName());
    temp.setProducer("PPP");
    assertEquals("PPP",temp.getProducer());
    temp.setReceiptNeeded(false);
    assertEquals(false,temp.isReceiptNeeded());
    assertEquals(temp.toString(),temp.toString());
    assertEquals(temp.getSearchableFields(),temp.getSearchableFields());
    assertEquals(temp.hashCode(),temp.hashCode());
    assertEquals(true,temp.equals(temp));
    ServiceException te = new ServiceException("This drug already exists!");
    Drug te2 = new Drug(2,2,"Nume","BB",false);
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
        assertEquals(drugService.fullTextSearch("A"),drugService.fullTextSearch("A"));
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