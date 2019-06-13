package Domain;
import java.util.*;

public class ClientCard extends Entity{

    private int Id;
    private String CNP,Surname,Forename,DOB,RegDate;

    /**
     * Constructor
     * @param id the id to be added
     * @param CNP the CNP to be added
     * @param surname the surname to be added
     * @param forename the forename to be added
     * @param DOB the DOB to be added
     * @param regDate the regDate to be added
     */
    public ClientCard(int id, String CNP, String surname, String forename, String DOB, String regDate) {
        Id = id;
        this.CNP = CNP;
        Surname = surname;
        Forename = forename;
        this.DOB = DOB;
        RegDate = regDate;
    }

    /**
     * Used for the full text search functionality
     * @return all details of a Client card concatenated into a String
     */
    @Override
    public String toString() {
        return "ClientCard{" +
                "id='" + getId() + '\'' +
                ", CNP='" + getCNP() + '\'' +
                ", Surname='" + getSurname() + '\'' +
                ", Forename='" + getForename() + '\'' +
                ", DOB='" + getDOB() + '\'' +
                ", dateOfRegistration='" + getRegDate() + '\'' +
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

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getForename() {
        return Forename;
    }

    public void setForename(String forename) {
        Forename = forename;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getRegDate() {
        return RegDate;
    }

    public void setRegDate(String regDate) {
        RegDate = regDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ClientCard that = (ClientCard) o;
        return Id == that.Id &&
                CNP.equals(that.CNP) &&
                Surname.equals(that.Surname) &&
                Forename.equals(that.Forename) &&
                DOB.equals(that.DOB) &&
                RegDate.equals(that.RegDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), Id, CNP, Surname, Forename, DOB, RegDate);
    }
}