
import java.util.List;
import java.util.ArrayList;

public class Pipe<T> {
    
    private List<T> objects;
    
    public Pipe() {
        this.objects = new ArrayList<>();
    }
    
    public void putIntoPipe(T value) {
        objects.add(value);
    }
    
    public T takeFromPipe() {
        if(objects.isEmpty()) {
            return null;
        }
        T object = objects.get(0);
        objects.remove(0);
        return object;
    }
    
    public boolean isInPipe() {
        if(objects.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
}
