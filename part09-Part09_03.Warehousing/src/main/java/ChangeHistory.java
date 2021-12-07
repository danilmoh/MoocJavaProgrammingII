
import java.util.ArrayList;
import java.util.Collections;

public class ChangeHistory {
    private ArrayList<Double> history;
    
    public ChangeHistory () {
        this.history = new ArrayList();
    }
    
    public void add(double status) {
        this.history.add(status);
    }
    
    public void clear() {
        history.clear();
    }
    
    @Override
    public String toString() {
        return this.history.toString();
    }
    
    private ArrayList<Double> sortedHistory() {
        ArrayList<Double> historyCopy = new ArrayList<>(history);
        Collections.sort(historyCopy);
        return historyCopy;
    }

    public double maxValue() {
        if(history.isEmpty()){
            return 0.0;
        }
        
        double maxVal = sortedHistory().get(history.size()-1);
        
        return maxVal;
    }
    
    public double minValue() {
        if(history.isEmpty()) {
            return 0.0;
        }
        
        double minVal = sortedHistory().get(0);
        
        return minVal;
    }
    
    
    public double average() {
        if(history.isEmpty()) {
            return 0.0;
        }
        
        double average = 0.0;
        double number = 0.0;
        double sum = 0.0;
        
        for(double d : history) {
            number++;
            sum += d;
        }
        average = sum / number;
        
        return average;
    }
}
