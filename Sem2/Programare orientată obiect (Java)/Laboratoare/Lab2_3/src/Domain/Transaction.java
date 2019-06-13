package Domain;
import java.util.*;

public class Transaction extends Entity {

    private int Id, DrugId, ClientCardId, Quantity,Discount,Price;
    private String Date, Time;

    public Transaction(int id, int drugId, int clientCardId, int quantity, int discount, int price, String date, String time) {
        Id = id;
        DrugId = drugId;
        ClientCardId = clientCardId;
        Quantity = quantity;
        Discount = discount;
        Price = price;
        Date = date;
        Time = time;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + getId() + '\'' +
                ", drugId='" + getDrugId() + '\'' +
                ", clientCardId='" + getClientCardId() + '\'' +
                ", Quantity='" + getQuantity() + '\'' +
                ", Discount='" + getDiscount() + '\'' +
                ", Price='" + getPrice() + '\'' +
                ", TransactionDate='" + getDate() + '\'' +
                ", TransactionTime='" + getTime() + '\'' +
                '}';
    }

    /**
     * Included so that Transaction can extend Entity
     * @return
     */
    @Override
    public ArrayList<String> getSearchableFields() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Transaction that = (Transaction) o;
        return Id == that.Id &&
                DrugId == that.DrugId &&
                ClientCardId == that.ClientCardId &&
                Quantity == that.Quantity &&
                Discount == that.Discount &&
                Price == that.Price &&
                Date.equals(that.Date) &&
                Time.equals(that.Time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), Id, DrugId, ClientCardId, Quantity, Discount, Price, Date, Time);
    }

    @Override
    public int getId() {
        return Id;
    }

    @Override
    public void setId(int id) {
        Id = id;
    }

    public int getDrugId() {
        return DrugId;
    }

    public void setDrugId(int drugId) {
        DrugId = drugId;
    }

    public int getClientCardId() {
        return ClientCardId;
    }

    public void setClientCardId(int clientCardId) {
        ClientCardId = clientCardId;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public int getDiscount() {
        return Discount;
    }

    public void setDiscount(int discount) {
        Discount = discount;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

}