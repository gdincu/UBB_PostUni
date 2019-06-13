package Service;

import Domain.ClientCard;
import Domain.Transaction;
import Repository.IOtherTeamRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OtherTeamClientCardService extends IsSearchable<ClientCard> {

    private IOtherTeamRepository<ClientCard> repository;
    private IOtherTeamRepository<Transaction> transactionRepository;

    /**
     * Instantiates a drug service.
     *
     * @param repository the repository used by this service.
     */
    public OtherTeamClientCardService(IOtherTeamRepository<ClientCard> repository, IOtherTeamRepository<Transaction> transactionRepository) {
        this.repository = repository;
        this.transactionRepository = transactionRepository;
    }

    /**
     * Adds a client card to the repository
     *
     * @param id
     * @param CNP
     * @param surname
     * @param forename
     * @param DOB
     * @param regDate  Raises RuntimeException if the drug name is already taken.
     */
    public void addClientCard(int id, String CNP, String surname, String forename, String DOB, String regDate) {

        for (ClientCard c : repository.getAll())
            if (c.getCNP().equals(CNP))
                throw new ServiceException("A client with the same CNP already exists!");

        ClientCard client = new ClientCard(id, CNP, surname, forename, DOB, regDate);
        repository.upsert(client);
    }

    /**
     * Removes a client card from the repository
     *
     * @param id Raises a RuntimeException if te client card id doesn't exist
     */
    public void removeClientCard(int id) {

        for (ClientCard c : repository.getAll())
            if (c.getId() == id) {
                repository.remove(id);
                return;
            }
        throw new ServiceException("There is no client card for the given id!");
    }

    /**
     * Returns a list of all client cards
     *
     * @return
     */
    public List<ClientCard> getAll() {
        return repository.getAll();
    }

    /**
     * Searches clients whose fields contain a given text.
     *
     * @param text the text searched for
     * @return A list of clients whose fields contain text.
     */
    public List<ClientCard> fullTextSearch(String text) {
        List<ClientCard> results = new ArrayList<>();
        for (ClientCard c : repository.getAll())
            if (c.toString().contains(text))
                results.add(c);
        return results;
    }

    /**
     * Function to sort Clients by Discounts
     *
     * @return
     */
    public List<ClientCard> sortClientsByDiscounts() {
        Comparator<ClientCard> byDiscount = (d1, d2) -> {
            int t1 = 0, t2 = 0;
            for (Transaction transaction : transactionRepository.getAll()) {
                if (transaction.getId() == d1.getId())
                    t1 += transaction.getDiscount();
                if (transaction.getDrugId() == d2.getId())
                    t2 += transaction.getDiscount();
            }
            return t2 - t1;
        };
        List<ClientCard> clients = new ArrayList<>(repository.getAll());
        clients.sort(byDiscount);
        return clients;
    }

}