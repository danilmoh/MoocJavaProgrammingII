package application;

import java.util.ArrayList;
import java.util.List;

public class AverageSensor implements Sensor {
    
    private List<Sensor> sensors;
    private List<Integer> averagesHistory;
    
    public AverageSensor() {
        this.sensors = new ArrayList<>();
        this.averagesHistory = new ArrayList<>();
    }
    
    public void addSensor(Sensor sensor) {
        this.sensors.add(sensor);
    }

    @Override
    public boolean isOn() {
       for(int i = 0; i < sensors.size(); i++) {
           if(sensors.get(i).isOn() != true) {
               return false;
           }
       }
       return true;
    }

    @Override
    public void setOn() {
        sensors.stream()
                .forEach(value -> value.setOn());
    }

    @Override
    public void setOff() {
        sensors.stream()
                .forEach(value -> value.setOff());
    }

    @Override
    public int read() {
        if(sensors.isEmpty() || !isOn()) {
            throw new IllegalStateException("illegal state");
        }
        
        int result = (int)sensors.stream()
                .mapToInt(value -> value.read())
                .average()
                .getAsDouble();
        
        averagesHistory.add(result);
        
        return result;
    }
    
    public List<Integer> readings() {
        return averagesHistory;
    }

}
