
import java.util.HashMap;

public class IOU {
    
    private HashMap<String, Double> owing;
    
    public IOU(){
        owing = new HashMap<>();
    }
    
    public void setSum(String toWhom, double amount){
        owing.put(toWhom, amount);
    }
    
    public double howMuchDoIOweTo(String toWhom) {
        return owing.getOrDefault(toWhom, (double) 0);
    }
}
