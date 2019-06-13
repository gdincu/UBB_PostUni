package Service;
import Domain.Drug;
import Repository.IRepository;
import java.util.*;

public class DrugService extends IsSearchable<Drug> {

    private IRepository<Drug> repository;

    /**
     * Instantiates a drug service.
     *
     * @param repository the repository used by this service.
     */
    public DrugService(IRepository<Drug> repository) {
        this.repository = repository;
    }

    /**
     * Adds a drug to the repository
     *
     * @param id            the drug id
     * @param price         the price for the drug
     * @param name          the name of the drug
     * @param producer      the producer name
     * @param receiptNeeded checks whether a receipt is needed
     *                      Raises RuntimeException if the drug name is already taken.
     */
    public void addDrug(int id, int price, String name, String producer, boolean receiptNeeded) {

        for (Drug c : repository.getAll()) {
            if (c.getName() == name) {
                throw new RuntimeException("This drug already exists!");
            }
        }
        Drug drug = new Drug(id, price, name, producer, receiptNeeded);
        repository.upsert(drug);
    }

    /**
     * Removes a drug from the repository
     * @param id the drug id to be removed
     * Raises a RuntimeException if the drug name doesn't exist
     */
    public void removeDrug(int id) {

        for (Drug c : repository.getAll())
            if (c.getId() == id) {
                repository.remove(id);
                return;
            }
            throw new RuntimeException("There is no drug for the given id!");
    }

    /**
     * Returns all records
     * @return
     */
    public ArrayList<Drug> getAll() {
        ArrayList<Drug> temp = repository.getAll();
        return temp;
    }

    /**
     * Searches Drugs whose fields contain a given text.
     * @param text the text searched for
     * @return A list of drugs whose fields contain text.
     */
    public List<Drug> fullTextSearch(String text) {
        List<Drug> results = new ArrayList<>();
        for (Drug c : repository.getAll()) {
            // Might return false positives
            if (c.toString().contains(text))
                results.add(c);
//            if (c.getFirstName().contains(text) ||
//                c.getLastName().contains(text) || ... )
        }
        return results;
    }



}