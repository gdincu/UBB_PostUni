package Service;
import Domain.*;
import Repository.*;

import java.text.SimpleDateFormat;
import java.util.*;

public class TransactionService {

    private IRepository<Transaction> repository;
    private  IRepository<Drug> drugRepository;
    private  IRepository<ClientCard> clientCardRepository;
    private Stack<UndoRedo<Transaction>> undoableOperations = new Stack<>();
    private Stack<UndoRedo<Transaction>> redoableeOperations = new Stack<>();

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
     * Works out the price paid
     * @param t
     * @return
     */
    private int pricePaid (Transaction t){
        int temp;
        if (t.getClientCardId() !=  0){
            if(drugRepository.findById(t.getDrugId()).isReceiptNeeded())
                temp = (drugRepository.findById(t.getDrugId()).getPrice()-(drugRepository.findById(t.getDrugId()).getPrice() *15 / 100)) * t.getQuantity();
            else
                temp = (drugRepository.findById(t.getDrugId()).getPrice()-(drugRepository.findById(t.getDrugId()).getPrice() *15 / 100)) * t.getQuantity();
        }
        else
            temp = drugRepository.findById(t.getDrugId()).getPrice() * t.getQuantity();
        return temp;
    }

    /**
     * Works out the discount applied
     * @param t
     * @return
     */
    private int disccount(Transaction t){
        int disccount = 0;
        if (t.getClientCardId() != 0) {
            if(drugRepository.findById(t.getDrugId()).isReceiptNeeded())
                disccount = (drugRepository.findById(t.getDrugId()).getPrice() *15 /100) * t.getQuantity();
            else
                disccount = (drugRepository.findById(t.getDrugId()).getPrice() *15 /100) * t.getQuantity();
        }
        return disccount;
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

        int[] res = discountAndPrice(clientCardId,drugId,quantity);
        Transaction existing = repository.findById(id);
        Transaction transaction = new Transaction(id, drugId, clientCardId, quantity, res[0], res[1], transactionDate, transactionTime);
        if (existing != null) {
            undoableOperations.add(new UpdateOperation<>(repository, existing,transaction));
        } else {
            undoableOperations.add(new AddOperation<>(repository, transaction));
        }
        redoableeOperations.clear();

        for (Transaction c : repository.getAll())
            if (c.getId() == id)
                throw new RuntimeException("This transaction already exists!");

        repository.upsert(transaction);
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
            if (c.getId() == clientCardId)
                n[0] = 1;

        for (Drug c : drugRepository.getAll()) {
            if (c.getId() == drugId && c.isReceiptNeeded()) {
                n[0] *= 15;
                n[1] = (int) (c.getPrice() * quantity * 0.85);
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

        Transaction temp = repository.findById(ID);
        undoableOperations.add(new RemoveOperation<>(repository, temp));
        redoableeOperations.clear();

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

    /**
     * Works out the total quantity
     * @param id
     * @return
     */
    private int totalQuantity(int id){
        int temp = 0;
        for (Transaction t : repository.getAll())
            if(t.getDrugId() == id)
                temp += t.getQuantity();
        return temp;
    }

    /**
     * Sorts drugs by sales
     */
    public void sortedDrugBySales(){

        List<Drug> drugs= new ArrayList<>(drugRepository.getAll());
        Comparator<Drug> bySales = (d1 , d2) -> {
            int t1=0,t2=0;
            for(Transaction t : repository.getAll()){
                if(t.getDrugId() == d1.getId())
                    t1 += t.getQuantity();
                if(t.getDrugId() == d2.getId())
                    t2 += t.getQuantity();
            }
            return t2-t1;
        };
        drugs.sort(bySales);
        int i=0;
        for (Drug d: drugs ) {
            System.out.printf("%d. Id:%-5s |Drug: %-15s |Prod: %-15s |Receipt: %-5b |Price:%-5d |Quantity: %-5d %n",i,d.getId(),d.getName(),d.getProducer(),d.isReceiptNeeded(),d.getPrice(),totalQuantity(d.getId()));
            i++;
        }
    }
    private int totalDiscount(int id) {
        int temp = 0;
        for (Transaction t : repository.getAll()) {
            if (t.getClientCardId() == id) {
                if (drugRepository.findById(id).isReceiptNeeded())
                    temp += (drugRepository.findById(id).getPrice() * 15 / 100) * t.getQuantity();
            } else
                temp += (drugRepository.findById(id).getPrice() * 10 / 100) * t.getQuantity();
        }
        return temp;
    }

    public void sortClientCardsByDisccount(List<ClientCard> clients) {
        Comparator<Transaction> byTotalPrice = (o1, o2) -> {
            int t1 = 0, t2 = 0;
            for( Transaction t: repository.getAll()){
                if (t.getClientCardId() == o1.getClientCardId()) {
                    if (drugRepository.findById(t.getDrugId()).isReceiptNeeded())
                        t1 += (drugRepository.findById(t.getDrugId()).getPrice() * 15 / 100) * t.getQuantity();
                    else {
                        t1 += (drugRepository.findById(t.getDrugId()).getPrice() * 10 / 100) * t.getQuantity();
                    }
                }
                if(t.getClientCardId() == o2.getClientCardId()) {
                    if (drugRepository.findById(t.getDrugId()).isReceiptNeeded())
                        t2 += (drugRepository.findById(t.getDrugId()).getPrice() * 15 / 100) * t.getQuantity();
                    else
                        t2 += (drugRepository.findById(t.getDrugId()).getPrice() * 10 / 100) * t.getQuantity();
                }
            }
            return t2 - t1;
        };

        List<Transaction> transactions = new ArrayList<>(repository.getAll()) ;
        transactions.sort(byTotalPrice);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        int i=0;
        for (ClientCard d:clients ) {
            System.out.printf("%d. Id:%-5s |CNP: %-15s |Surname: %-10s |Forename: %-15s |DOB:%-15s |RegDate:%-15s |TotalDiscount: %-5.2f %n",i,d.getId(),d.getCNP(),d.getSurname(),d.getForename(),formatter.format(d.getDOB()), formatter.format(d.getRegDate()),totalDiscount(d.getId()));
            i++;
        }
    }

    public void undo() {
        if (!undoableOperations.empty()) {
            UndoRedo<Transaction> lastOperation = undoableOperations.pop();
            lastOperation.doUndo();
            redoableeOperations.add(lastOperation);

        }
    }

    public void redo() {
        if (!redoableeOperations.empty()) {
            UndoRedo<Transaction> lastOperation = redoableeOperations.pop();
            lastOperation.doRedo();
            undoableOperations.add(lastOperation);
        }
    }

}