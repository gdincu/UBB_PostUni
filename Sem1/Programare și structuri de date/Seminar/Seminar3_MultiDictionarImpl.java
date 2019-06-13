import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


public class MultiDictionarImpl<K,V> implements MultiDictionar<K, V> {

	private Map<K, List<V>> elemente;
	
	public MultiDictionarImpl() {
		this.elemente = new HashMap<K, List<V>>();
	}
	
	public void adauga(K cheie, V valoare) {
		if (elemente.containsKey(cheie)) {
			List<V> valori = elemente.get(cheie);
			valori.add(valoare);
		} else {
			List<V> valori = new ArrayList<V>();			
			valori.add(valoare);
			elemente.put(cheie,  valori);
		}		
	}

	public void sterge(K cheie, V valoare) {
		if (elemente.containsKey(cheie)) {
			List<V> valori = elemente.get(cheie);
			valori.remove(valoare);
			if (valori.size() == 0) {
				elemente.remove(cheie);
			}
		}		
	}

	public List<V> cauta(K cheie) {
		
		if (elemente.containsKey(cheie)) {
			return elemente.get(cheie);
		} else {
			return new ArrayList<V>();
		}
	}
	
	public int dim() {
		int nrElem = 0;
		for (K cheie: elemente.keySet()) {
			nrElem += elemente.get(cheie).size();
		}		
		return nrElem;
	}

	public Iterator<Entry<K, V>> iterator() {
		// TODO Auto-generated method stub
		return new MultiDictionarImplIterator(this);
	}
	
	public class MultiDictionarImplIterator implements Iterator<Map.Entry<K, V>> {

		private Iterator<Map.Entry<K, List<V>>> mapIterator;
		Map.Entry<K, List<V>> currentEntry;
		private int currentPosition;
		
		public MultiDictionarImplIterator(MultiDictionarImpl<K,V> multimap){
			this.mapIterator = multimap.elemente.entrySet().iterator();
			if(this.mapIterator.hasNext()) {
				currentEntry = this.mapIterator.next();
				this.currentPosition = 0;
			}
		}
		
		public boolean hasNext() {
			if (this.mapIterator.hasNext()) {
				return true;
			} else { 
				return currentPosition < currentEntry.getValue().size();
			}
		}

		@Override
		public Entry<K, V> next() {
			K currentKey = currentEntry.getKey();
			V currentValue = currentEntry.getValue().get(currentPosition);
						
			List<V> values = currentEntry.getValue();
			if (this.currentPosition < values.size()-1) {
				this.currentPosition++;
			} else {
				if (this.mapIterator.hasNext()) {
					this.currentEntry = this.mapIterator.next();
					this.currentPosition = 0;
				} else {
					this.currentPosition = values.size();
				}
				
			}			
			Map.Entry<K, V> currentEntry = new MultiMapEntry(currentKey, currentValue);			
			return currentEntry;
		}		
	}
	
	public class MultiMapEntry implements Map.Entry<K, V> {

		private K cheie;
		private V valoare;
		
		public MultiMapEntry(K cheie, V valoare) {
			this.cheie = cheie;
			this.valoare = valoare;
		}
		
		public K getKey() {
			return this.cheie;
		}

		@Override
		public V getValue() {
			return this.valoare;
		}

		@Override
		public V setValue(V value) {
			V oldValue = valoare;
			this.valoare = value;
			return oldValue;
		}
		
	}

}
