package UI;
import Domain.ClientCard;
import Domain.Drug;
import Domain.Transaction;
import Service.*;

import java.util.*;

public class Console {

    private DrugService serviceDrug;
    private ClientCardService clientCardService;
    private TransactionService transactionService;

    /**
     * Constructor
     * @param serviceDrug
     * @param serviceClient
     * @param transactionService
     */
    public Console(DrugService serviceDrug, ClientCardService serviceClient,TransactionService transactionService)
    {
        this.serviceDrug = serviceDrug;
        this.clientCardService = serviceClient;
        this.transactionService = transactionService;
    }

    /**
     * Prints out lines
     * @param option
     */
    public void linii(int option) {
        if(option == 1) System.out.print("\n=================================================================================\n");
        if(option == 2) System.out.print("=================================================================================");
    }

    /**
     * Show the meniu
     */
    private void showMenu() {

        linii(1);System.out.print(new Formatter().format("%-20s|%-25s|%-20s","Drugs","Client Cards","Transactions"));linii(1);
        System.out.print(new Formatter().format("%-20s|%-25s|%-20s","1. Add drug.","4. Add client card.","7. Add transaction.\n"));
        System.out.print(new Formatter().format("%-20s|%-25s|%-20s","2. Remove drug.","5. Remove client card.","8. Remove transaction.\n"));
        System.out.print(new Formatter().format("%-20s|%-25s|%-20s","3. Show all drugs.","6. Show all clients.","9. Show all transactions.\n"));
        linii(2);
        System.out.print(new Formatter().format("\n%-20s|%-25s|%-20s","141. Search drugs.","142. Search clients.","142. Search transactions.\n"));
        System.out.print(new Formatter().format("%-20s|%-25s|%-20s","16. Drugs by sales.","17. Clients by discounts.","15. Transactions by date.\n"));
        System.out.print(new Formatter().format("%-20s|%-25s|%-20s","","","18. Remove Transactions.\n"));
        System.out.print(new Formatter().format("%-20s|%-25s|%-20s","3. Show all drugs.","6. Show all clients.","9. Show all transactions.\n"));
        linii(2);
        System.out.println("\n19 - Increase prices");
        System.out.println("20 - Undo");
        System.out.println("21 - Redo");
        linii(2);
        System.out.println("\n0. Exit.");
        linii(2);
        System.out.print("\nYour option: ");
    }

    /**
     * Add a drug
     */
    private void addDrug() {
        System.out.print("\nEntry id: ");
        int id = new Scanner(System.in).nextInt();
        System.out.print("Drug name: ");
        String name = new Scanner(System.in).nextLine();
        System.out.print("Producer: ");
        String producer=new Scanner(System.in).nextLine();
        System.out.print("Price: ");
        int price = new Scanner(System.in).nextInt();
        System.out.print("Receipt required(True/ False): ");
        boolean receiptNeeded = new Scanner(System.in).nextBoolean();

        try {
            serviceDrug.addDrug(id,price,name,producer,receiptNeeded);
            System.out.println("\nDrug added successfully!\n");
        } catch (RuntimeException rex) {
            System.out.println("\nWe have errors:");
            System.out.println(rex.getMessage());
        }
    }

    /**
     * Add a client card
     */
    private void addClientCard() {
        System.out.print("\nEntry id: ");
        int id = new Scanner(System.in).nextInt();
        System.out.print("Surname: ");
        String surname = new Scanner(System.in).nextLine();
        System.out.print("Forename: ");
        String forename=new Scanner(System.in).nextLine();
        System.out.print("CNP: ");
        String CNP = new Scanner(System.in).nextLine();
        System.out.print("Date of Birth: ");
        String DOB = new Scanner(System.in).nextLine();
        System.out.print("Date of Registration: ");
        String regDate = new Scanner(System.in).nextLine();

        try {
            clientCardService.addClientCard(id,CNP,surname,forename,DOB,regDate);
            System.out.println("\nClient Card added successfully!\n");
        } catch (RuntimeException rex) {
            System.out.println("\nWe have errors:");
            System.out.println(rex.getMessage());
        }
    }

    /**
     * Add a transaction
     * @throws Exception
     */
    private void addTransaction() {
        System.out.print("\nTransaction id: ");
        int id = new Scanner(System.in).nextInt();
        System.out.print("Drug ID: ");
        int drugId = new Scanner(System.in).nextInt();
        System.out.print("Client Card Id: ");
        int clientCardId = new Scanner(System.in).nextInt();
        System.out.print("Quantity: ");
        int quantity = new Scanner(System.in).nextInt();
        System.out.print("Transaction Date: ");
        String transactionDate = new Scanner(System.in).nextLine();
        System.out.print("Transaction Time: ");
        String transactionTime = new Scanner(System.in).nextLine();

        try {
            transactionService.addTransaction(id,drugId,clientCardId,quantity,transactionDate,transactionTime);
            System.out.println("\nTransaction added successfully!\n");
        } catch (RuntimeException rex) {
            System.out.println("\nWe have errors:");
            System.out.println(rex.getMessage());
        }
    }

