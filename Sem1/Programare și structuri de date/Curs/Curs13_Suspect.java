import java.util.HashSet;
import java.util.Set;

public class Suspect {
	//campurile atribuite pt clasa Supect
	private int imei;
	private int timestamp;
	private double x;
	private double y;

	/*
	* Constructorul clasei Suspect.
	* Aceasta functie se apeleaza cand in cod se scrie:
	* Suspect s = new Suspect(123, 123, 10.5, 15.5)
	*/
	public Suspect(int imei, int timestamp, double x, double y) {
		this.imei = imei;
		this.timestamp = timestamp;
		this.x = x;
		this.y = y;
	}
	public String toString(){
		return this.imei + " " + this.timestamp + " " + 
				this.x + " " + this.y;
		}
	
	public int hashCode(){
		return this.imei;
	}
	
	public boolean equals(Object o) {
		if (! (o instanceof Suspect)){
			return false;
		}
		Suspect s = (Suspect)o;
		System.out.println("Check equal: " + s.imei + " " + imei);
		return s.imei == this.imei;
	}		
}
