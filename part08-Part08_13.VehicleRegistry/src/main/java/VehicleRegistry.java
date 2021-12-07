import java.util.HashMap;
import java.util.ArrayList;

public class VehicleRegistry {
    
    private HashMap<LicensePlate, String> cars;
    
    public VehicleRegistry(){
        cars = new HashMap();
    }
    
    public boolean add(LicensePlate licensePlate, String owner){
        if(cars.containsKey(licensePlate)){
            return false;
        }
        /*if(cars.containsValue(owner)){
            return false;
        }*/
        cars.put(licensePlate, owner);
        return true;
    }
    
    public String get(LicensePlate licensePlate){
        if(!cars.containsKey(licensePlate)){
            return null;
        }
        
        return cars.get(licensePlate);
    }
    
    public boolean remove(LicensePlate licensePlate){
        if(!cars.containsKey(licensePlate)){
            return false;
        }
        cars.remove(licensePlate);
        return true;
    }
    
    public void printLicensePlates(){
        for(LicensePlate liPlate : cars.keySet()){
            System.out.println(liPlate);
        }
    }
    
    public void printOwners(){
        ArrayList<String> printed = new ArrayList<>();
        
        for(String owner : cars.values()){
            if(printed.contains(owner)){
                continue;
            }
               printed.add(owner);
            System.out.println(owner);
        }
    }
    
    
}
