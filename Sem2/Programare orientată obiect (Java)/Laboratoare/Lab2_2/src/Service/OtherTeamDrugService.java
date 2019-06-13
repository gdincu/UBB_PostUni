package Service;

import Domain.Drug;
import Domain.Transaction;
import Repository.IOtherTeamRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OtherTeamDrugService extends IsSearchable<Drug> {

    private IOtherTeamRepository<Drug> repository;
    private IOtherTeamRepository<Transaction> transactionRepository;

    /**
     * Instantiates a drug service.
     *
     * @param repository the repository used by this service.
     */
    public OtherTeamDrugService(IOtherTeamRepository<Drug> repository, IOtherTeamRepository<Transaction> transactionRepository) {
        this.repository = repository;
        this.transactionRepository = transactionRepository;
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
     *
     * @param id the drug id to be removed
     *           Raises a RuntimeException if the drug name doesn't exist
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
     *
     * @return
     */
    public ArrayList<Drug> getAll() {
        ArrayList<Drug> temp = repository.getAll();
        return temp;
    }

    /**
     * Searches Drugs whose fields contain a given text.
     *
     * @param text the text searched for
     * @return A list of drugs whose fields contain text.
     */
    public List<Drug> fullTextSearch(String text) {
        List<Drug> results = new ArrayList<>();
        for (Drug c : repository.getAll())
            if (c.toString().contains(text))
                results.add(c);
        return results;
    }

    /**
     * Function to increase prices for drugs priced below a minimum price
     *
     * @param MinPrice    the min price to be checked against
     * @param PctIncrease the % increase to be applied
     */
    public void IncreasePrice(int MinPrice, int PctIncrease) {
        for (Drug d : repository.getAll())
            if (d.getPrice() < MinPrice)
                d.setPrice(d.getPrice() * (1 + (PctIncrease / 100)));
    }

    /**
     * Function to sort drugs by sales
     *
     * @return
     */
    public List<Drug> sortDrugsBySales() {
        Comparator<Drug> bySales = (d1, d2) -> {
            int t1 = 0, t2 = 0;
            for (Transaction transaction : transactionRepository.getAll()) {
                if (transaction.getId() == d1.getId())
                    t1 += transaction.getQuantity();
                if (transaction.getDrugId() == d2.getId())
                    t2 += transaction.getQuantity();
            }
            return t2 - t1;
        };
        List<Drug> medicines = new ArrayList<>(repository.getAll());
        medicines.sort(bySales);
        return medicines;
    }

}