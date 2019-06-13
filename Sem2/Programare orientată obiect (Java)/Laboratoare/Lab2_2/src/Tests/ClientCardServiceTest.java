package Tests;
import Domain.*;
import Repository.*;
import Service.ClientCardService;
import Service.DrugService;
import Service.TransactionService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClientCardServiceTest {

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
    void addClientCards() {
    ClientCard temp = new ClientCard(1,"1111111111111","S","F","12/12/2012","13/12/2012");
    clientCardService.addClientCard(temp.getId(),temp.getCNP(),temp.getSurname(),temp.getForename(),temp.getDOB(),temp.getRegDate());
    assertEquals(1,clientCardService.fullTextSearch("S").get(0).getId());
    temp.setCNP("2222222222222");
    assertEquals("2222222222222",temp.getCNP());
    temp.setDOB("01/01/2011");
    assertEquals("01/01/2011",temp.getDOB());
    temp.setForename("FF");
    assertEquals("FF",temp.getForename());
    temp.setSurname("CCC");
    assertEquals("CCC",temp.getSurname());
    temp.setId(222);
    assertEquals(222,temp.getId());
    assertEquals(temp.getSearchableFields(),temp.getSearchableFields());
    temp.setRegDate("09/09/2009");
    assertEquals("09/09/2009",temp.getRegDate());
    assertEquals(temp.toString(),temp.toString());
    assertEquals(temp.hashCode(),temp.hashCode());
    assertEquals(true,temp.equals(temp));
    }

    /**
     * Checks whether drugs are removed correctly
     */
    @org.junit.jupiter.api.Test
    void removeClientCards() {
        ClientCard temp = new ClientCard(1,"1111111111111","S","F","12/12/2012","13/12/2012");
        clientCardService.addClientCard(temp.getId(),temp.getCNP(),temp.getSurname(),temp.getForename(),temp.getDOB(),temp.getRegDate());
        clientCardService.removeClientCard(1);
        assertEquals(0,drugService.getAll().size());
    }

    /**
     * Checks whether the full text Search works correctly
     */
    @org.junit.jupiter.api.Test
    void fullTextSearch() {
        ClientCard temp = new ClientCard(1,"1111111111111","S","F","12/12/2012","13/12/2012");
        clientCardService.addClientCard(1,"1111111111111","S","F","12/12/2012","13/12/2012");
        List<ClientCard> temporar = new ArrayList<>();
        temporar.add(temp);
        assertEquals(temporar.get(0),clientCardService.fullTextSearch("S").get(0));
    }

    /**
     * Checks whether getALL returns all results
     */

    void getAll() {
        ClientCard temp1 = new ClientCard(1,"1111111111111","S","F","12/12/2012","13/12/2012");
        ClientCard temp2 = new ClientCard(2,"2222222222222","S","F","12/12/2012","13/12/2012");
        clientCardService.addClientCard(1,"1111111111111","S","F","12/12/2012","13/12/2012");
        clientCardService.addClientCard(2,"2222222222222","S","F","12/12/2012","13/12/2012");

        ArrayList<ClientCard> temp = new ArrayList<>();
        temp.add(temp1);
        temp.add(temp2);

        assertEquals(temp,drugService.getAll());
        assertEquals(1,temp1.getId());
        assertEquals("2222222222222",temp2.getCNP());
        assertEquals(false,temp.isEmpty());
        assertEquals(2,temp.size());
        clientCardService.linii(1);
        clientCardService.linii(0);

    }

}