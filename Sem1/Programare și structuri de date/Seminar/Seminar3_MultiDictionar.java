import java.util.Iterator;
import java.util.List;
import java.util.Map;


/*
 *K reprezinta tipul cheilor si V reprezinta tipul valorilor.
 */
public interface MultiDictionar<K, V> {

	/*
	 * Adauga o noua pereche cheie-valoare in  multidictionar
	 */
	public void adauga(K cheie, V valoare);
	
	/*
	 * Sterge o pereche data din multidictionar
	 */
	public void sterge(K cheie, V valoare);
	
	/*
	 * Returneaza lista valorilor care apartin de o cheie. 
	 * Daca cheia nu exista in multidictionar, returneaza o lista vida
	 */
	public List<V> cauta(K cheie);
	
	/*
	 * Returneaza numarul perechilor din multidictionar
	 */
	public int dim();
	
	/*
	 * Returneaza un Iterator pentru multidicitionar. 
	 * Iteratorul returneaza elemente de tip Map.Entry (e o clasa 
	 * existenta din Java) care reprezinta o pereche. Are operatii de
	 * getKey() si getValue()
	 */
	public Iterator<Map.Entry<K, V>> iterator();
	
}
