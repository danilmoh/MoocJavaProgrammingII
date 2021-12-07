package FlightControl.domain;

import java.util.Objects;

public class Place {
    private String ID;
    
    
    public Place(String ID) {
        this.ID = ID;
    }

    public String getID() {
        return ID;
    }

    @Override
    public String toString() {
        return this.ID;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash * Objects.hashCode(this.ID);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Place other = (Place) obj;
        if (!Objects.equals(this.ID, other.ID)) {
            return false;
        }
        return true;
    }
    
}
