import java.util.Objects;

public class Vin {
    private String denumire;
    private String tip;
    private int stocI;
    private int vandut;
    private int pretUnit;
	/**
	 * @return the denumire
	 */
	public String getDenumire() {
		return denumire;
	}
	/**
	 * @param denumire the denumire to set
	 */
	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}
	/**
	 * @return the tip
	 */
	public String getTip() {
		return tip;
	}
	/**
	 * @param tip the tip to set
	 */
	public void setTip(String tip) {
		this.tip = tip;
	}
	/**
	 * @return the stocI
	 */
	public int getStocI() {
		return stocI;
	}
	/**
	 * @param stocI the stocI to set
	 */
	public void setStocI(int stocI) {
		this.stocI = stocI;
	}
	/**
	 * @return the vandut
	 */
	public int getVandut() {
		return vandut;
	}
	/**
	 * @param vandut the vandut to set
	 */
	public void setVandut(int vandut) {
		this.vandut = vandut;
	}
	/**
	 * @return the pretUnit
	 */
	public int getPretUnit() {
		return pretUnit;
	}
	/**
	 * @param pretUnit the pretUnit to set
	 */
	public void setPretUnit(int pretUnit) {
		this.pretUnit = pretUnit;
	}
	public Vin(String denumire, String tip, int stocI, int vandut, int pretUnit) {
		super();
		this.denumire = denumire;
		this.tip = tip;
		this.stocI = stocI;
		this.vandut = vandut;
		this.pretUnit = pretUnit;
	}

  public Vin() {
	  this("","",0,0,0);
  }
/* (non-Javadoc)
 * @see java.lang.Object#hashCode()
 */
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((denumire == null) ? 0 : denumire.hashCode());
	result = prime * result + pretUnit;
	result = prime * result + stocI;
	result = prime * result + ((tip == null) ? 0 : tip.hashCode());
	result = prime * result + vandut;
	return result;
}
/* (non-Javadoc)
 * @see java.lang.Object#equals(java.lang.Object)
 */
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Vin other = (Vin) obj;
	if (denumire == null) {
		if (other.denumire != null)
			return false;
	} else if (!denumire.equals(other.denumire))
		return false;
	if (pretUnit != other.pretUnit)
		return false;
	if (stocI != other.stocI)
		return false;
	if (tip == null) {
		if (other.tip != null)
			return false;
	} else if (!tip.equals(other.tip))
		return false;
	if (vandut != other.vandut)
		return false;
	return true;
}
  
  
}
