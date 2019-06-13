package Domain;
import java.util.*;

public class Drug extends Entity{

    private int Id,Price;
    private String Name, Producer;
    boolean ReceiptNeeded;

    public Drug(int id, int price, String name, String producer, boolean receiptNeeded) {
        Id = id;
        Price = price;
        Name = name;
        Producer = producer;
        ReceiptNeeded = receiptNeeded;
    }

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
        return Objects.hash(getId(), getPrice(), getName(), getProducer(), isReceiptNeeded());
    }

    public ArrayList<String> getSearchableFields(){
        ArrayList<String> fields = new ArrayList<>();
        fields.add(this.getName());
        fields.add(this.getProducer());
        return fields;
    }
}