    /**
     * Remove a drug
     */
    private void removeDrug() {
        System.out.print("Drug id: ");
        int ID = new Scanner(System.in).nextInt();

        try {
            serviceDrug.removeDrug(ID);
            System.out.println("\nDrug removed successfully!\n");
        } catch (RuntimeException rex) {
            System.out.println("\nWe have errors:");
            System.out.println(rex.getMessage());
        }
    }

    /**
     * Remove a client card
     */
    private void removeClientCard() {
        System.out.print("Client Card ID: ");
        int ID = new Scanner(System.in).nextInt();

        try {
            clientCardService.removeClientCard(ID);
            System.out.println("\nClient Card removed successfully!\n");
        } catch (RuntimeException rex) {
            System.out.println("\nWe have errors:");
            System.out.println(rex.getMessage());
        }
    }

    /**
     * Removes a transaction
     */
    private void removeTransaction() {
        System.out.print("Transaction ID: ");
        int ID = new Scanner(System.in).nextInt();

        try {
            transactionService.removeTransaction(ID);
            System.out.println("\nTransaction removed successfully!\n");
        } catch (RuntimeException rex) {
            System.out.println("\nWe have errors:");
            System.out.println(rex.getMessage());
        }
    }

    /**
     * Searches for a client card
     */
    private void ClientSearch() {
        System.out.println("What to look for: ");
        String text = new Scanner(System.in).nextLine();
        System.out.println("\nSearch results: ");
        for (ClientCard c : clientCardService.fullTextSearch(text)) {
            System.out.println(c);
        }
    }

    /**
     * Searches for a drug
     */
    private void DrugSearch() {
        System.out.println("What to look for: ");
        String text = new Scanner(System.in).nextLine();
        System.out.println("\nSearch results: ");
        for (Drug c : serviceDrug.fullTextSearch(text))
            System.out.println(c);
    }

    /**
     * Shows all client cards in the repository
     */
    public void showCards() {
        linii(1); System.out.print("List of Client Cards");
        linii(1); System.out.print(new Formatter().format("%-5s|%-10s|%-15s|%-15s|%-30s|%-30s","ID","CNP","Surname","Forename","DOB","Reg Date")); linii(1);
        for (ClientCard c : clientCardService.getAll())
            System.out.print(new Formatter().format("%-5s|%-10s|%-15s|%-15s|%-30s|%-30s\n",c.getId(),c.getCNP(),c.getSurname(),c.getForename(),c.getDOB(),c.getRegDate()));
        linii(2);
        System.out.println();
    }

    /**
     * Shows all drugs in the repository
     */
    public void showDrugs() {

        linii(1); System.out.print("List of Drugs");
        linii(1); System.out.print(new Formatter().format("%-5s|%-10s|%-15s|%-15s|%-10s","ID","Price","Name","Producer","Receipt Needed")); linii(1);
        for (Drug c : serviceDrug.getAll())
            System.out.print(new Formatter().format("%-5s|%-10s|%-15s|%-15s|%-10s\n",c.getId(),c.getPrice(),c.getName(),c.getProducer(),c.isReceiptNeeded()));
        linii(2);
        System.out.println();
    }

    /**
     * Shows all transactions in the repository
     */
    public void showTransactions() {

        linii(1); System.out.print("List of Transactions");
        linii(1); System.out.print(new Formatter().format("%-5s|%-10s|%-20s|%-10s|%-20s|%-10s|%-20s|%-20s|%-30s","ID","Drug Id","Client Card Id","Quantity","Regular Price","Discount %","Discounted Value","Final Price","Transaction Date")); linii(1);
        for (Transaction c : transactionService.getAll())
            System.out.print(new Formatter().format("%-5s|%-10s|%-20s|%-10s|%-20s|%-10s|%-20s|%-20s|%-30s\n",c.getId(),c.getDrugId(),c.getClientCardId(),c.getQuantity(),c.getPrice()*c.getQuantity()/(100-c.getDiscount()),c.getDiscount(),c.getPrice()*c.getQuantity()/(100-c.getDiscount())*c.getQuantity()*(1-(c.getDiscount()/100))-c.getPrice(),c.getPrice(),c.getDate()));
        linii(2);
        System.out.println();
    }

    /**
     * Run method
     */
    public void run()  {

        while (true) {
            showMenu();

            int option = new Scanner(System.in).nextInt();
            switch (option) {
                case 1:
                    addDrug();
                    break;

                case 2:
                    removeDrug();
                    break;

                case 3:
                    showDrugs();
                    break;

                case 4:
                    addClientCard();
                    break;

                case 5:
                    removeClientCard();
                    break;

                case 6:
                    showCards();
                    break;

                case 7:
                    addTransaction();
                    break;

                case 8:
                    removeTransaction();
                    break;

                case 9:
                    showTransactions();
                    break;

                case 141:
                    DrugSearch();
                    break;

                case 142:
                    ClientSearch();
                    break;

                case 0:
                    System.exit(0);
                    break;

                    default:
                        System.out.println("Invalid option!");
                        break;
            }
    }
    }
    }