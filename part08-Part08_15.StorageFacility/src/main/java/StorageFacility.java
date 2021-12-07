import java.util.HashMap;
import java.util.ArrayList;

public class StorageFacility {
    
    private HashMap<String, ArrayList<String>> storage;
    
    public StorageFacility() {
        this.storage = new HashMap<>();    
    }
    
    public void add(String unit, String item){
        storage.putIfAbsent(unit, new ArrayList<>());
        
        ArrayList<String> items = storage.get(unit);
        items.add(item);
    }
    
    public ArrayList<String> contents(String storageUnit) {
        if(storage.containsKey(storageUnit)){
            return storage.get(storageUnit);
        } else {
            return new ArrayList<>();
        }
    }
    
    public void remove(String unit, String item){
        if(storage.containsKey(unit)){
            ArrayList<String> items = storage.get(unit);
            if(items.contains(item)){
                items.remove(item);
                
            }
        }
    }
    
    
    public ArrayList<String> storageUnits() {
        ArrayList<String> unitNames  = new ArrayList<>();
        for(String unitName : storage.keySet()){
            if(!storage.get(unitName).isEmpty()) {
                unitNames.add(unitName);
            }
        }
        return unitNames;
    }
}
