
import java.util.Objects;

public class LicensePlate {
    // don't modify existing parts of this class

    // these instance variables have been defined as final, meaning 
    // that once set, their value can't be changed
    private final String liNumber;
    private final String country;

    public LicensePlate(String country, String liNumber) {
        this.liNumber = liNumber;
        this.country = country;
    }

    @Override
    public String toString() {
        return country + " " + liNumber;
    }
    
    @Override
    public boolean equals(Object comparable){
        if(this == comparable){
            return true;
        }
        if(comparable == null || getClass() != comparable.getClass()){
            return false;
        }
        LicensePlate liPlateComparable = (LicensePlate)comparable;
        return this.liNumber.equals(liPlateComparable.liNumber) && this.country.equals(liPlateComparable.country);
    }
    
    @Override
    public int hashCode(){
        int hash = 7;
        hash = 31 * hash + (null == country ? 0 : country.hashCode());
        hash = 31 * hash + (null == liNumber ? 0 : liNumber.hashCode());
        return hash;
    }

}
