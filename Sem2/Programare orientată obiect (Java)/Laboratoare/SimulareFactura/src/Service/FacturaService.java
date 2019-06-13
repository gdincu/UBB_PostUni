package Service;
import Domain.Factura;
import Repository.IRepository;
import java.util.*;

public class FacturaService extends IsSearchable<Factura> {

    private IRepository<Factura> repository;

    /**
     * Instantiates a Factura service
     * @param repository
     */
    public FacturaService(IRepository<Factura> repository) {
        this.repository = repository;
    }

    /**
     * Adds a receipt to the repository
     * @param id
     * @param price
     * @param description
     * @param date
     */
    public void addReceipt(int id,double price, String description, String date) {

        for (Factura c : repository.getAll())
            if (c.getId() == id)
                throw new ServiceException("A receipt with the same ID already exists!");

        repository.upsert(new Factura(id,price,description,date));
    }

    /**
     * Removes a receipt from the repository
     * @param id
     */
    public void removeReceipt(int id) {

        for (Factura c : repository.getAll())
            if (c.getId() == id) {
                repository.remove(id);
                return;
            }
        throw new ServiceException("There is no receipt for the given ID!");
    }

    /**
     * Returns a list of all receipts
     * @return
     */
    public List<Factura> getAll(){
        return repository.getAll();
    }

    /**
     * Searches receipts whose fields contain a given text.
     * @param text the text searched for
     * @return A list of clients whose fields contain text.
     */
    public List<Factura> fullTextSearch(String text) {
        List<Factura> results = new ArrayList<>();
        for (Factura c : repository.getAll())
            if (c.toString().contains(text))
                results.add(c);
        return results;
    }
}