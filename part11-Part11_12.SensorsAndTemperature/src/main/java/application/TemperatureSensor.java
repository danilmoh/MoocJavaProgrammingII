package application;

import java.util.Random;

public class TemperatureSensor implements Sensor {
    
    private boolean enabled;
    
    public TemperatureSensor() {
        this.enabled = false;
    }

    @Override
    public boolean isOn() {
        return this.enabled;
    }

    @Override
    public void setOn() {
        this.enabled = true;
    }

    @Override
    public void setOff() {
       this.enabled = false;
    }

    @Override
    public int read() {
        Random rand = new Random();
        return rand.nextInt(60) - 30;
        
    }
}
