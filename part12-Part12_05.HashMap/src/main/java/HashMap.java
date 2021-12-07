import java.util.ArrayList;
import java.util.List;

public class HashMap<K, V> {
    private List<Pair<K, V>>[] hash;
    private int firstFreeIndex;
    private final int loadFactor;
    
    public HashMap() {
        this.hash = new List[16];
        initializeArrayOfLists(this.hash);
        this.firstFreeIndex = 0;
        this.loadFactor = 16;
    }
    
    private void initializeArrayOfLists(List<Pair<K, V>>[] list) {
        for(int i = 0; i < list.length; i++) { 
            list[i] = new ArrayList<>();
        }
    }
    
    public void put(K key, V value) {
        int hashValue = getHashValue(key, this.hash.length);
        
        Pair<K, V> pair = new Pair<>(key, value);
        
        this.hash[hashValue].add(pair);
        if(isOnLoadFactor(this.hash[hashValue])) {
            grow();
        }
    }
        
    private int getHashValue(K key, int length) {
        int hashValue = Math.abs( key.hashCode() % length);
        return hashValue;
    }
    
    public boolean isOnLoadFactor(List list) {
        return list.size() == 16;
    }
    
    public void grow() {
        List<Pair<K, V>>[] newList = new List[this.hash.length * 2];
        initializeArrayOfLists(newList);
        
        for(int i = 0; i < hash.length; i++) {
            copy(newList, i);
        }
        
        this.hash = newList;
    }
    
    private void copy(List<Pair<K, V>>[] newList, int fromIdx) {
        for(int i = 0; i < this.hash[fromIdx].size(); i++) {
            Pair<K, V> value = this.hash[fromIdx].get(i);
            
            int hashValue = getHashValue(value.getKey(), newList.length);
            newList[hashValue].add(value);
        }
    }
    
    
    public V get(K key) {
        int hashValue = getHashValue(key, this.hash.length);
        
        for(int i = 0 ; i < hash[hashValue].size(); i++) {
            return getValue(hashValue, i);
        }
        
        return null;
    }
    
    private V getValue(int hashValue, int index) {
        if(hash[hashValue].get(index) == null) {
            return null;
        } else {
            return hash[hashValue].get(index).getValue();
        }
    }
    
    public void remove(K key) {
        int hashValue = getHashValue(key, this.hash.length);
        
        for(int i = 0; i < hash[hashValue].size(); i++) {
            if(hash[hashValue].get(i) != null) {
                hash[hashValue].remove(i);
            }
        }
    }
    

    public void visualize() {
        System.out.println("----visualization----");
        for(List l : hash) {
            System.out.println(l);
        }
    }

    public boolean has(K value) {
        return get(value) != null;
    }
}