package Service;
import Domain.ClientCard;
import Repository.IRepository;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

public class ClientCardService  extends IsSearchable<ClientCard> {

    private IRepository<ClientCard> repository;

    /**
     * Instantiates a drug service.
     *
     * @param repository the repository used by this service.
     */
    public ClientCardService(IRepository<ClientCard> repository) {
        this.repository = repository;
    }

    /**
     * Adds a client card to the repository
     * @param id
     * @param CNP
     * @param surname
     * @param forename
     * @param DOB
     * @param regDate
     * Raises RuntimeException if the drug name is already taken.
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
     * @param id
     * Raises a RuntimeException if te client card id doesn't exist
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
     * @return
     */
    public List<ClientCard> getAll(){
        return repository.getAll();
    }

    /**
     * Searches clients whose fields contain a given text.
     * @param text the text searched for
     * @return A list of clients whose fields contain text.
     */
    public List<ClientCard> fullTextSearch(String text) {
        List<ClientCard> results = new ArrayList<>();
        for (ClientCard c : repository.getAll()) {
            // Might return false positives
            if (c.toString().contains(text))
                results.add(c);
//            if (c.getFirstName().contains(text) ||
//                c.getLastName().contains(text) || ... )
        }

        return results;
    }


}