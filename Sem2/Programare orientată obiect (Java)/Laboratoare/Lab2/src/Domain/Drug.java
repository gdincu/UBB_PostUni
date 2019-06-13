package Domain;
import java.util.*;

public class Drug extends Entity{

    private int Id,Price;
    private String Name, Producer;
    boolean ReceiptNeeded;

    /**
     * Constructor
     * @param id
     * @param price
     * @param name
     * @param producer
     * @param receiptNeeded
     */
    public Drug(int id, int price, String name, String producer, boolean receiptNeeded) {
        Id = id;
        Price = price;
        Name = name;
        Producer = producer;
        ReceiptNeeded = receiptNeeded;
    }

    /**
     * Used for the full text search functionality
     * @return
     */
    @Override
    public String toString() {
        return "Drug{" +
                "id='" + getId() + '\'' +
                ", Price='" + getPrice() + '\'' +
                ", Name='" + getName() + '\'' +
                ", Producer='" + getProducer() + '\'' +
                ", ReceiptNeeded='" + isReceiptNeeded() + '\'' +
                '}';
    }

    /**
     * Used for the full text search functionality
     * @return
     */
    @Override
    public ArrayList<String> getSearchableFields() {
        return null;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getProducer() {
        return Producer;
    }

    public void setProducer(String producer) {
        Producer = producer;
    }

    public boolean isReceiptNeeded() {
        return ReceiptNeeded;
    }

    public void setReceiptNeeded(boolean receiptNeeded) {
        ReceiptNeeded = receiptNeeded;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Drug)) return false;
        Drug drug = (Drug) o;
        return getId() == drug.getId() &&
                getPrice() == drug.getPrice() &&
                isReceiptNeeded() == drug.isReceiptNeeded() &&
                getName().equals(drug.getName()) &&
                getProducer().equals(drug.getProducer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, Price, Name, Producer, ReceiptNeeded);
    }
}