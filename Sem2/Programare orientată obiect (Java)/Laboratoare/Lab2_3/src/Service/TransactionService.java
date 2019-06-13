package Service;
import Domain.*;
import Repository.*;
import java.util.*;

public class TransactionService {

    private IRepository<Transaction> repository;
    private  IRepository<Drug> drugRepository;
    private  IRepository<ClientCard> clientCardRepository;

    /**
     * Instantiates a transaction service.
     * @param repository
     * @param drugRepository
     * @param clientCardRepository
     */
    public TransactionService(IRepository<Transaction> repository, IRepository<Drug> drugRepository, IRepository<ClientCard> clientCardRepository) {
        this.repository = repository;
        this.drugRepository = drugRepository;
        this.clientCardRepository = clientCardRepository;
    }

    /**
     * Adds a transactopm to the repository
     * @param id
     * @param drugId
     * @param clientCardId
     * @param quantity
     * @param transactionDate
     * Raises RuntimeException if the ID is already taken.
     */
    public void addTransaction(int id, int drugId, int clientCardId, int quantity, String transactionDate, String transactionTime) {

        for (Transaction c : repository.getAll())
            if (c.getId() == id)
                throw new RuntimeException("This transaction already exists!");

            int[] res = discountAndPrice(clientCardId,drugId,quantity);

        repository.upsert(new Transaction(id, drugId, clientCardId, quantity, res[0], res[1], transactionDate, transactionTime));
    }

    /**
     * Function to return the price value.
     * @param clientCardId
     * @param drugId
     * @param quantity
     */
    public int[] discountAndPrice(int clientCardId, int drugId,int quantity) {

        int[] n={0,0};

        for (ClientCard c : clientCardRepository.getAll())
            if (c.getId() == clientCardId) {
                n[0] = 1;
                break;
            }

        for (Drug c : drugRepository.getAll()) {
            if (c.getId() == drugId && c.isReceiptNeeded()) {
                n[0] *= 15;
                n[1] =(int) (c.getPrice() * quantity * 0.85);
                return n;
            }

            if (c.getId() == drugId && !c.isReceiptNeeded()) {
                n[0] *= 10;
                n[1] =(int) (c.getPrice() * quantity * 0.9);
                return n;
            }
        }

        return n;
    }


    /**
     * Removes a transaction from the repository.
     * @param ID
     * Raises a RuntimeException if the transaction ID doesn't exist.
     */
    public void removeTransaction(int ID) {

        for (Transaction c : repository.getAll())
            if (c.getId() == ID) {
                repository.remove(ID);
                return;
            }
            throw new RuntimeException("There is no transaction with the given ID!");
    }

    /**
     * Returns a list of all transactions
     * @return
     */
    public List<Transaction> getAll(){
        return repository.getAll();
    }

}