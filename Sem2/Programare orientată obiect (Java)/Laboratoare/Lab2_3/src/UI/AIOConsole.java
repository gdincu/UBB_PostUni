package UI;
import Domain.ClientCard;
import Domain.Drug;
import Domain.Transaction;
import Service.*;

import java.util.*;
public class AIOConsole {

    private DrugService serviceDrug;
    private ClientCardService clientCardService;
    private TransactionService transactionService;

    /**
     * Constructor
     *
     * @param serviceDrug
     * @param serviceClient
     * @param transactionService
     */
    public AIOConsole(DrugService serviceDrug, ClientCardService serviceClient, TransactionService transactionService) {
        this.serviceDrug = serviceDrug;
        this.clientCardService = serviceClient;
        this.transactionService = transactionService;
    }

    /**
     * Prints out lines
     *
     * @param option
     */
    public void linii(int option) {
        if (option == 1)
            System.out.print("\n=================================================================================\n");
        if (option == 2)
            System.out.print("=================================================================================");
    }

    /**
     * Shows all client cards in the repository
     */
    public void showCards() {
        linii(1);
        System.out.print("List of Client Cards");
        linii(1);
        System.out.print(new Formatter().format("%-5s|%-10s|%-15s|%-15s|%-30s|%-30s", "ID", "CNP", "Surname", "Forename", "DOB", "Reg Date"));
        linii(1);
        for (ClientCard c : clientCardService.getAll())
            System.out.print(new Formatter().format("%-5s|%-10s|%-15s|%-15s|%-30s|%-30s\n", c.getId(), c.getCNP(), c.getSurname(), c.getForename(), c.getDOB(), c.getRegDate()));
        linii(2);
        System.out.println();
    }

    /**
     * Shows all drugs in the repository
     */
    public void showDrugs() {

        linii(1);
        System.out.print("List of Drugs");
        linii(1);
        System.out.print(new Formatter().format("%-5s|%-10s|%-15s|%-15s|%-10s", "ID", "Price", "Name", "Producer", "Receipt Needed"));
        linii(1);
        for (Drug c : serviceDrug.getAll())
            System.out.print(new Formatter().format("%-5s|%-10s|%-15s|%-15s|%-10s\n", c.getId(), c.getPrice(), c.getName(), c.getProducer(), c.isReceiptNeeded()));
        linii(2);
        System.out.println();
    }

    /**
     * Shows all transactions in the repository
     */
    public void showTransactions() {

        linii(1);
        System.out.print("List of Transactions");
        linii(1);
        System.out.print(new Formatter().format("%-5s|%-10s|%-20s|%-10s|%-20s|%-10s|%-20s|%-20s|%-30s", "ID", "Drug Id", "Client Card Id", "Quantity", "Regular Price", "Discount %", "Discounted Value", "Final Price", "Transaction Date"));
        linii(1);
        for (Transaction c : transactionService.getAll())
            System.out.print(new Formatter().format("%-5s|%-10s|%-20s|%-10s|%-20s|%-10s|%-20s|%-20s|%-30s\n", c.getId(), c.getDrugId(), c.getClientCardId(), c.getQuantity(), c.getPrice() * c.getQuantity() / (100 - c.getDiscount()), c.getDiscount(), c.getPrice() * c.getQuantity() / (100 - c.getDiscount()) * c.getQuantity() * (1 - (c.getDiscount() / 100)) - c.getPrice(), c.getPrice(), c.getDate()));
        linii(2);
        System.out.println();
    }

    /**
     * Console using all in one input
     */
    public void allInOneInput() {
        while (true) {
            System.out.println("Add operation: ");
            String input = new Scanner(System.in).nextLine();
            String[] parts = input.split(",");
            switch (parts[0]) {
                case "addDrug":
                    serviceDrug.addDrug(Integer.valueOf(parts[1]), Integer.parseInt(parts[2]), parts[3], parts[4], Boolean.parseBoolean(parts[5]));
                    break;
                case "addClient":
                    clientCardService.addClientCard(Integer.valueOf(parts[1]), parts[2], parts[3], parts[4], parts[5], parts[6]);
                    break;
                case "addTransaction":
                    transactionService.addTransaction(Integer.valueOf(parts[1]), Integer.parseInt(parts[2]), Integer.parseInt(parts[3]), Integer.parseInt(parts[4]), parts[5], parts[6]);
                    break;
                case "removeDrug":
                    serviceDrug.removeDrug(Integer.valueOf(parts[1]));
                    break;
                case "removeClientCard":
                    clientCardService.removeClientCard(Integer.valueOf(parts[1]));
                    break;
                case "removeTransaction":
                    transactionService.removeTransaction(Integer.valueOf(parts[1]));
                    break;
                case "showDrugs":
                    showDrugs();
                    break;
                case "showClientCards":
                    showCards();
                    break;
                case "showTransactions":
                    showTransactions();
                    break;
                case "exit":
                    System.exit(0);
                    return;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }
}
